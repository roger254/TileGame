package game.Roger.tilegame.gfx;

import java.awt.image.BufferedImage;

//class to load all our assets(images etc)
public class Assets {
    //set the width and height of each image(as per sheet.png)-> the grid spaces
    private static final int width = 32, height = 32; //prevent hard coding if the sizes are all equa

    //to represent the images to be cropped (loaded)
    public static BufferedImage dirt, grass, stone, tree, rock;
    public static BufferedImage[] playerUp, playerDown, playerLeft, playerRight;
    public static BufferedImage[] zombieUp, zombieDown, zombieLeft, zombieRight;
    public static BufferedImage[] btn_start;
    //method to load in all assets
    public static void init() {
        //load the image to through the spriteSheet
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));

        //loading the start and stop buttons(menu)
        btn_start = new BufferedImage[2];//0 =start 1 = stop
        btn_start[0] = sheet.crop(width * 6, height * 4, width * 2, height);
        btn_start[1] = sheet.crop(width * 6, height * 5, width * 2, height);

        //setting the images from their positions
        playerUp = new BufferedImage[2]; // 2 for the two frame animation
        playerDown = new BufferedImage[2];
        playerLeft = new BufferedImage[2];
        playerRight = new BufferedImage[2];

        playerUp[0] = sheet.crop(width * 6, 0, width, height);
        playerUp[1] = sheet.crop(width * 7, 0, width, height);

        playerRight[0] = sheet.crop(width * 4, height, width, height);
        playerRight[1] = sheet.crop(width * 5, height, width, height);

        playerLeft[0] = sheet.crop(width * 6, height, width, height);
        playerLeft[1] = sheet.crop(width * 7, height, width, height);

        playerDown[0] = sheet.crop(width * 4, 0, width, height);
        playerDown[1] = sheet.crop(width * 5, 0, width, height);

        zombieDown = new BufferedImage[2];
        zombieUp = new BufferedImage[2];
        zombieLeft = new BufferedImage[2];
        zombieRight = new BufferedImage[2];

        zombieDown[0] = sheet.crop(width * 4, height * 2, width, height);
        zombieDown[1] = sheet.crop(width * 5, height * 2, width, height);

        zombieUp[0] = sheet.crop(width * 6, height * 2, width, height);
        zombieUp[1] = sheet.crop(width * 7, height * 2, width, height);

        zombieRight[0] = sheet.crop(width * 4, height * 3, width, height);
        zombieRight[1] = sheet.crop(width * 5, height * 3, width, height);

        zombieLeft[0] = sheet.crop(width * 6, height * 3, width, height);
        zombieLeft[1] = sheet.crop(width * 7, height * 3, width, height);


        dirt = sheet.crop(width, 0, width, height);
        grass = sheet.crop(width * 2, 0, width, height);
        stone = sheet.crop(width * 3, 0, width, height);
        tree = sheet.crop(0, 0, width, height * 2);
        rock = sheet.crop(0, height * 2, width, height);
    }
}
