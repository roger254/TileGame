package game.Roger.tilegame.state;


import game.Roger.tilegame.gfx.Assets;

import java.awt.*;

public class GameState extends State {

    public GameState() {

    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.dirt, 0, 0, null);//render dirt tile
    }
}
