package game.Roger.tilegame.entities.statics;

import game.Roger.tilegame.Handler;
import game.Roger.tilegame.entities.Entity;

//entities that don't move like rock and tree
public abstract class StaticEntity extends Entity {

    public StaticEntity(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
    }
}
