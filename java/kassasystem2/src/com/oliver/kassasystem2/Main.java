package com.oliver.kassasystem2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Ange totalpris: ");
        int pris = scan.nextInt();

        System.out.print("Hur mycket betalar kunden? ");
        int kundBetalning = scan.nextInt();

        // Skillnaden mellan betalning och kostnad. Växel som kund ska få tillbaks
        int calc = kundBetalning - pris;

        int tusen = 0;
        int femhundra = 0;
        int tvahundra = 0;
        int hundra = 0;
        int femtio = 0;
        int tjugo = 0;
        int tva = 0;
        int ett = 0;

        if (kundBetalning == pris) { // Kolla om kund ska få växel.
            System.out.println("Kunden får inte tillbaks växel");
        } else {
            // Medans calc är mindre än tusen, lägg till en sedel till växeln.
            // Samma sak för alla sedlar och mynt ner till 1:-.
            while (calc >= 1000) {
                tusen++;
                calc -= 1000;
            }
            while (calc >= 500) {
                femhundra++;
                calc -= 500;
            }
            while (calc >= 200) {
                tvahundra++;
                calc -= 200;
            }
            while (calc >= 100) {
                hundra++;
                calc -= 100;
            }
            while (calc >= 50) {
                femtio++;
                calc -= 50;
            }
            while (calc >= 20) {
                tjugo++;
                calc -= 20;
            }
            while (calc >= 2) {
                tva++;
                calc -= 2;
            }
            while (calc >= 1) {
                ett++;
                calc -= 1;
            }

            // Skriv ut total av varje sedel och mynt.
            System.out.printf("%d tusen \n%d femhundra\n%d två hundra\n%d hundra\n%d femtio\n%d tjugo\n%d två\n%d ett", tusen, femhundra, tvahundra, hundra, femtio, tjugo, tva, ett);
        }

    }
}
