package com.oliver.adv.Game.Items;

import com.oliver.adv.Game.AttackEntities.AttackEntity;

public class Weapon extends Item {
    private final int increaseDamage;

    public int GetDamageIncrease() {
        return increaseDamage;
    }

    public Weapon(String name, String description, int increaseDamage) {
        super(name, description);
        this.increaseDamage = increaseDamage;
    }

    @Override
    public void Pickup(AttackEntity entity) {

    }
}
