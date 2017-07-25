package dev.game;

import dev.game.tilegame.Game;
import dev.game.tilegame.gfx.GameCamera;
import dev.game.tilegame.input.KeyManager;
import dev.game.tilegame.worlds.World;

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
