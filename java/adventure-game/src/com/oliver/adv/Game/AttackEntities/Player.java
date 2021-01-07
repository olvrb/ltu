package com.oliver.adv.Game.AttackEntities;

import com.oliver.adv.Game.*;
import com.oliver.adv.Game.Items.Item;

public class Player extends AttackEntity {

    public Player(int hp, int damage, Item[] items, String name) {
        super(name, hp, damage, items);
    }

    public void EnterRoom(Room room) {
        room.EnterRoom(this);
    }
}
