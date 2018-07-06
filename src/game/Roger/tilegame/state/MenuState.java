package game.Roger.tilegame.state;

import game.Roger.tilegame.Handler;
import game.Roger.tilegame.gfx.Assets;
import game.Roger.tilegame.ui.ClickListener;
import game.Roger.tilegame.ui.UIImageButton;
import game.Roger.tilegame.ui.UIManager;

import java.awt.*;

public class MenuState extends State {

    //run the UIManager
    private UIManager uiManager;

    public MenuState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUIManager(uiManager);

        uiManager.addObject(new UIImageButton(200, 200, 128, 64, Assets.btn_start, new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUIManager(null);
                //when clicked set to game state
                State.setCurrentState(handler.getGame().gameState);
            }
        }));
    }

    @Override
    public void tick() {
        uiManager.tick();
    }

    @Override
    public void render(Graphics graphics) {
        uiManager.render(graphics);
    }
}
