package com.oliver.adv;

import com.oliver.adv.Game.Game;
import com.oliver.adv.Game.Room;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Game game = new Game();

        game.StartGame();
        game.PlayGame();

        /*
        for (int i = 0; i < game.rooms.length; i++) {
            for (int j = 0; j < game.rooms[i].length; j++) {
                Point point = game.rooms[i][j].getPoint();
                System.out.printf("%s, %s\n",  point.getX(), point.getY());
            }
        }

         */


    }
}
