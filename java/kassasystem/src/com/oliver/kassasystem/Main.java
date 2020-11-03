package com.oliver.kassasystem;

import javax.sound.midi.SysexMessage;

public class Main {

    public static void main(String[] args) {
	// write your code here

        System.out.println("Hello, World!");
        System.out.println("Hello, World!");


        for (int i = 0; i < 10; i++) {
            System.out.println(fibonacci(i));
        }
    }

    static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
