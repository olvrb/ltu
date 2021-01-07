package com.oliver.adv.Game;

import com.oliver.adv.Game.AttackEntities.AttackEntity;
import com.oliver.adv.Game.AttackEntities.Monster;
import com.oliver.adv.Game.AttackEntities.Player;
import com.oliver.adv.Game.Items.Item;
import com.oliver.adv.Game.Items.Key;
import com.oliver.adv.Helpers.InputHelper;
import com.oliver.adv.Helpers.Point;

import java.util.ArrayList;
import java.util.Arrays;

public class Room {
    // Each room stores its grid coordinates.
    private Point point;

    private Door[] doors;

    // Will be null if no item.
    private Item item;

    // Will be null if no monster.
    private Monster monster;

    // Stores every entity that has discovered the room. Is used
    private ArrayList<AttackEntity> discoveredBy;


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

        this.discoveredBy = new ArrayList<>();
    }

    public Room(Point point) {
        this.point = point;
    }

    public void EnterRoom(Player player) {
        // Mark room as discovered by player.
        this.Discover(player);

        System.out.println(description);

        // Perform room checks: monsters, items, check for locked doors.
        RoomChecks(player);
    }

    public void Discover(AttackEntity player) {
        // TODO: Check for dupes
        this.discoveredBy.add(player);
    }


    public AttackEntity[] GetDiscoverers() {
        return discoveredBy.toArray(AttackEntity[]::new);
    }

    private void RoomChecks(Player player) {
        if (monster != null) {
            // Monster attacks player.
            // Fight plays out
            monster.Attack(player);
        }

        // TODO: Maybe give user option to not pickup item...
        if (item != null) {
            // Give user item.
            player.PickupItem(this.item);

            // Remove item from room so it can't be picked up twice.
            this.item = null;
        }

        Door[] lockedDoors = LockedDoors();
        if (lockedDoors.length > 0) {

            for (Door d : lockedDoors) {
                System.out.printf("You feel the %s door. It's locked!\n", d.getPosition());
                if (InputHelper.YesNo("Unlock?")) {
                    player.UnlockDoor(d);
                }
            }
        }
    }

    private Door[] LockedDoors() {
        return Arrays.stream(this.doors)
                     .filter(Door::IsLocked)
                     .toArray(Door[]::new);
    }

    public Door GetDoor(char c, boolean isLocked) {
        Door temp = Arrays.stream(this.doors)
                          .filter(x -> x.getPosition() == c && isLocked == x.IsLocked())
                          .findFirst()
                          .orElse(null);

        return temp;
    }

    public boolean isLocked() {
        return LockedDoors().length > 0;
    }

    public boolean IsValidDirection(char c) {
        // Check if any of the doors correspond with desired direction. Filtering out locked doors.
        return Arrays.asList(Arrays.stream(this.doors)
                                   .filter(x -> !x.IsLocked())
                                   .map(Door::getPosition)
                                   .toArray(Character[]::new))
                     .contains(c);
    }

    public void UnlockDoor(char c, Key key) {
        GetDoor(c, true).Unlock(key);
    }
}
