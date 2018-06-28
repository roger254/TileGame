package game.Roger.tilegame.tiles;

import game.Roger.tilegame.gfx.Assets;

public class RockTile extends Tile {

    public RockTile(int id) {
        super(Assets.stone, id);
    }

    @Override
    public boolean isSolid() {
        return true;// rock is solid
    }
}
