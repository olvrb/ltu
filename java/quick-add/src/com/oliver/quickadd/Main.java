package com.oliver.quickadd;

import java.util.Timer;

public class Main {

    public static void main(String[] args) {
        long start1 = System.nanoTime();
        quickAdd(100, 100);
        long end1 = System.nanoTime();

        long start2 = System.nanoTime();
        normalAdd(100, 100);
        long end2 = System.nanoTime();
        System.out.printf("%sns, %sns", end1 - start1, end2 - start2);
    }

    public static int normalAdd(int i, int j) {
        return i + j;
    }

    public static int quickAdd(int i, int j) {
        return (i >> 2 + j >> 2) * 2;
    }
}
