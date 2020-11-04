package com.oliver.gym;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class PersonnummerUtils {
    public static boolean CheckPnr(ArrayList<Integer> pnr) {
        int control = pnr.get(pnr.size() - 1);
        pnr.remove(pnr.size() - 1);

        int i = 0;
        while (i < pnr.size()) {
            if (i % 2 == 0) {
                pnr.set(i, pnr.get(i) * 2);
            }
            i++;
        }

        int sum = 0;
        for (int j : pnr) {
            char[] nums = String.valueOf(j).toCharArray();
            for (char c : nums) {
                sum += Character.getNumericValue(c);
            }
        }
        return (sum + control) % 10 == 0;
        // return Math.ceil(sum / 10.0) * 10 - sum == control;
    }

    public static ArrayList<Integer> StringToIntArray(String pnr) {
        Integer[] arr = new Integer[pnr.length()];
        for (int i = 0; i < pnr.length(); i++) {
            arr[i] = pnr.charAt(i) - '0';
        }
        return new ArrayList<>(Arrays.asList(arr));
    }
}


/*
def check_pnr(pnr):
    control = pnr[-1]
    del pnr[-1]

    i = 0
    while i < len(pnr):
        if i % 2 == 0:
            pnr[i] = pnr[i] * 2
        i += 1

    sum = 0
    for i in pnr:
        i = list(str(i))
        for j in i:
            sum += int(j)

    return sum + control == roundup(sum)
 */