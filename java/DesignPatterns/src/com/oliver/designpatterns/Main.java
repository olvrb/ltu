package com.oliver.designpatterns;

public class Main {

    public static void main(String[] args) {
        RoundHole hole = new RoundHole(7);

        RoundPeg roundPeg = new RoundPeg(5);
        RoundPeg roundPeg2 = new RoundPeg(10);

        SquarePeg squarePeg = new SquarePeg(2, 2);
        SquarePeg squarePeg2 = new SquarePeg(10, 10);

        System.out.printf("roundPeg fits inside hole: %s\n", hole.fits(roundPeg));
        System.out.printf("roundPeg2 fits inside hole: %s\n", hole.fits(roundPeg2));

        System.out.printf("squarePeg fits inside hole: %s\n", hole.fits(new SquarePegAdapter(squarePeg)));
        System.out.printf("squarePeg2 fits inside hole: %s\n", hole.fits(new SquarePegAdapter(squarePeg2)));
    }
}
