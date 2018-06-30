package game.Roger.tilegame.gfx;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

//this class will load images only
public class ImageLoader {
    //load the image from set path 
    public static BufferedImage loadImage(String path) {
        try {
            //return Buffered Image object of the loaded image
            return ImageIO.read(ImageLoader.class.getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1); //exit if no image
        }
        return null;
    }
}
