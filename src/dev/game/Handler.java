package dev.game;

import dev.game.tankwar.Game;
import dev.game.tankwar.gfx.GameCamera;
import dev.game.tankwar.input.KeyManager;
import dev.game.tankwar.worlds.World;

/**
 * Created by Fang Lai on 6/25/2017.
 */
public class Handler {

    private Game game;
    private World world;

    public Handler(Game game){
        this.game = game;
    }

    public int getWidth(){
        return game.getWidth();
    }

    public int getHeight(){
        return game.getHeight();
    }

    public KeyManager getKeyManager(){
        return game.getKeyManager();
    }

    public GameCamera getGameCamera(){
        return game.getGameCamera();
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }
}
