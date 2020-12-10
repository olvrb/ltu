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

    public static void PrintRooms(Room[][] rooms, Room currentRoom) {
        int i = 0;
        while (i < rooms.length) {
            for (Room room : GetColumn(rooms, i)) {
                if (room != null) {
                    if (currentRoom == room)
                        System.out.print(AnsiColors.ANSI_GREEN + "□\t" + AnsiColors.ANSI_RESET);
                    else
                        System.out.print(AnsiColors.ANSI_WHITE + "□\t" + AnsiColors.ANSI_RESET);
                } else
                    System.out.print(AnsiColors.ANSI_RED + "□\t" + AnsiColors.ANSI_RESET);


            }
            System.out.println();
            i++;
        }

    }
}
