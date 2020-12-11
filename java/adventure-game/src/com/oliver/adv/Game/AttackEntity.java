package com.oliver.adv.Game;

import com.oliver.adv.Game.Items.Inventory;
import com.oliver.adv.Game.Items.Key;
import com.oliver.adv.Game.Items.Weapon;
import com.sun.source.tree.InstanceOfTree;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class AttackEntity {
    private String name;
    private int hp;
    private int damage;
    private Inventory inventory;

    public AttackEntity(String name, int hp, int damage, Item[] items) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
        this.inventory = new Inventory();
    }

    public void PickupItem(Item item) {
        // Add item to entity's inventory
        System.out.printf("%s picked up a %s\n", this.name, item.getName());
        this.inventory.Add(item);
    }

    public void UnlockDoor(Door door) {
         door.Unlock(getKey());
    }

    public void Attack(AttackEntity opponent) {
        // Stop entity from attacking if dead =)
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

        AttackEntity winner = GetWinner(this, opponent);
        System.out.printf("%s wins! %s has %shp left.\n", winner.name, opponent.name, opponent.hp);
    }

    // Returns damage dealt
    public void Damage(AttackEntity entity) {
        // Avoid going under 0.
        if (this.hp - entity.getDamage() <= 0) {
            this.hp = 0;
        } else {
            // Subtract damage from hp
            this.hp -= entity.getDamage();

            System.out.printf("%s attacks %s for %s damage!\n", entity.name, this.name, entity.getDamage());
        }

    }

    public boolean Alive() {
        return this.hp >= 1;
    }

    private int getDamage() {
        int tempDamage = damage;
        for (Item w : inventory.GetItems()) {
            // If item is a Weapon, count its damage increase
            if (w instanceof Weapon) {
                tempDamage += ((Weapon)w).GetDamageIncrease();
            }
        }
        return tempDamage;
    }

    private Key getKey() {
        // Find first item that is a key.
        return (Key)Arrays.stream(this.inventory.GetItems())
                          .filter(x -> x instanceof Key)
                          .findFirst()
                          .orElse(null);
    }

    private static AttackEntity GetWinner(AttackEntity one, AttackEntity two) {
        // One will always be over the other
        return one.hp > two.hp ? one : two;
    }
}
