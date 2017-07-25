package dev.game.tilegame;

import dev.game.display.Display;

/**
 * Created by Fang Lai on 5/23/2017.
 */
public class Laucher {

    public static void main(String[] args){
        Game game = new Game("Title", 800, 600);
        game.start();
    }

}
