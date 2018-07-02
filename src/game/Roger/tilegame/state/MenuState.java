package game.Roger.tilegame.state;

import game.Roger.tilegame.Handler;

import java.awt.*;

public class MenuState extends State {

    public MenuState(Handler handler) {
        super(handler);
    }

    @Override
    public void tick() {
        //System.out.println(handler.getMouseManager().getMouseX() + "   " + handler.getMouseManager().getMouseY());
        if (handler.getMouseManager().isLeftPressed() && handler.getMouseManager().isRightPressed())
            State.setCurrentState(handler.getGame().gameState);
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(Color.GREEN);
        graphics.fillRect(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY(), 5, 5);
    }
}
