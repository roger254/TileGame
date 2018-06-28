package game.Roger.tilegame.worlds;

import game.Roger.tilegame.Game;
import game.Roger.tilegame.tiles.Tile;
import game.Roger.tilegame.utils.Utils;

import java.awt.*;

public class World {

    private Game game;
    private int width, height; //of the world
    private int spawnX, spawnY; //spawning position of the player
    private int[][] tiles; //to store all the tiles

    public World(Game game, String path) {
        this.game = game;
        loadWorld(path);
    }

    public void tick() {
    }

    //the world (what should show in screen
    public void render(Graphics g) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - game.getGameCamera().getxOffset()),
                        (int) (y * Tile.TILEHEIGHT - game.getGameCamera().getyOffset())); //convert into pixels
            }
        }
    }

    public Tile getTile(int x, int y) {
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
}
