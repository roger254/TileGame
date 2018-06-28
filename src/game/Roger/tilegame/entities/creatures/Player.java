package game.Roger.tilegame.entities.creatures;

import game.Roger.tilegame.Game;
import game.Roger.tilegame.gfx.Assets;

import java.awt.*;

public class Player extends Creature {


    public Player(Game game, float x, float y) {
        super(game, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
    }

    @Override
    public void tick() {
        getInput();//get user input
        move();
        game.getGameCamera().centerOnEntity(this);
    }

    private void getInput() {
        //handling how input should do
        //reset to zero
        xMove = 0;
        yMove = 0;

        //get keyboard input
        if (game.getKeyManager().up)
            yMove = -speed; //y axis is flipped around in computer graphics
        if (game.getKeyManager().down)
            yMove = speed;
        if (game.getKeyManager().left)
            xMove = -speed;
        if (game.getKeyManager().right)
            xMove = speed;
    }

    @Override
    public void render(Graphics g) {
        //pass width and height from the Creature class(are protected)
        g.drawImage(Assets.player, (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), width, height, null); //parse the x and y to int
    }
}
