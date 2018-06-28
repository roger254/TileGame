package game.Roger.tilegame.entities.creatures;

import game.Roger.tilegame.Game;
import game.Roger.tilegame.gfx.Assets;

import java.awt.*;

public class Player extends Creature {

    private Game game;

    public Player(Game game, float x, float y) {
        super(x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        this.game = game;
    }

    @Override
    public void tick() {
        getInput();//get user input
        move();
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
        g.drawImage(Assets.player, (int) x, (int) y, width, height, null); //parse the x and y to int
    }
}
