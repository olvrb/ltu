package com.oliver.kassasystem;

import com.oliver.kassasystem.Money.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        CollectionOfMoney change = new CollectionOfMoney();

        // Declare all types of possible bills & coins
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

        System.out.println(change.Sum());
    }
}
