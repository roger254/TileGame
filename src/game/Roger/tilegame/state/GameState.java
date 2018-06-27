package game.Roger.tilegame.state;

import game.Roger.tilegame.entities.creatures.Player;

import java.awt.*;

public class GameState extends State {

    private Player player;

    public GameState() {
        player = new Player(100, 100);
    }

    @Override
    public void tick() {
        player.tick();
    }

    @Override
    public void render(Graphics graphics) {
        player.render(graphics);
    }
}
