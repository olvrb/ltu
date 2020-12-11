package com.oliver.gym;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class PersonnummerUtils {
    public static boolean CheckPnr(ArrayList<Integer> pnr) {
        // Ta fram kontroll, sen ta bort från uträkning
        int control = pnr.get(pnr.size() - 1);
        pnr.remove(pnr.size() - 1);

        // gå igenom alla nummer och gångra med varannan med två
        int i = 0;
        while (i < pnr.size()) {
            if (i % 2 == 0) {
                pnr.set(i, pnr.get(i) * 2);
            }
            i++;
        }

        // Dela på tal med 2 eller fler siffror, Addera alla siffror med varandra.
        int sum = 0;
        for (int j : pnr) {
            // Convertera till char[] för att få alla siffror individuellt, sen convertera tillbaks till int och addera till sum.
            char[] nums = String.valueOf(j).toCharArray();
            for (char c : nums) {
                sum += Character.getNumericValue(c);
            }
        }


        // Två lösningar
        // Summa + kontroll är delbart med 10.
        return (sum + control) % 10 == 0;

        // Summa avrundat upp till 10 - summa = control
        // return Math.ceil(sum / 10.0) * 10 - sum == control;
    }

    public static ArrayList<Integer> StringToIntArray(String pnr) {
        Integer[] arr = new Integer[pnr.length()];
        for (int i = 0; i < pnr.length(); i++) {
            // Char to int
            arr[i] = pnr.charAt(i) - '0';
        }
        return new ArrayList<>(Arrays.asList(arr));
    }
}