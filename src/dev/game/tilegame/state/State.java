package dev.game.tilegame.state;

import dev.game.Handler;

import java.awt.Graphics;

/**
 * Created by Fang Lai on 6/3/2017.
 */
public abstract class State {

    private static State currentSate = null;

    protected Handler handler;

    public State(Handler handler){
        this.handler = handler;
    }

    public static void setState(State state){
        currentSate = state;
    }

    public static State getCurrentSate(){
        return currentSate;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

}
