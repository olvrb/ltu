package com.oliver.övningsuppgifter;

public class Person {
    String namn;
     public Person(String namn) {
        this.namn = namn;
    }

    public void skrivNamn() {

    }

    public static Person instance() {
         return new Person("test");
    }
}
