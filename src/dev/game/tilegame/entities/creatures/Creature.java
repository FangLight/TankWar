package dev.game.tilegame.entities.creatures;

import dev.game.Handler;
import dev.game.tilegame.entities.Entity;
import dev.game.tilegame.tiles.Tile;

/**
 * Created by Fang Lai on 6/4/2017.
 */
public abstract class Creature extends Entity {

    public static final int DEFAULT_HEALTH = 10;
    public static final float DEFAULT_SPEED = 3.0f;
    public static final int DEFAULT_CREATURE_WIDTH = 32, DEFAULT_HEIGHT = 32;

    protected int health;
    protected float speed;
    protected float xMove, yMove;

    public Creature(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        health = DEFAULT_HEALTH;
        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
    }

    public void move(){
        moveX();
        moveY();
    }

    public void moveX(){
        if(xMove > 0){
            int tx = (int)(x + xMove + bounds.x + bounds.width) / Tile.TILE_WIDTH;
            if(!collisionWithTile(tx, (int)(y + bounds.y) / Tile.TILE_HEIGHT)
                    && !collisionWithTile(tx, (int)((y + bounds.y + bounds.height) / Tile.TILE_HEIGHT))){
                x += xMove;
            }else{
                x = tx * Tile.TILE_WIDTH - bounds.width - bounds.x - 1;
            }
        }else if(xMove < 0){
            int tx = (int)(x + xMove + bounds.x) / Tile.TILE_WIDTH;
            if(!collisionWithTile(tx, (int)(y + bounds.y) / Tile.TILE_HEIGHT)
                    && !collisionWithTile(tx, (int)((y + bounds.y + bounds.height) / Tile.TILE_HEIGHT))){
                x += xMove;
            }else{
                x = tx * Tile.TILE_WIDTH + Tile.TILE_WIDTH - bounds.x + 1;
            }
        }
    }

    public void moveY(){
        if(yMove > 0){
            int ty = (int)(y + yMove + bounds.y + bounds.height) / Tile.TILE_HEIGHT;
            if(!collisionWithTile((int)((x + bounds.x) / Tile.TILE_HEIGHT), ty)
                    && !collisionWithTile((int)((x + bounds.x + bounds.width) / Tile.TILE_HEIGHT), ty)){
                y += yMove;
            }else{
                y = ty * Tile.TILE_HEIGHT - bounds.y - bounds.height - 1;
            }
        }else if(yMove < 0){
            int ty = (int)(y + yMove + bounds.y) / Tile.TILE_HEIGHT;
            if(!collisionWithTile((int)(x + bounds.x) / Tile.TILE_HEIGHT, ty)
                    && !collisionWithTile((int)((x + bounds.x + bounds.width) / Tile.TILE_HEIGHT), ty)){
                y += yMove;
            }else{
                y = ty * Tile.TILE_HEIGHT + Tile.TILE_HEIGHT - bounds.y;
            }
        }
    }

    protected boolean collisionWithTile(int x, int y){
        return handler.getWorld().getTile(x, y).isSolid();
    }

    public int getHealth() {
        return health;
    }

    public float getSpeed() {
        return speed;
    }

    public float getxMove() {
        return xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }
}
