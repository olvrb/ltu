package com.oliver.adv.Game;

import com.oliver.adv.Game.Items.Key;

public class Door {
    private char position;
    private boolean locked;

    public Door(char position, boolean locked) {
        this.position = position;
        this.locked = locked;
    }

    public char getPosition() {
        return position;
    }

    public void Unlock(Key key) {
        if (key == null) System.out.printf("No key, can't open door :(\n");
        else {
            System.out.println("Door unlocked!");
            this.locked = false;
        }

    }

    public boolean IsLocked() {
        return locked;
    }
}
