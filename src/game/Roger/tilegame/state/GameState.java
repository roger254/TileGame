package game.Roger.tilegame.state;

import game.Roger.tilegame.Handler;
import game.Roger.tilegame.entities.creatures.Player;
import game.Roger.tilegame.worlds.World;

import java.awt.*;

public class GameState extends State {

    private Player player;
    //World class
    private World world;

    public GameState(Handler handler) {
        super(handler);
        world = new World(handler, "Res/worlds/world1.txt");
        handler.setWorld(world);
        player = new Player(handler, 100, 100);

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
