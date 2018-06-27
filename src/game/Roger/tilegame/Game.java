package game.Roger.tilegame;

import game.Roger.tilegame.display.Display;
import game.Roger.tilegame.gfx.Assets;
import game.Roger.tilegame.input.KeyManager;
import game.Roger.tilegame.state.GameState;
import game.Roger.tilegame.state.MenuState;
import game.Roger.tilegame.state.SettingsState;
import game.Roger.tilegame.state.State;

import java.awt.*;
import java.awt.image.BufferStrategy;

//main class for the game
public class Game implements Runnable { //Runnable makes this class run on it own thread

    private Display display; //display class instance

    public int width, height;
    public String title;
    private boolean running = false;

    private Thread thread; //thread object
    /*
    BufferStrategy tell the computer how to draw on screen(uses buffers)
    Buffer 'i.e. a hidden screen within your computer' with the graphics to be displayed(placeholder)
    prevent flickering **look it up**
     */
    private BufferStrategy bs;
    private Graphics g; //to draw the image

    //States
    private State gameState;
    private State menuState;
    private State settingsState;

    //Input(keyboard)
    private KeyManager keyManager;

    //Game class constructor
    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
        keyManager = new KeyManager();
    }

    //initialize graphics of the game
    private void init() {
        //initialize display
        display = new Display(title, width, height); //create display in Game
        display.getFrame().addKeyListener(keyManager);//get key press
        //load images
        Assets.init();
        //gameState
        gameState = new GameState(this);//initialize game state
        menuState = new MenuState(this);//initialize menu State
        settingsState = new SettingsState(this); //initialize settings State
        State.setCurrentState(gameState); //current game state is GameState
    }

    //update variable and objects
    private void tick() {
        keyManager.tick();// for the key manager

        if (State.getCurrentState() != null)
            State.getCurrentState().tick();
    }

    //draw on screen
    private void render() {
        bs = display.getCanvas().getBufferStrategy(); //get canvas bufferedStrategy and set it to the bs
        if (bs == null) //first time, when there are no buffers
        {
            display.getCanvas().createBufferStrategy(3); //create 3 buffers
            return;
        }
        //draw to canvas with Graphics
        g = bs.getDrawGraphics(); // draw to canvas(i.e. paint brush)
        //first clear the screen
        g.clearRect(0, 0, width, height);//clear whole screen
        //<-Draw here->

        if (State.getCurrentState() != null)
            State.getCurrentState().render(g);

        //End Drawing
        //tell java to display on screen
        bs.show(); // work on buffer
        g.dispose(); // graphic objects to be done with properly
    }

    @Override
    public void run() {
        init();

        long oneSecond = 1000000000;
        int fps = 60; //frames per second -> how many times the tick method is called
        double timePerTick = oneSecond / fps; //time in nano seconds(1 second in nano seconds)
        double delta = 0;//time till tick and render are called again
        long now;
        long lastTime = System.nanoTime(); //current time in nanoseconds
        long timer = 0; // count till one second and print counter
        int ticks = 0; // number of times tick and render method are called

        /*
         Game loop
        -> update all variable, positions of objects etc
        -> Render (Draw) everything to the screen
         */
        while (running) {
            now = System.nanoTime();//current time of game loop start
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime; //time past since block of code was called
            lastTime = now; // last time when the block of code was run

            if (delta >= 1) {
                tick();
                render();
                ticks++;
                delta--;
            }
            if (timer >= oneSecond) //timer has exceeded one second
            {
                System.out.println("Ticks and Frames: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }

        stop(); //stop the thread
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }

    //run the thread
    public synchronized void start() {
        if (running) return; //check game is already running (game loop)
        running = true; //start game loop

        thread = new Thread(this);// run this class under new thread
        thread.start();//start thread -> will call run() method
    }

    //stop the thread
    public synchronized void stop() {
        if (!running) return; // check if game is not running(game loop)

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
