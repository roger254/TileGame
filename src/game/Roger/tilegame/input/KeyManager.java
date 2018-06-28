package game.Roger.tilegame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

    public boolean up, down, left, right;
    private boolean[] keys;

    public KeyManager() {
        keys = new boolean[256];
    }

    public void tick() {
        up = keys[KeyEvent.VK_W]; //'w' key
        down = keys[KeyEvent.VK_S];//'s' key
        left = keys[KeyEvent.VK_A];//'a' key
        right = keys[KeyEvent.VK_D]; //'d' key
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true; //pressed
        System.out.println("Pressed!");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false; //not pressed
    }
}
