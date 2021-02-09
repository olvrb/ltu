package com.oliver.todolist;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

public class NotepadIO {
    private static final Scanner scan = new Scanner(System.in);

    public static int GetInt(String question, Predicate<Integer> condition) {
        // Temporary character which isn't a valid direction.
        int i = -1;
        boolean firstTime = true;

        while (!condition.test(i)) {
            if (firstTime) System.out.printf("%s ", question);
            else System.out.printf("Invalid, %s ", question);
            i = Integer.parseInt(scan.nextLine());
            firstTime = false;
        }
        return i;
    }

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

    public static boolean YesNo(String question) {
        // Get either y or n
        char c = GetChar(question, x -> Character.toLowerCase(x) == 'y' || Character.toLowerCase(x) == 'n');

        // c will always be either y or n, no need to check again.
        return c == 'y';
    }

    public static String GetString(String question) {
        System.out.printf("%s ", question);
        return scan.nextLine();
    }

    public static ArrayList<Note> GetNotes() {
        String input;
        ArrayList<Note> notes = new ArrayList<>();
        while (!(input = GetString("Enter note: ")).equals("x")) {
            notes.add(new Note(input));
        }

        return notes;
    }

    public static void PrintNotes(ArrayList<Note> notes) {
        int i = 0;
        for (Note n : notes) {
            if (n.isDone()) System.out.printf(AnsiColors.ANSI_GREEN + "⊠ %s. %s\n" + AnsiColors.ANSI_RESET, i, n.getContents());
            else System.out.printf(AnsiColors.ANSI_RED + "□ %s. %s\n" + AnsiColors.ANSI_RESET, i, n.getContents());
            i++;
        }
    }
}
