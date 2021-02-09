package com.oliver.övningsuppgifter;

import java.awt.image.LookupOp;

public class Main {

    public static void main(String[] args) {

        /*
        int x = 7;
        int y = 4;
        boolean bool = false;

        if (x+y==11) {
            System.out.print("Lion, ");
        }
        if (x<y) {
            System.out.print("Monkey, ");
        }
        else if (x>6) {
            System.out.print("Parrot, ");

        } else {
            System.out.print("Crocodile, ");

        }




        int i = 2;
        while (i<29) {
            i++;
            for (int x = 0; x < 5; x++) {
                i+=x;
            }
            System.out.print(i + ", ");
        }



        System.out.println();

        int i = 1;
        while (i<23) {
            i+=8;
            System.out.print(i + ", ");
        }



        int i = 1;
        int x = 1;

        while (i<5) {
            x+=i;
            i++;
        }

        System.out.print(x + ", ");




        int[][] a = {{1, 2, 3}, {4, 5, 6, 9}, {7}};

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (i%2 != 0)
                    System.out.print(a[i][j]);
            }
        }




        String[] zoo = new String[5];
        zoo[2] = "Elephant";
        zoo[1] = "Monkey";
        zoo[3] = "Lion";
        zoo[4] = "Crocodile";

        for (int i = 0; i < 5; i++) {
            System.out.print(zoo[i] + ", ");
        }



        String[] zoo = new String[5];

        zoo[3] = "Elephant";
        zoo[2] = "Monkey";
        zoo[4] = "Lion";
        zoo[1] = "Crocodile";

        for (int i = 0; i < 5; i++) {
            if (i < 3) {
                System.out.print(zoo[i] + ", ");
            }
        }



        int[][] a = {{1, 2, 3}, {4, 5, 6, 9}, {7}};

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] % 2 != 0)
                    System.out.print(a[i][j]);
            }
        }



        int[] arr = new int[5];
        int j = 0;

        for (int i = 0; i < 5; i++) {
            arr[i] = ++j*2;
        }

        for (int i : arr) {
            System.out.print(i);
        }




        Player pl = new Player("Joakim", 25);
        System.out.print(pl.name + ", " + pl.age);





        Player player = new Player("Joakim", 25);
        System.out.print(player.name + ", " + player.age);

        new CopyPaste().Run();
        new IngaDubletter().Run();

         */


        Heltal[] arr = {
                new Heltal(1),
                new Heltal(2),
                new Heltal(3)
        };

        enMetod(arr[0], arr[1], arr[2]);

        System.out.printf("%d", arr[0].value + arr[1].value + arr[2].value);


    }

    public static void enMetod(Heltal x, Heltal y, Heltal z) {
        int temp = x.value;
        x.value = 5;
        y.value = temp;
    }


}
