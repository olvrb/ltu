package com.oliver.factorial;

public class Main {

    public static void main(String[] args) {
	    System.out.println(factorial(3));
    }

    private static int factorial(int num) {
        if (num == 0) return 1;
        int temp = num;
        for (; num > 0; num--) {
            temp *= num;
        }
        return temp;
    }
}
