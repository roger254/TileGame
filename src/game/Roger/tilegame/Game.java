package game.Roger.tilegame;

import game.Roger.tilegame.display.Display;
import game.Roger.tilegame.gfx.ImageLoader;
import game.Roger.tilegame.gfx.SpriteSheet;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

//main class for the game
public class Game implements Runnable { //Runnable makes this class run on it own thread

    private Display display; //display class instance

    public int width, height;
    public String title;
    private boolean running = false;

    private BufferedImage test;
    private SpriteSheet sheet;

    private Thread thread; //thread object
    /*
    BufferStrategy tell the computer how to draw on screen(uses buffers)
    Buffer 'i.e. a hidden screen within your computer' with the graphics to be displayed(placeholder)
    prevent flickering **look it up**
     */
    private BufferStrategy bs;
    private Graphics g; //to draw the image

    //Game class constructor
    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
    }

    //initialize graphics of the game
    private void init() {
        //initialize display
        display = new Display(title, width, height); //create display in Game
        test = ImageLoader.loadImage("/textures/sheet.png"); //load image
        sheet = new SpriteSheet(test); //load the image to spireSheet object
    }

    //update variable and objects
    private void tick() {

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

       // g.drawImage(sheet.crop(0,0,32,32),5,5,null); //get the green part
        //32 for x is the starting pixel for the image and
        g.drawImage(sheet.crop(32,0,32,32),5,5,null); //get the blue part

        /*
        draw without color fill
        g.drawRect(10, 50, 50, 70);//draw rectangle

        //draw with color
        g.setColor(Color.BLUE); //fill with certain Color
        g.fillRect(10, 50, 50, 70);//draw rectangle
        g.setColor(Color.GREEN);
        g.fillRect(0,0, 10,10);
        */



        //End Drawing
        //tell java to display on screen
        bs.show(); // work on buffer
        g.dispose(); // graphic objects to be done with properly
    }

    @Override
    public void run() {
        init();
        /*
         Game loop
        -> update all variable, positions of objects etc
        -> Render (Draw) everything to the screen
         */
        while (running) {
            tick();
            render();
        }

        stop(); //stop the thread
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
