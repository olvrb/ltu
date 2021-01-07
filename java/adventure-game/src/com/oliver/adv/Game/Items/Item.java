package com.oliver.adv.Game.Items;

import com.oliver.adv.Game.AttackEntities.AttackEntity;

public abstract class Item {
    private final String name;
    private final String description;

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public abstract void Pickup(AttackEntity entity);
}
