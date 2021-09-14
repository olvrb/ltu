package com.oliver.övningsuppgifter;

import com.oliver.övningsuppgifter.why.Svara;
import com.oliver.övningsuppgifter.why.Svarar;
import com.oliver.övningsuppgifter.why.Tenta;
import com.oliver.övningsuppgifter.why2.Question;
import com.oliver.övningsuppgifter.why2.X;

public class Tenta2 {
    public static void main(String[] args) {

/*        for (int i = 1; i <= 2; i++) {
            for (int j = 1; j <= 3; j++) {
                for (int k = 0; k <= 4; k++) {
                    System.out.print("*");
                    k++;
                }
                System.out.print("!");
            }
            System.out.print("?");
            if (i == 1) break;
        }*/


        /*for (int i = 1; i<=2; i++) {
            for (int j = 1; j<=2; j++) {
                for (int k = 1; k<=2; k+=2) {
                    System.out.print("*");
                    System.out.print("!");
                }
            }
            System.out.print("?");
        }*/

        /*try {
            int n = 7;
            if (n > 0) {
                throw new Exception();
            } else if (n<0) {
                throw new NegativeNumberException();
            } else {
                System.out.println("Hejsan!");
            }
        } catch (NegativeNumberException e) {
            System.out.println("Första fångsten.");
        } catch (Exception e) {
            System.out.println("Andra fångsten.");
        }
        System.out.println("Slut på koden.");*/


        /*int[] arr = new int[5];
        int j = 0;
        for (int el : arr) {
            el = ++j * 2;
        }
        for (int i : arr) {
            System.out.print(i);
        }*/


        /*int[] arr = new int[5];
        int j = 0;
        for (int i = 0; i < 5; i++) {
            arr[i] = ++j * 2;
        }

        for (int i : arr) {
            System.out.print(i);
        }*/

       /* Heltal[] arr = {
                new Heltal(1),
                new Heltal(2),
                new Heltal(3)
        };

        enMetod(arr[0], arr[1], arr[2]);

        System.out.println(arr[0].toString() + arr[1].toString() + arr[2].toString());*/


        /*int[] arr = {1, 2, 3};
        enMetod(arr);

        System.out.println(arr[0] + arr[1] + arr[2]);*/


        /*int[] arr = {
                1,
                2,
                3
        };
        enMetod(arr[0], arr[1], arr[2]);

        System.out.println(arr[0] + arr[1] + arr[2]);*/

        // new Person("Svante").skrivNamn();


        /*int[] arr = {
                1,
                2,
                3
        };
        System.out.print(enMetod(arr[0], arr[1], arr[2]));*/


        /*Tenta[] arr = new Tenta[] {new Svara(), new Svarar() };

        System.out.println(arr[1].answer());*/


        Tenta[] arr = new Tenta[] {new Svara(), new Svarar() };

        for (Tenta i : arr) {
            System.out.print(i.answer());
        }

        test((Question)new Person("test"));

    }

    public static void test(Question q) {

    }


    public static int enMetod(int x, int y, int z) {
        int temp = x;
        x = 6;
        z = temp;
        return x + y;
    }

/*    public static void enMetod(int x, int y, int z) {
        int temp = x;
        x = 5;
        y = temp;
    }

    public static void enMetod(Heltal x, Heltal y, Heltal z) {
        int temp = x.value;
        x.value = 5;
        y.value = temp;
    }

    public static void enMetod(int[] numbers) {
        int temp = numbers[0];
        numbers[0] = numbers[2];
        numbers[1] = temp;
    }*/


}
