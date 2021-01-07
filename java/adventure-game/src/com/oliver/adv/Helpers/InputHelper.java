package com.oliver.adv.Helpers;

import java.util.Scanner;
import java.util.function.Predicate;

public class InputHelper {
    private static final Scanner scan = new Scanner(System.in);

    public static char GetChar(String question, Predicate<Character> condition) {
        // Temporary character which isn't a valid direction.
        char c = (char)0;
        boolean firstTime = true;

        while (!condition.test(c)) {
            if (firstTime) System.out.printf("%s ", question);
            else System.out.printf("Invalid, %s ", question);
            c = scan.nextLine()
                    .toCharArray()[0];
            firstTime = false;
        }
        return c;
    }

    public static String GetString(String question, Predicate<String> condition) {
        String s = "";

        while (!condition.test(s)) {
            System.out.printf("%s ", question);
            s = scan.nextLine();
        }
        return s;
    }

    public static boolean YesNo(String question) {
        // Get either y or n
        char c = GetChar(question, x -> Character.toLowerCase(x) == 'y' || Character.toLowerCase(x) == 'n');

        // c will always be either y or n, no need to check again.
        return c == 'y';
    }
}
