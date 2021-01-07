package com.oliver.adv.Helpers;

// Helper class simply to store x & y coordinates.
public class Point {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Point p) {
        return p.getX() == this.x && p.getY() == this.y;
    }
}
