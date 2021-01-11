package com.oliver.adv.Game.Items;

import com.oliver.adv.Game.AttackEntities.AttackEntity;

public class HealthPotion extends Item {
    public HealthPotion(String name, String description) {
        super(name, description);
    }

    @Override
    public void Pickup(AttackEntity entity) {

        entity.RestoreHealth();
        System.out.printf("%s has restored its health to %dhp\n", entity.getName(), entity.getHp());
    }

}
