package com.oliver.övningsuppgifter;

import java.util.Scanner;

public class CopyPaste extends Övningsuppgift {
    public void Run() {

        System.out.print("Ange för- och efternamn: ");
        Scanner scan = new Scanner(System.in);

        String names = scan.nextLine();

        String[] splitNames = splitNames(names);
        String firstName = splitNames[0];
        String lastName = splitNames[splitNames.length - 1];

        System.out.printf("Ditt förnamn är %s, och det innehåller %s bokstäver.\n", firstName, firstName.length());
        System.out.printf("Ditt efternamn är %s, och det innehåller %s bokstäver.\n", lastName, lastName.length());
        System.out.printf("Dina initialer är %s%s", firstName.charAt(0), lastName.charAt(0));
    }


    private String[] splitNames(String names) {
        return names.split(" ");
    }
}
