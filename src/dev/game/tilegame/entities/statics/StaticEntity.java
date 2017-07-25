package dev.game.tilegame.entities.statics;

import dev.game.Handler;
import dev.game.tilegame.entities.Entity;

/**
 * Created by Fang Lai on 7/24/2017.
 */
public abstract class StaticEntity extends Entity{

    public StaticEntity(Handler handler, float x, float y, int width, int height){
        super(handler, x, y, width, height);
    }

}
