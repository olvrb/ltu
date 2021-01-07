package com.oliver.adv.Game.AttackEntities;

import com.oliver.adv.Game.Door;
import com.oliver.adv.Game.Items.Item;
import com.oliver.adv.Helpers.FightResult;
import com.oliver.adv.Game.Items.Inventory;
import com.oliver.adv.Game.Items.Key;
import com.oliver.adv.Game.Items.Weapon;

import java.util.Arrays;

public abstract class AttackEntity {
    private String name;
    private int hp;
    private int damage;
    private int maxHp;
    private Inventory inventory;

    // If no maxHp is provided, the given hp is assumed to be maxHp.
    public AttackEntity(String name, int hp, int damage, Item[] items) {
        this(name, hp, damage, items, hp);
    }

    public AttackEntity(String name, int hp, int damage, Item[] items, int maxHp) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
        this.inventory = new Inventory(items);
        this.maxHp = maxHp;
    }

    public void PickupItem(Item item) {
        // Add item to entity's inventory and trigger its effect immediately.
        System.out.printf("%s picked up a %s\n", this.getName(), item.getName());
        item.Pickup(this);
        this.inventory.Add(item);
    }

    public void UnlockDoor(Door door) {
        door.Unlock(getKey());
    }

    public void Attack(AttackEntity opponent) {
        // Stop entity from attacking if dead =)
        int i = 0;
        while (this.Alive() && opponent.Alive()) {
            // Every other iteration attacker changes.
            if (i % 2 == 0) {
                opponent.Damage(this);
            } else {
                this.Damage(opponent);
            }

            i++;
        }

        // Deduce winner and loser
        FightResult result = getWinner(this, opponent);

        AttackEntity loser = result.getLoser();
        AttackEntity winner = result.getWinner();

        // Run death sequence thing for loser
        loser.DropInvetoryTo(winner);

        System.out.printf("%s wins! %s has %shp left.\n", winner.getName(), winner.getName(), winner.getHp());
    }

    // Returns damage dealt.
    public void Damage(AttackEntity entity) {
        // Avoid going under 0.
        if (this.getHp() - entity.getDamage() <= 0) {
            this.hp = 0;
        } else {
            // Subtract damage from hp.
            this.hp -= entity.getDamage();

            System.out.printf("%s attacks %s for %s damage!\n", entity.getName(), this.getName(), entity.getDamage());
        }
    }

    public void DropInvetoryTo(AttackEntity opponent) {
        // Pick up every item dropped.
        for (Item i : this.inventory.GetItems()) {
            opponent.PickupItem(i);
        }
    }

    public void RestoreHealth() {
        this.hp = maxHp;
    }

    public boolean Alive() {
        return this.hp >= 1;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }


    private int getDamage() {
        // Start with base damage.
        int tempDamage = damage;

        for (Item w : inventory.GetItems()) {
            // If item is a Weapon, count its damage increase.
            if (w instanceof Weapon) {
                tempDamage += ((Weapon)w).GetDamageIncrease();
            }
        }
        return tempDamage;
    }


    private Key getKey() {
        // Find first item that is a key, else null.
        return (Key)Arrays.stream(this.inventory.GetItems())
                          .filter(x -> x instanceof Key)
                          .findFirst()
                          .orElse(null);
    }

    private static FightResult getWinner(AttackEntity one, AttackEntity two) {
        // Self explanatory...
        // Winner is entity with highest hp, loser is entity with least hp.
        return new FightResult(one.getHp() > two.getHp() ? one : two,
                                             one.getHp() > two.getHp() ? two : one);
    }
}
