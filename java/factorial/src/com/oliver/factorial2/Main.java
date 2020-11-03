package com.oliver.factorial2;

public class Main {

    public static void main (String[] args) {
        System.out.println(factorial(10));
    }

    private static int factorial (int num) {
        if (num == 0)
            return 1;
        int temp = num;
        while (temp != 1) {
            num *= --temp;
        }
        return num;
    }
}
