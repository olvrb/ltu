package com.oliver.test;

public class Main {

    public static void main (String[] args) {
        // write your code here

        /*
        for (int i = 0; ; i++) {
            System.out.println(String.format("%s is %s a prime number", i, isPrime(i) ? "is" : "isn't"));
        }

         */

        for (int i = 1; i < 50; i++) {
            System.out.println(fib(i));
        }
    }

    public static boolean isPrime (int n) {
        if (n <= 1) return false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;

    }

    public static int fib (int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }
}
