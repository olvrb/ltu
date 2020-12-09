package com.oliver.adv.Game;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class AttackEntity {
    private String name;
    private int hp;
    private int damage;
    private ArrayList<Item> items;

    public AttackEntity(String name, int hp, int damage, Item[] items) {
        this.hp = hp;
        this.damage = damage;
        this.items = new ArrayList<>(Arrays.asList(items));
    }
}
