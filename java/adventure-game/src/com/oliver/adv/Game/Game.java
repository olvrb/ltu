package com.oliver.adv.Game;

import com.oliver.adv.Game.Items.*;
import com.oliver.adv.Game.AttackEntities.*;
import com.oliver.adv.*;

import java.util.Scanner;


/* Assumptions */

// Available directions do not need to be printed, as that is depicted on the map

// No support for choosing player's name

// Room size is not depicted

// Missing blocks in example drawing are just red squares on map

// A user will have their weapon in their hand, and it will still be in their inventory.

public class Game {
    private Player player;
    public Room[][] rooms;
    private Room currentRoom;
    private Scanner scan;


    public void StartGame() {
        // TODO: allow user to input name before starting game.
        player = new Player(10, 1, new Item[0], "Sirius");
        scan = new Scanner(System.in);


        // Rooms are set up in a 3x3 grid. Can be changed later, just to fit the required game.
        // A rectangular grid is required.
        rooms = new Room[3][3];
        // x: 0, y: 0
        rooms[0][0] = new Room(new Point(0, 0),
                               "You see a dead body on the floor.",
                               new Weapon("Sword", "A long blade of death", 1),
                               null,
                               new Door[] {
                                       new Door('e', false),
                                       new Door('s', false)
                               });
        // x: 0, y: 1
        rooms[0][1] = new Room(new Point(0, 1),
                               "The room is lit by a few candles sitting on a table in front of you.",
                               null,
                               null,
                               new Door[] {
                                       new Door('n', false),
                                       new Door('s', false)
                               });
        // x: 0, y: 2
        rooms[0][2] = new Room(new Point(0, 2),
                               "Empty room, water dripping from the ceiling.",
                               new Key("Key", "Unlocker of doors"),
                               null,
                               new Door[] {
                                       new Door('n', false),
                                       new Door('e', false)
                               });
        // x: 1, y: 0
        rooms[1][0] = new Room(new Point(1, 0),
                               "Messy room, your spidey senses are tinglingggg.",
                               null,
                               new Monster("Generic monster", 8, 1, new Item[0], "Claude Monet"),
                               new Door[] {
                                       new Door('w', false),
                                       new Door('s', false)
                               });
        // x: 1, y: 2
        rooms[1][2] = new Room(new Point(1, 2),
                               "Potion room.",
                               new HealthPotion("Heal Potion", "Escape death."),
                               null,
                               new Door[] {
                                       new Door('e', true),
                                       new Door('w', false),
                                       new Door('n', false)
                               });
        // x: 2, y: 2
        rooms[2][2] = new Room(new Point(2, 2),
                               "Dragon room.",
                               null,
                               new Monster("DRAGON",
                                           18,
                                           1,
                                           new Item[] { new Treasure("Golden treasure", "shiny and stuff") },
                                           "amgery dragoon"),
                               new Door[] {
                                       new Door('w', false),
                                       });


    }

    public void PlayGame() {
        currentRoom = rooms[0][1];
        player.EnterRoom(currentRoom);

        // TOD: Make print room description every time player enters a new Room
        // TOD: Check for items when entering every Room
        // TOD: Check for monsters when entering every Room
        // TOD: Fight mechanics
        // TOD: Key mechanics
        // TOD: Potion mechanics
        /* TOD: maybe print a map
         * "Maybe"... Aftermath: needlessly complicated but kinda elegant. 6 hours of hell.
         */

        /* TODO if i get bored:
         * Maps as a 2d linked list? Reference which Room a Door leads to 🤔
         */


        // TODO: Make monsters drop loot

        while (true) {
            GameLoop();
        }
    }

    private void GameLoop() {
        RoomHelpers.PrintRooms(rooms, currentRoom, player);
        EnterRoom(GetDirection());
    }

    private char GetDirection() {
        return InputHelper.GetChar("Enter direction:", x -> currentRoom.IsValidDirection(x));
    }

    private void EnterRoom(char c) {
        currentRoom = GetNextRoom(c, currentRoom.getPoint());
        player.EnterRoom(currentRoom);
    }

    private Room GetNextRoom(char direction, Point current) {
        switch (direction) {
            case 'n': {
                // Pass row as search array and current position, as well as search direction.
                // Vertical search
                Point p = GetNextRoomForDirection(rooms[current.getX()], false, current.getY());
                return rooms[p.getX()][p.getY()];
            }
            case 's': {
                // Pass row as search array and current position, as well as search direction.
                // Vertical search
                Point p = GetNextRoomForDirection(rooms[current.getX()], true, current.getY());
                return rooms[p.getX()][p.getY()];
            }
            case 'e': {
                // Pass column as search array and current position, as well as search direction.
                // Horizontal search
                Point p = GetNextRoomForDirection(RoomHelpers.GetColumn(rooms, current.getY()), true, current.getX());
                return rooms[p.getX()][p.getY()];
            }
            case 'w': {
                // Pass column as search array and current position, as well as search direction.
                // Horizontal search
                Point p = GetNextRoomForDirection(RoomHelpers.GetColumn(rooms, current.getY()), false, current.getX());
                return rooms[p.getX()][p.getY()];
            }
            default:
                throw new IllegalStateException("Unexpected value: " + direction);
        }
    }

    // awayFromZero signifies if the player is moving south or west, as that is further from 0, 0.
    // If the player is moving east or north, awayFromZero will be false, as the player will be moving closer to 0, 0
    private Point GetNextRoomForDirection(Room[] arr, boolean awayFromZero, int currentIndex) {
        // Create temporary non-existant room.
        Room temp = new Room(new Point(-1, -1));


        // If moving up, start at plus one.
        // If moving down, start at minus one.
        // Prevents getting the same room as we started with.
        currentIndex = awayFromZero ? ++currentIndex : --currentIndex;

        // Avoid less than 0 values
        int i = Math.max(currentIndex, 0);

        // Go through the entire array until we find a not null room, and is not the same as the one we started with
        while (temp.getPoint()
                   .getX() == -1) {
            Room index = arr[i];
            if (index != null) temp = index;


            // Defines if we should do up, down, left, or right.
            if (awayFromZero) i++;
            else i--;
        }

        return temp.getPoint();
    }
}
