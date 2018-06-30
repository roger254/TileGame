package game.Roger.tilegame.entities.creatures;

import game.Roger.tilegame.Handler;
import game.Roger.tilegame.entities.Entity;
import game.Roger.tilegame.tiles.Tile;

public abstract class Creature extends Entity {

    public static final int DEFAULT_HEALTH = 10;
    public static final float DEFAULT_SPEED = 5.0F;
    //size of all creatures
    public static final int DEFAULT_CREATURE_WIDTH = 64,
            DEFAULT_CREATURE_HEIGHT = 64;

    protected int health; //health of all creatures

    //movement
    protected float speed;
    protected float xMove, yMove;

    public Creature(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        health = DEFAULT_HEALTH;
        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
    }

    public void move() {
        moveX();
        moveY();
    }

    public void moveX() {
        if (xMove > 0) //Moving right
        {
            int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
            //check tile we moving to if it is solid(right up corner and lower right corner
            if (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
                    !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
                x += xMove;
            } else {
                //if there was a collision make player be next to the tile
                x = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1; // convert to pixels
            }
        } else if (xMove < 0) //Move left
        {
            int tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;

            if (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
                    !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
                x += xMove;
            } else {
                x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;
            }
        }
    }

    public void moveY() {
        if (yMove < 0)//moving up
        {
            int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT; //top edge of bounding rectangle
            if (!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
                    !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
                y += yMove;
            } else {
                y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
            }
        } else if (yMove > 0) //moving down
        {
            int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT; //top edge of bounding rectangle
            if (!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
                    !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
                y += yMove;
            } else {
                y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;
            }
        }
    }

    protected boolean collisionWithTile(int x, int y) {
        //check if tile at x, y is solid
        return handler.getWorld().getTile(x, y).isSolid();
    }

    //Getters and Setters

    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
