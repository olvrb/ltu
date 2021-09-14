package com.oliver.övningsuppgifter.why;

import java.awt.geom.Point2D;

public interface Tenta {
    public final int PI = 3;
    public abstract String answer();
    public static final int PI2 = 3;

    public default void test() {
        System.out.println(this.PI);
        System.out.println("test");
    }
}
