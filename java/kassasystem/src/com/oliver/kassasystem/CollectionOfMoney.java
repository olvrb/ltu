package com.oliver.kassasystem;

import com.oliver.kassasystem.Money.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CollectionOfMoney {

    public ArrayList<Money> Moneys = new ArrayList<>();

    public void AddMoney(Money m) {

        Optional<Money> temp = Moneys.stream().filter(x -> x.Type == m.Type).findFirst();
        if (temp.isPresent()) {
            temp.get().Amount++;
            return;
        }

        Moneys.add(m);
    }

    public int Sum() {
        return Moneys.stream().mapToInt(Money::GetWorth).sum();
    }
}
