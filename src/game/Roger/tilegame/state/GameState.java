package game.Roger.tilegame.state;

import game.Roger.tilegame.Game;
import game.Roger.tilegame.entities.creatures.Player;
import game.Roger.tilegame.worlds.World;

import java.awt.*;

public class GameState extends State {

    private Player player;
    //World class
    private World world;

    public GameState(Game game) {
        super(game);
        player = new Player(game, 100, 100);
        world = new World("");
    }

    @Override
    public void tick() {
        world.tick();//tick the world first
        player.tick();
    }

    @Override
    public void render(Graphics graphics) {
        world.render(graphics);//render world first
        player.render(graphics);
    }
}
