package com.oliver.adv.Game;

import com.oliver.adv.Game.AttackEntities.Monster;
import com.oliver.adv.Game.AttackEntities.Player;
import com.oliver.adv.Game.Items.Door;
import com.oliver.adv.Point;

public class Room {
    private Point point;

    private Door[] doors;

    // Will be null if no item.
    private Item item;

    // Will be null if no monster.
    private Monster monster;


    private String description;

    public Point getPoint() {
        return point;
    }


    public void DoBattle() {

    }

    public void DoNarrative() {

    }

    public Room(Point point, String description, Item item, Monster monster, Door[] doors) {
        this.point = point;
        this.description = description;
        this.item = item;
        this.monster = monster;
        this.doors = doors;
    }

    public Room(Point point) {
        this.point = point;
    }

    public void EnterRoom(Player player) {
        System.out.println(description);
        RoomChecks(player);
    }

    private void RoomChecks(Player player) {
        if (monster != null) {
            // Monster attacks player.
            // Fight plays out
            monster.Attack(player);
        }
        if (item != null) {
            // TODO: Handle item.
            // Give user item.
            player.PickupItem(this.item);

            // Remove item from room so it can't be picked up twice.
            this.item = null;
        }
    }
}
