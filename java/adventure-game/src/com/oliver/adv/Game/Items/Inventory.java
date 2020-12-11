package com.oliver.adv.Game.Items;

import com.oliver.adv.Game.Item;

import java.util.ArrayList;
import java.util.Arrays;

public class Inventory {
    private ArrayList<Item> items;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    public void Add(Item item) {
        items.add(item);
    }
    public Item[] GetItems() {
        return items.toArray(Item[]::new);
    }
}
