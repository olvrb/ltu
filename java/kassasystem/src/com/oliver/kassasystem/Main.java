package com.oliver.kassasystem;

import java.util.Scanner;

public class Main {

    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        Change change = new Change();

        int i = scan.nextInt();
        int j = scan.nextInt() - i;

        while (i >= 1000) {
            change.Tusen++;

            i -= 1000;
        }

        while (i >= 500) {
            change.FemHundra++;

            i -= 500;
        }

        while (i >= 200) {
            change.TvaHundra++;

            i -= 200;
        }

        while (i >= 100) {
            change.EttHundra++;
            i -= 100;
        }
        while (i >= 50) {
            change.Femtio++;

            i -= 50;
        }
        while (i >= 20) {
            change.Tjugio++;

            i -= 20;
        }
        while (i >= 2) {
            change.Tva++;

            i -= 2;
        }
        while (i >= 1) {
            change.Ett++;
            i--;
        }

        System.out.println(change);

    }
}
