package dev.game.tilegame.gfx;

import java.awt.image.BufferedImage;

/**
 * Created by Fang Lai on 7/24/2017.
 */
public class Animation {

    private int speed, index;
    private long lastTime, timer;
    private BufferedImage[] frames;

    public Animation(int speed, BufferedImage[] frames){
        this.speed = speed;
        this.frames = frames;
        index = 0;
        lastTime = System.currentTimeMillis();
        timer = 0;
    }

    public void tick(){
        timer += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();

        if(timer > speed){
            index = (++index) % frames.length;
            timer = 0;
        }
    }

    public BufferedImage getCurrentFrame(){
        return frames[index];
    }

}
