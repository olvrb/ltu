package com.oliver.adv.Helpers;

import com.oliver.adv.Game.AttackEntities.AttackEntity;
import com.oliver.adv.Game.Room;

import java.util.Arrays;

public class RoomHelpers {

    // Get the column of a given index from a 2d array.
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

    public static void PrintRooms(Room[][] rooms, Room currentRoom, AttackEntity player) {
        int i = 0;
        while (i < rooms.length) {
            for (Room room : GetColumn(rooms, i)) {
                // If room exists,
                // print blue if player is in room
                // print green if room has been discovered by player
                // print white if nothing else

                // If room doesn't exist, print empty space.
                if (room != null) {
                    if (currentRoom == room)
                        System.out.print(AnsiColors.ANSI_BLUE + "□\t" + AnsiColors.ANSI_RESET);
                    else if (Arrays.asList(room.GetDiscoverers()).contains(player))
                        System.out.print(AnsiColors.ANSI_GREEN + "□\t" + AnsiColors.ANSI_RESET);
                    else
                        System.out.print(AnsiColors.ANSI_WHITE + "□\t" + AnsiColors.ANSI_RESET);
                } else {
                    System.out.print(AnsiColors.ANSI_RED + "\t" + AnsiColors.ANSI_RESET);
                }


            }
            System.out.println();
            i++;
        }
    }


}
