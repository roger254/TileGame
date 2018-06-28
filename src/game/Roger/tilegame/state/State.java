package game.Roger.tilegame.state;

import game.Roger.tilegame.Game;

import java.awt.*;

//state like menu, setting and game itself
public abstract class State {

    //Game state manager(can be in separate class)
    private static State currentState = null; //state that should tick and render(Game, Menu, Settings)

    public static State getCurrentState() {
        return currentState;
    }

    public static void setCurrentState(State state) {
        currentState = state;
    }

    //End of game state manager

    protected Game game;

    public State(Game game) {
        this.game = game;
    }

    //all State subclasses implement these methods
    public abstract void tick();

    public abstract void render(Graphics graphics);//enable State to draw to screen directly

}
