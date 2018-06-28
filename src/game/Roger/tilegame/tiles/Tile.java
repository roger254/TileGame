package game.Roger.tilegame.tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {

    //CLASS
    public static final int TILEWIDTH = 64, TILEHEIGHT = 64;
    //STATIC VARIABLES
    public static Tile[] tiles = new Tile[256];
    //instantiate the different tiles
    public static Tile grassTile = new GrassTile(0);
    public static Tile dirtTile = new DirtTile(1);
    public static Tile rockTile = new RockTile(2);
    protected final int id; // id for each tile(unique)
    protected BufferedImage texture;

    public Tile(BufferedImage texture, int id) {
        this.texture = texture;//image of tile
        this.id = id;

        tiles[id] = this;
    }

    public void tick() {

    }

    public void render(Graphics g, int x, int y) {
        g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
    }

    //check if one can move on/through tile(ie rock is solid->can't walk through it)
    public boolean isSolid() {
        return false;//is not solid
    }

    public int getId() {
        return id;
    }
}
