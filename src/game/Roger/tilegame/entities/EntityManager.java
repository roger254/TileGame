package game.Roger.tilegame.entities;

import game.Roger.tilegame.Handler;
import game.Roger.tilegame.entities.creatures.Player;

import java.awt.*;
import java.util.ArrayList;

//going to manage all the game entities
public class EntityManager {

    private Handler handler;
    private Player player;
    private ArrayList<Entity> entities;

    public EntityManager(Handler handler, Player player) {
        this.handler = handler;
        this.player = player;
        entities = new ArrayList<>();
    }

    public void tick() {
        for (int i = 0; i < entities.size(); i++) {
            Entity e = entities.get(i);
            e.tick();
        }
        player.tick();
    }

    public void render(Graphics graphics) {
        for (Entity e : entities) {
            e.render(graphics);
        }
        player.render(graphics);
    }

    public void addEntity(Entity e) {
        entities.add(e);//add entities
    }

    //Getter and Setters
    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }
}
