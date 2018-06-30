package game.Roger.tilegame.gfx;

import java.awt.image.BufferedImage;

//class to load all our assets(images etc)
public class Assets {
    //set the width and height of each image(as per sheet.png)-> the grid spaces
    private static final int width = 32, height = 32; //prevent hard coding if the sizes are all equa

    //to represent the images to be cropped (loaded)
    public static BufferedImage dirt, grass, stone, tree;
    public static BufferedImage[] playerUp, playerDown, playerLeft, playerRight;

    //method to load in all assets
    public static void init() {
        //load the image to through the spriteSheet
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));

        //setting the images from their positions
        playerUp = new BufferedImage[2]; // 2 for the two frame animation
        playerDown = new BufferedImage[2];
        playerLeft = new BufferedImage[2];
        playerRight = new BufferedImage[2];

        playerUp[0] = sheet.crop(width * 6, 0, height, width);
        playerUp[0] = sheet.crop(width * 7, 0, height, width);

        playerRight[0] = sheet.crop(width * 4, height, height, width);
        playerRight[1] = sheet.crop(width * 5, height, height, width);

        playerLeft[0] = sheet.crop(width * 6, height, height, width);
        playerLeft[0] = sheet.crop(width * 7, height, height, width);

        playerDown[0] = sheet.crop(width * 4, 0, height, width);
        playerDown[1] = sheet.crop(width * 5, 0, height, width);

        dirt = sheet.crop(width, 0, height, width);
        grass = sheet.crop(width * 2, 0, height, width);
        stone = sheet.crop(width * 3, 0, height, width);
        tree = sheet.crop(0, 0, height, width);
    }
}
