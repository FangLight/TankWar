package dev.game.tilegame.worlds;

import dev.game.Handler;
import dev.game.tilegame.entities.EntityManager;
import dev.game.tilegame.entities.creatures.Player;
import dev.game.tilegame.entities.statics.Tree;
import dev.game.tilegame.tiles.Tile;
import dev.game.utils.Utils;

import java.awt.Graphics;

/**
 * Created by Fang Lai on 6/4/2017.
 */
public class World {

    private Handler handler;
    private int width, height;
    private int spawnX, spawnY;
    private int[][] tiles;

    //Entities
    private EntityManager entityManager;

    public World(Handler handler, String path){
        this.handler = handler;
        entityManager = new EntityManager(handler, new Player(handler, 100, 100));
        entityManager.addEntity(new Tree(handler, 100, 300));
        loadWorld(path);

        entityManager.getPlayer().setX(spawnX).setY(spawnY);
    }

    public void tick(){
        entityManager.tick();
    }

    public void render(Graphics g){
        int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILE_WIDTH);
        int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILE_WIDTH + 1);
        int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILE_HEIGHT);
        int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILE_HEIGHT + 1);
        for(int y = yStart; y < yEnd; ++y){
            for(int x = xStart; x < xEnd; ++x){

                getTile(x, y).render(g, (int)(Tile.TILE_WIDTH * x - handler.getGameCamera().getxOffset()), (int)(Tile.TILE_HEIGHT * y - handler.getGameCamera().getyOffset()));
            }
        }
        //Entities
        entityManager.render(g);
    }

    public Tile getTile(int x, int y){
        if(x < 0 || y < 0 || x >= width || y >= height){
            return Tile.grassTile;
        }

        Tile t = Tile.tiles[tiles[x][y]];
        if(t == null){
            return Tile.dirtTile;
        }
        return t;
    }

    private void loadWorld(String path){
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        spawnX = Utils.parseInt(tokens[2]);
        spawnY = Utils.parseInt(tokens[3]);

        tiles = new int[width][height];
        for(int y = 0; y < height; ++y){
            for(int x = 0; x < width; ++x){
                tiles[x][y] = Utils.parseInt(tokens[4 + y * width + x]);
            }
        }
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }
}
