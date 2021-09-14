#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Mon Sep 13 12:45:02 2021

@author: christer
"""
# P2 acts as a server due to the while loop, listening to a dedicated port.
# In this lab, P2 will both initiate sending messages and respond to messages 
# so you need to implement that. For how to initiate a communication, see P1.py.
# Good luck!  

import socket
import hashlib
import gmpy2
from cryptography.hazmat.primitives.ciphers import Cipher, algorithms, modes
from cryptography.hazmat.backends import default_backend



def simple_rsa_encrypt(message, publickey):
    return gmpy2.powmod(message, 65537, publickey)

def bytes_to_int(b):
    return int.from_bytes(b, byteorder='big')


myIP     = "127.0.0.1"
myPort   = 3010
bufferSize  = 16384
serverAddressPort   = ("127.0.0.1", 3010)

 

msgFromServer       = "Hi P1, Applied Computer Science P2 here, I hope all is secured on your side."
bytesToSend         = str.encode(msgFromServer)

 

# Create a datagram socket and bind to an IP address and port
UDPServerSocket = socket.socket(family=socket.AF_INET, type=socket.SOCK_DGRAM)
UDPServerSocket.bind((myIP, myPort))

 

print("P2 is up running and ready to go!")

 



# Wait for public key
bytesAddressPair = UDPServerSocket.recvfrom(bufferSize)
message = bytesAddressPair[0]
address = bytesAddressPair[1]

public_key_ints = int(message.decode())




# Wait for hash
bytesAddressPair = UDPServerSocket.recvfrom(bufferSize)
message = bytesAddressPair[0]

hash = message.decode()



print(f'Received hash: {hash}\nComputed hash: {hashlib.sha256(str(public_key_ints).encode()).hexdigest()}')
# Verify hash
if hashlib.sha256(str(public_key_ints).encode()).hexdigest() == hash:
    print("Hash matched")



# Send encrypted aes key
print("Sending encrypted aes key")
aes_key = b'InformationSecurity M.Sc'
aes_key_ints = bytes_to_int(aes_key)

encrypted_aes_key = str(simple_rsa_encrypt(aes_key_ints, public_key_ints)).encode()

UDPServerSocket.sendto(encrypted_aes_key, address)


# Init aes
aesCipher = Cipher(algorithms.AES(aes_key),
                   modes.ECB(),
                   backend=default_backend())
aesEncryptor = aesCipher.encryptor()
aesDecryptor = aesCipher.decryptor()


# Encrypt message, then send
while 1:
    # Wait for response
    msgFromServer = UDPServerSocket.recvfrom(bufferSize)
    return_message = aesDecryptor.update(msgFromServer[0]).strip()
    print(f'Message from P1: {return_message}')
    

    # Send encrypted message
    message = input("Enter a message to send to P1: ").encode()
    message += b" " * (-len(message) % 16) # Padding to full blocks of 16 bytes 

    ciphertext = aesEncryptor.update(message)

    bytesToSend = ciphertext
    UDPServerSocket.sendto(bytesToSend, address)
