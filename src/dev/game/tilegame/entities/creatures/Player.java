package dev.game.tilegame.entities.creatures;

import dev.game.Handler;
import dev.game.tilegame.gfx.Animation;
import dev.game.tilegame.gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Fang Lai on 6/4/2017.
 */
public class Player extends Creature {

    //Animation
    private Animation animDown, animUp, animLeft, animRight;

    public Player(Handler handler, float x, float y){
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_HEIGHT);
        initPlayer();
    }

    public Player(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        initPlayer();
    }

    private void initPlayer(){
//        bounds.x = 4;
//        bounds.y = 4;
//        bounds.width = 24;
//        bounds.height = 24;
        animDown = new Animation(300, Assets.player_down);
        animUp = new Animation(300, Assets.player_up);
        animLeft = new Animation(300, Assets.player_left);
        animRight = new Animation(300, Assets.player_right);
    }

    @Override
    public void tick() {
        //Animation
        animDown.tick();

        //move
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
    }

    private void getInput(){
        xMove = 0;
        yMove = 0;

        if(handler.getKeyManager().up){
            yMove = -speed;
        }
        if(handler.getKeyManager().down){
            yMove = speed;
        }
        if(handler.getKeyManager().left){
            xMove = -speed;
        }
        if(handler.getKeyManager().right){
            xMove = speed;
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
    }

    private BufferedImage getCurrentAnimationFrame(){
        if(xMove < 0){
            return animLeft.getCurrentFrame();
        }else if(xMove > 0){
            return animRight.getCurrentFrame();
        }else if(yMove < 0){
            return animDown.getCurrentFrame();
        }else if(yMove > 0){
            return animUp.getCurrentFrame();
        }else{
            return Assets.player_stand;
        }
    }
}
