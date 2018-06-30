package game.Roger.tilegame.state;

import game.Roger.tilegame.Handler;

import java.awt.*;

//state like menu, setting and game itself
public abstract class State {

    //Game state manager(can be in separate class)
    private static State currentState = null; //state that should tick and render(Game, Menu, Settings)
    protected Handler handler;

    public State(Handler handler) {
        this.handler = handler;
    }

    //End of game state manager

    public static State getCurrentState() {
        return currentState;
    }

    public static void setCurrentState(State state) {
        currentState = state;
    }

    //all State subclasses implement these methods
    public abstract void tick();

    public abstract void render(Graphics graphics);//enable State to draw to screen directly

}
