package game.Roger.tilegame.state;

import game.Roger.tilegame.Handler;
import game.Roger.tilegame.worlds.World;

import java.awt.*;

public class GameState extends State {

    //World class
    private World world;

    public GameState(Handler handler) {
        super(handler);
        world = new World(handler, "Res/worlds/world1.txt");
        handler.setWorld(world);
    }

    @Override
    public void tick() {
        world.tick();//tick the world first
    }

    @Override
    public void render(Graphics graphics) {
        world.render(graphics);//render world first
    }
}
