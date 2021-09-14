#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Mon Sep 13 12:47:58 2021

@author: christer
"""


import gmpy2
from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives.asymmetric import rsa
from cryptography.hazmat.primitives import serialization
import hashlib
from cryptography.hazmat.primitives.ciphers import Cipher, algorithms, modes
from cryptography.hazmat.backends import default_backend


# Methods for encryption/decryption

def simple_rsa_encrypt(message, publickey):
    numbers = publickey.public_numbers()

    return gmpy2.powmod(message, numbers.e, numbers.n)

def simple_rsa_decrypt(cipher, privatekey):
    numbers = privatekey.private_numbers()
    return gmpy2.powmod(cipher, numbers.d, numbers.public_numbers.n)

def int_to_bytes(i):
    # i might be a gmpy2 big integer; convert back to a Python int
    i = int(i)
    return i.to_bytes((i.bit_length()+7)//8, byteorder='big')

def bytes_to_int(b):
    return int.from_bytes(b, byteorder='big')

# We start by generatin the keys, the private key is kept secret
# and the publi key is given to peers communicated with.

# Generate a private key.
private_key = rsa.generate_private_key(
     public_exponent=65537,
     key_size=4096,
     backend=default_backend()
)

# Extract the public key from the private key.
public_key = private_key.public_key()

# Convert the private key into bytes. We won't encrypt it this time.
private_key_bytes = private_key.private_bytes(
    encoding=serialization.Encoding.PEM,
    format=serialization.PrivateFormat.TraditionalOpenSSL,
    encryption_algorithm=serialization.NoEncryption()
)

# Convert the public key into bytes.
public_key_bytes = public_key.public_bytes(
    encoding=serialization.Encoding.PEM,
    format=serialization.PublicFormat.SubjectPublicKeyInfo
)

# Convert the private key bytes back to a key.
# Because there is no encryption of the key, there is no password.
private_key = serialization.load_pem_private_key(
    private_key_bytes,
    backend=default_backend(),
    password=None)

public_key = serialization.load_pem_public_key(
    public_key_bytes,
    backend=default_backend())



# THIS IS JUST FOR TRAINING (DO NOT USE THIS FOR REAL CRYPTOGRAPHY)


import socket

msgFromP1       = "Hello P2, are you ready to start?"
bytesToSend         = str.encode(msgFromP1)
serverAddressPort   = ("127.0.0.1", 3010)
bufferSize          = 16384

 

# Create a UDP socket
UDPClientSocket = socket.socket(family=socket.AF_INET, type=socket.SOCK_DGRAM)


# Send public key int first
print("Sending public key int")
public_key_ints = str(private_key.public_key().public_numbers().n).encode()
UDPClientSocket.sendto(public_key_ints, serverAddressPort)


# Then send public key int hash
print("Sending public key int hash")
sha256_hasher= hashlib.sha256(public_key_ints)
public_key_hash = sha256_hasher.hexdigest()

UDPClientSocket.sendto(public_key_hash.encode(), serverAddressPort)

# Wait for encrypted aes key
msgFromServer = UDPClientSocket.recvfrom(bufferSize)

encrypted_aes_key_ints = int(msgFromServer[0])
aes_key = int_to_bytes(simple_rsa_decrypt(encrypted_aes_key_ints, private_key))


# Init aes
aesCipher = Cipher(algorithms.AES(aes_key),
                   modes.ECB(),
                   backend=default_backend())
aesEncryptor = aesCipher.encryptor()
aesDecryptor = aesCipher.decryptor()



# Encrypt message, then send
while 1:
    # Send encrypted message
    message = input("Enter a message to send to P2: ").encode()
    message += b" " * (-len(message) % 16) # Padding to full blocks of 16 bytes 

    ciphertext = aesEncryptor.update(message)

    bytesToSend = ciphertext
    UDPClientSocket.sendto(bytesToSend, serverAddressPort)
    

    # Wait for response
    msgFromServer = UDPClientSocket.recvfrom(bufferSize)
    return_message = aesDecryptor.update(msgFromServer[0]).strip()
    print(f'Message from P2: {return_message}')

