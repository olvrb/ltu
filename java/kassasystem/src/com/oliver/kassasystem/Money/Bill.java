package com.oliver.kassasystem.Money;

public class Bill extends Money {


    public Bill (int type, int amount) {
        super(type, amount);
    }

    @Override
    public String GetPhysicalForm () {
        return "Bill";
    }

}
