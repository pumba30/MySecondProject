package pandroidsoft.com.mysecondproject.mrnom;

import java.util.List;

import pandroidsoft.com.mysecondproject.Game;
import pandroidsoft.com.mysecondproject.Graphics;
import pandroidsoft.com.mysecondproject.Input;
import pandroidsoft.com.mysecondproject.Screen;

/**
 * Created by pumba30 on 22.02.2015.
 */
public class HelpScreen3 extends Screen {
    public HelpScreen3(Game game) {
        super(game);
    }

    @Override
    public void update(float deltaTime) {
        List<Input.TouchEvent> touchEvents = game.getInput().getTouchEvents();
        game.getInput().getKeyEvent();

        int len = touchEvents.size();
        for(int i = 0; i < len; i++) {
            Input.TouchEvent event = touchEvents.get(i);
            if(event.type == Input.TouchEvent.TOUCH_UP) {
                if(event.x > 256 && event.y > 416 ) {
                    game.setScreen(new MainMenuScreen(game));
                    if(Settings.soundEnabled)
                        Assets.click.play(1);
                    return;
                }
            }
        }
    }

    @Override
    public void present(float deltaTime) {
        Graphics g = game.getGraphics();
        g.drawPixmap(Assets.background, 0, 0);
        g.drawPixmap(Assets.help3, 64, 100);
        g.drawPixmap(Assets.buttons, 256, 416, 0, 128, 64, 64);
    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub

    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub

    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub

    }
}
