package com.oliver.designpatterns;

public class SquarePegAdapter extends RoundPeg {
    private SquarePeg squarePeg;

    public SquarePegAdapter(SquarePeg peg) {
        this.squarePeg = peg;
    }

    @Override
    public double getRadius() {
        return (Math.sqrt(Math.pow(squarePeg.getWidth() / 2, 2) * 2));
    }
}
