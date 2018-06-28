package game.Roger.tilegame.entities;

import java.awt.*;

public abstract class Entity {

    //requirement for all entities
    protected float x, y; // to achieve smooth movement

    public Entity(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

}
