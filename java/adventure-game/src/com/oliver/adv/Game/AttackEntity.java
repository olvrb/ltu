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

    public void PickupItem(Item item) {
        System.out.printf("%s picked up %s", this.name, item.getName());
        this.items.add(item);
    }

    public void Attack(AttackEntity opponent) {
        // TODO: Implement fight mechanics

        int i = 0;
        while (this.Alive() && opponent.Alive()) {
            // Every other iteration attacker changes
            if (i % 2 == 0) {
                opponent.Damage(this);
            } else {
                Damage(opponent);
            }

            i++;
        }
    }

    // Returns damage dealt
    public void Damage(AttackEntity entity) {
        int damage = 0;
        // Avoid going under 0.
        if (this.hp - entity.getDamage() <= 0) {
            this.hp = 0;
            damage = 0;
        } else {
            this.hp -= entity.getDamage();
            damage = entity.getDamage();
        }

        System.out.printf("%s attacks %s for %s damage!", entity.name, this.name, damage);
    }

    public boolean Alive() {
        return this.hp >= 1;
    }

    // TODO: Implement weapon extra damage
    private int getDamage() {
        return damage;
    }

    private static AttackEntity GetWinner(AttackEntity one, AttackEntity two) {
        // One will always be over the other
        return one.hp > two.hp ? one : two;
    }
}
