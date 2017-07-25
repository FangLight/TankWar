package dev.game.tilegame.tiles;

import dev.game.tilegame.gfx.Assets;

import java.awt.image.BufferedImage;

/**
 * Created by Fang Lai on 6/4/2017.
 */
public class RockTile extends Tile {

    public RockTile(int id) {
        super(Assets.stone, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }

}
