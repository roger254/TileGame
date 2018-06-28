package game.Roger.tilegame.display;
import javax.swing.*;
import java.awt.*;

public class Display {
    private JFrame frame; //get a window displayed on screen
    private Canvas canvas; //add graphics to the canvas , then add to JFrame

    private String title; //title of display window
    private int width, height; //pixels //of window

    //Display constructor
    public Display(String title, int width, int height)
    {
        this.title  = title;
        this.width = width;
        this.height = height;

        createDisplay();//initialize JFrame
    }
    //initialize JFrame
    private void createDisplay()
    {
        frame = new JFrame(title); //initialize and set title
        frame.setSize(width, height); //pass width and height of window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //window and program closes down properly
        //optionals
        frame.setResizable(false); //user to change display size
        frame.setLocationRelativeTo(null); //window to appear at center of screen
        frame.setVisible(true); //make window visible

        //canvas
        canvas = new Canvas(); //initialize Canvas
        canvas.setPreferredSize(new Dimension(width, height)); //set size via the dimension
        canvas.setMaximumSize(new Dimension(width, height)); //ensure Max height
        canvas.setMinimumSize(new Dimension(width, height)); //ensure Min height
        canvas.setFocusable(false);

        //add canvas to JFrame
        frame.add(canvas);
        frame.pack(); //fit canvas to JFrame
    }

    public Canvas getCanvas()
    {
        return canvas;
    }

    public JFrame getFrame() {
        return frame;
    }

}
