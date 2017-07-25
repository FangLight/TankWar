package dev.game.tilegame.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * Created by Fang Lai on 6/4/2017.
 */
public class Tile {

    //STATIC STUFF

    public static Tile[] tiles = new Tile[256];
    public static Tile grassTile = new GrassTile(0);
    public static Tile dirtTile = new DirtTile(1);
    public static Tile rockTile = new RockTile(2);

    //CLASS
    public static final int TILE_WIDTH = 64, TILE_HEIGHT = 64;

    protected final int id;
    protected BufferedImage texture;

    public Tile(BufferedImage texture, int id){
        this.texture = texture;
        this.id = id;

        tiles[id] = this;
    }

    public void tick(){

    }

    public boolean isSolid(){
        return false;
    }

    public void render(Graphics g, int x, int y){
        g.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null);
    }

    public int getId(){
        return id;
    }

}
