package game.Roger.tilegame.gfx;

import java.awt.image.BufferedImage;

//class to load all our assets(images etc)
public class Assets
{
    //set the width and height of each image(as per sheet.png)-> the grid spaces
    private static final int width = 32 , height = 32; //prevent hard coding if the sizes are all equa

    //to represent the images to be cropped (loaded)
    public static BufferedImage player, dirt, grass, stone, tree;

    //method to load in all assets
    public static void init()
    {
        //load the image to through the spriteSheet
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));

        //setting the images from their positions
        player = sheet.crop(0,0, height,width) ;
        dirt = sheet.crop(width,0,height,width);
        grass = sheet.crop(width * 2, 0 , height, width);
        stone = sheet.crop(width * 3, 0, height, width);
        tree = sheet.crop(0,height,height,width);
    }
}
