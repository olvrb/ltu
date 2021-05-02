package com.oliver.designpatterns;

public class SquarePeg {
    private double height;
    private double width;

    public SquarePeg(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double getSquare() {
        return Math.pow(this.width, 2);
    }
}
