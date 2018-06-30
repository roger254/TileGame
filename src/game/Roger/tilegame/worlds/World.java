package game.Roger.tilegame.worlds;

import game.Roger.tilegame.Handler;
import game.Roger.tilegame.entities.EntityManager;
import game.Roger.tilegame.entities.creatures.Player;
import game.Roger.tilegame.entities.statics.Tree;
import game.Roger.tilegame.tiles.Tile;
import game.Roger.tilegame.utils.Utils;

import java.awt.*;

public class World {

    private Handler handler;
    private int width, height; //of the world
    private int spawnX, spawnY; //spawning position of the player
    private int[][] tiles; //to store all the tiles

    //Entities
    private EntityManager entityManager;
    public World(Handler handler, String path) {
        this.handler = handler;
        //add player
        entityManager = new EntityManager(handler, new Player(handler, 100, 100));
        entityManager.addEntity(new Tree(handler, 100, 250));
        entityManager.addEntity(new Tree(handler, 100, 350));
        entityManager.addEntity(new Tree(handler, 100, 450));

        loadWorld(path);

        //spawn player at
        entityManager.getPlayer().setX(spawnX);
        entityManager.getPlayer().setY(spawnY);
    }

    public void tick() {
        entityManager.tick();//tick all entities
    }

    //the world (what should show in screen
    public void render(Graphics g) {
        //limit tile to one's which are visible
        int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
        int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
        int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
        int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);

        for (int y = yStart; y < yEnd; y++) {
            for (int x = xStart; x < xEnd; x++) {
                getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
                        (int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset())); //convert into pixels
            }
        }
        //Entity
        entityManager.render(g);
    }

    public Tile getTile(int x, int y) {
        //check if player is still in map limits
        if (x < 0 || y < 0 || x >= width || y >= height)
            return Tile.grassTile; // return grass tile if player is beyond limits

        //Tile.tile -> tile array in Tile class
        Tile t = Tile.tiles[tiles[x][y]];
        if (t == null)
            return Tile.dirtTile;
        return t;
    }

    //load world from file
    private void loadWorld(String path) {
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+"); //split numbers from file into tokens
        width = Utils.parseInt(tokens[0]); //->5 first line (5 , 7) from world1.txt
        height = Utils.parseInt(tokens[1]); //->7 first line (5, 7) from world1.txt
        spawnX = Utils.parseInt(tokens[2]); //->0 second line(0, 0) from world1.txt
        spawnY = Utils.parseInt(tokens[3]);//->0 second line(0, 0) from world1.txt

        tiles = new int[width][height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
