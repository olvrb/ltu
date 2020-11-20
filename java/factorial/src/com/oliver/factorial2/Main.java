package com.oliver.factorial2;

public class Main {

    public static void main(String[] args) {


        for (int i = 0; i < 10; i++) {
            System.out.println(factorial(i));
        }
    }

    private static int factorial(int num) {
        // enligt uppgift är 0! = 1
        if (num == 0)
            return 1;

        // Använd temp som räknare som går från x -> 1
        int temp = num;

        // Multiplicera x med alla siffror mellan x och 1
        while (temp != 1) {
            num *= --temp;
        }
        return num;
    }
}
