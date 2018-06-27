package game.Roger.tilegame.gfx;

import java.awt.image.BufferedImage;

//class to display the spriteSheet
public class SpriteSheet
{
    private BufferedImage sheet; //the loaded image

    public SpriteSheet(BufferedImage sheet)
    {
        this.sheet = sheet;
    }

    //crop image and bring out individual parts
    public BufferedImage crop(int x, int y, int height, int width)
    {
        return sheet.getSubimage(x, y, height, width); //x and y coordinates with the height of the image
    }
}
