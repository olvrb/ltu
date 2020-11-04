package com.oliver.gym;

import java.util.ArrayList;
import java.util.Arrays;

import static com.oliver.gym.PersonnummerUtils.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(CheckPnr(new ArrayList<Integer>(Arrays.asList(8, 1, 1, 2, 1, 8, 9, 8, 7, 6))));
        System.out.println(CheckPnr(new ArrayList<Integer>(Arrays.asList(0, 2, 0, 4, 1, 5, 0, 0, 7, 2))));

        ArrayList<Integer> integers = StringToIntArray("0204150072");
        Gym gym = new Gym();

    }
}
