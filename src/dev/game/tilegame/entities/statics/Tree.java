package dev.game.tilegame.entities.statics;

import dev.game.Handler;
import dev.game.tilegame.gfx.Assets;
import dev.game.tilegame.tiles.Tile;

import java.awt.*;

/**
 * Created by Fang Lai on 7/24/2017.
 */
public class Tree extends StaticEntity {

    public Tree(Handler handler, float x, float y){
        super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
    }

    @Override
    public void tick(){

    }

    @Override
    public void render(Graphics g){
        g.drawImage(Assets.tree, (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height, null);
    }

}
