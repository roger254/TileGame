package game.Roger.tilegame.entities.creatures;

import game.Roger.tilegame.Game;
import game.Roger.tilegame.gfx.Assets;

import java.awt.*;

public class Player extends Creature {

    private Game game;

    public Player(Game game, float x, float y) {
        super(x, y);
        this.game = game;
    }

    @Override
    public void tick() {
        //test code
        if (game.getKeyManager().up)
            y -= 3;
        if (game.getKeyManager().down)
            y += 3;
        if (game.getKeyManager().left)
            x -= 3;
        if (game.getKeyManager().right)
            x += 3;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player, (int) x, (int) y, null); //parse the x and y to int
    }
}
