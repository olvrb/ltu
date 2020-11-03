package com.oliver.factorial2;

public class Main {

    public static void main (String[] args) {


        for (int i = 0; i < 10; i++) {
            System.out.println(factorial(i));
        }
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
