package dev.game.tilegame.state;

import dev.game.Handler;
import dev.game.tilegame.entities.creatures.Creature;
import dev.game.tilegame.entities.creatures.Player;
import dev.game.tilegame.entities.statics.Tree;
import dev.game.tilegame.worlds.World;

import java.awt.*;

/**
 * Created by Fang Lai on 6/3/2017.
 */
public class GameState extends State{

    private Player player;
    private World world;

    public GameState(Handler handler){
        super(handler);
        world = new World(handler, "res/worlds/world1.txt");
        handler.setWorld(world);
    }

    @Override
    public void tick() {
        world.tick();
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
    }

}
