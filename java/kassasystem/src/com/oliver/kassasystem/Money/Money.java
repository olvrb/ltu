package com.oliver.kassasystem.Money;

public class Money {
    public int Type;
    public int Amount;

    public Money(int type, int amount) {
        this.Type = type;
        this.Amount = amount;
    }

    public Money(int type) {
        this.Type = type;
    }

    public String GetPhysicalForm() {
        return null;
    }

    public Money SetType(int val) {
        this.Type = val;
        return this;
    }

    public int GetWorth() {
        return Type * Amount;
    }
}
