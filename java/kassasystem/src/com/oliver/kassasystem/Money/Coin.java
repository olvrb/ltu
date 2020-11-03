package com.oliver.kassasystem.Money;

public class Coin extends Money {


    public Coin(int type, int amount) {
        super(type, amount);
    }

    @Override
    public String GetPhysicalForm() {
        return "Coin";
    }
}
