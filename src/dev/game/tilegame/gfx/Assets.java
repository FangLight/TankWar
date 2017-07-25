package dev.game.tilegame.gfx;

import java.awt.image.BufferedImage;

/**
 * Created by Fang Lai on 6/3/2017.
 */
public class Assets {

    public static final int width = 32, height = 32;

    public static BufferedImage player_stand, dirt, grass, stone, tree;
    public static BufferedImage[] player_up, player_down, player_right, player_left;

    public static void init(){
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));

        player_up = new BufferedImage[2];
        player_down = new BufferedImage[2];
        player_right = new BufferedImage[2];
        player_left = new BufferedImage[2];

        player_up[0] = sheet.crop(0, 0, width, height);
        player_down[0] = sheet.crop(width * 1, 0 ,width, height);
        player_right[0] = sheet.crop(width * 2, 0, width, height);
        player_left[0] = sheet.crop(0, height, width, height);

        player_up[1] = sheet.crop(width, 0, width, height);
        player_down[1] = sheet.crop(width * 2, 0 ,width, height);
        player_right[1] = sheet.crop(width * 3, 0, width, height);
        player_left[1] = sheet.crop(0, 0, width, height);

        player_stand = sheet.crop(0, 0, width, height);
        dirt = sheet.crop(width, 0, width, height);
        grass = sheet.crop(width * 2, 0 ,width, height);
        stone = sheet.crop(width * 3, 0, width, height);
        tree = sheet.crop(0, height, width, height);
    }

}
