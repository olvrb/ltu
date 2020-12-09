package com.oliver.adv;

import com.oliver.adv.Game.Room;

public class RoomHelpers {
    public static Room[] GetColumn(Room[][] rooms, int i) {
        Room[] roomColumn = new Room[rooms[0].length];
        int j = 0;
        while (j < roomColumn.length) {

            // Get every room from a column
            roomColumn[j] = rooms[j][i];
            j++;
        }

        return roomColumn;
    }
}
