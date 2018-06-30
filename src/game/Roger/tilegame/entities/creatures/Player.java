package game.Roger.tilegame.entities.creatures;

import game.Roger.tilegame.Handler;
import game.Roger.tilegame.gfx.Animation;
import game.Roger.tilegame.gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature {

    //Animations
    private Animation downAnimation, upAnimation, leftAnimation, rightAnimation;

    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

        //set bounding rectangle(custom for player)
        bounds.x = 16; //16px from the left of x coordinate of the player
        bounds.y = 32; //32 px down from the x coordinate of the player
        bounds.width = 32;
        bounds.height = 32;

        //Animations
        downAnimation = new Animation(500, Assets.playerDown);//500 half a second
        upAnimation = new Animation(500, Assets.playerUp);
        leftAnimation = new Animation(500, Assets.playerLeft);
        rightAnimation = new Animation(500, Assets.playerRight);
    }

    @Override
    public void tick() {
        //Animations
        downAnimation.tick();
        upAnimation.tick();
        leftAnimation.tick();
        rightAnimation.tick();
        //Movement
        getInput();//get user input
        move();
        handler.getGameCamera().centerOnEntity(this);
    }

    private void getInput() {
        //handling how input should do
        //reset to zero
        xMove = 0;
        yMove = 0;

        //get keyboard input
        if (handler.getKeyManager().up)
            yMove = -speed; //y axis is flipped around in computer graphics
        if (handler.getKeyManager().down)
            yMove = speed;
        if (handler.getKeyManager().left)
            xMove = -speed;
        if (handler.getKeyManager().right)
            xMove = speed;
    }

    @Override
    public void render(Graphics g) {
        //pass width and height from the Creature class(are protected)
        g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null); //parse the x and y to int


        /* //color bounding box
        g.setColor(Color.RED); //set color of graphics
        g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
                (int) (y + bounds.y - handler.getGameCamera().getyOffset()),
                bounds.width, bounds.height);
                */
    }

    private BufferedImage getCurrentAnimationFrame() {
        if (xMove < 0) { //moving to left
            return leftAnimation.getCurrentFrame();
        } else if (xMove > 0) //moving to right
        {
            return rightAnimation.getCurrentFrame();
        } else if (yMove < 0) //moving up
        {
            return upAnimation.getCurrentFrame();
        } else {
            return downAnimation.getCurrentFrame();
        }
    }
}
