package com.oliver.kassasystem;

import com.oliver.kassasystem.Money.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        CollectionOfMoney change = new CollectionOfMoney();
        Money[] possibilities = new Money[] {
                new Money(1000),
                new Money(500),
                new Money(200),
                new Money(100),
                new Money(50),
                new Money(20),
                new Money(2),
                new Money(1)
        };


        System.out.print("Enter price: ");
        int i = scan.nextInt();
        System.out.print("Enter how much paid: ");
        int calc = i - scan.nextInt();


        for (Money m : possibilities) {
            while (calc >= m.Type) {
                m.Amount++;
                calc -= m.Type;
            }
            change.AddMoney(m);
        }

        /*
        int[] possibilities = new int[] {
                1000,
                500,
                200,
                100,
                50,
                20,
                2,
                1
        };
        for (int n : possibilities) {
            while (calc >= n) {
                switch (n) {
                    case 1000 -> change.Tusen.Value++;
                    case 500 -> change.FemHundra.Value++;
                    case 200 -> change.TvaHundra.Value++;
                    case 100 -> change.EttHundra.Value++;
                    case 50 -> change.Femtio.Value++;
                    case 20 -> change.Tjugio.Value++;
                    case 2 -> change.Tva.Value++;
                    case 1 -> change.Ett.Value++;
                };
                calc -= n;
            }
        }

         */


        /*

        while (calc >= 1000) {
            change.Tusen++;

            calc -= 1000;
        }

        while (calc >= 500) {
            change.FemHundra++;

            calc -= 500;
        }

        while (calc >= 200) {
            change.TvaHundra++;

            calc -= 200;
        }

        while (calc >= 100) {
            change.EttHundra++;
            calc -= 100;
        }
        while (calc >= 50) {
            change.Femtio++;

            calc -= 50;
        }
        while (calc >= 20) {
            change.Tjugio++;

            calc -= 20;
        }
        while (calc >= 2) {
            change.Tva++;

            calc -= 2;
        }
        while (calc >= 1) {
            change.Ett++;
            calc--;
        }

         */
        System.out.println(change.Sum());

        System.out.println(change);

    }
}
