package game.Roger.tilegame.entities.creatures;

import game.Roger.tilegame.Handler;
import game.Roger.tilegame.gfx.Assets;

import java.awt.*;

public class Player extends Creature {


    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
    }

    @Override
    public void tick() {
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
        g.drawImage(Assets.player, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null); //parse the x and y to int
    }
}
