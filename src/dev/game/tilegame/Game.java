package dev.game.tilegame;

import dev.game.Handler;
import dev.game.display.Display;
import dev.game.tilegame.gfx.Assets;
import dev.game.tilegame.gfx.GameCamera;
import dev.game.tilegame.input.KeyManager;
import dev.game.tilegame.state.GameState;
import dev.game.tilegame.state.MenuState;
import dev.game.tilegame.state.State;

import java.awt.*;
import java.awt.image.BufferStrategy;


/**
 * Created by Fang Lai on 5/24/2017.
 */
public class Game implements Runnable{

    private Display display;
    private Thread thread;

    private boolean running = false;

    private BufferStrategy bs;
    private Graphics g;

    public String title;

    private int width, height;

    //States
    private State menuState;
    private State gameSate;

    //KeyManager
    private KeyManager keyManager;

    //Camera
    private GameCamera gameCamera;

    //Handler
    private Handler handler;

    public Game(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;
        keyManager = new KeyManager();
    }

    private void init(){
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        Assets.init();

        handler = new Handler(this);
        gameCamera = new GameCamera(handler, 0, 0);

        menuState = new MenuState(handler);
        gameSate = new GameState(handler);
        State.setState(gameSate);
    }

    private void tick(){
        keyManager.tick();
        if(State.getCurrentSate() != null){
            State.getCurrentSate().tick();
        }
    }

    private void render(){
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return ;
        }

        g = bs.getDrawGraphics();
        //clear screen
        g.clearRect(0, 0, width, height);

        //draw
        if(State.getCurrentSate() != null){
            State.getCurrentSate().render(g);
        }


        //show
        bs.show();
        g.dispose();
    }

    public void run(){
        init();

        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();


        while(running){
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            lastTime = now;
            if(delta >= 1){
                tick();
                render();
                delta--;
            }
        }

        stop();
    }

    public KeyManager getKeyManager(){
        return keyManager;
    }

    public GameCamera getGameCamera(){
        return gameCamera;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public synchronized void start(){
        if (running){
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop(){
        if (!running) {
            return;
        }
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
