package com.oliver.övningsuppgifter;

import java.util.*;

public class IngaDubletter extends Övningsuppgift {

    public void Run() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Ange alla namn: ");

        String input = scan.nextLine();

        String[] names = input.split(" ");

        names = RemoveDupesReal(names);

        System.out.println(String.join(", ", names));
    }

    private String[] RemoveDupes(String[] array) {
        Set<String> set = new HashSet<>(Arrays.asList(array));

        return set.toArray(String[]::new);
    }

    private String[] RemoveDupesReal(String[] array) {
        ArrayList<String> newArr = new ArrayList<>();

        for (String item : array) {
            if (!newArr.contains(item)) newArr.add(item);
        }

        return newArr.toArray(String[]::new);
    }
}
