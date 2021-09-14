package com.oliver.factorial2;

public class Main {

    public static void main(String[] args) {
        // 3!
        System.out.println(factorial(3));

        // 10!
        System.out.println(factorial(10));

        // Allt över 12! ger int overflow
        System.out.println(factorial(12));
    }

    private static int factorial(int x) {
        // enligt uppgift är 0! = 1
        if (x == 0) return 1;

        // Använd temp som räknare som går från x -> 1
        int temp = x;

        // Multiplicera x med alla siffror mellan x och 1
        while (temp != 1) {
            x *= --temp;
        }

        return x;
    }
}
