package pandroidsoft.com.mysecondproject.mrnom;


import pandroidsoft.com.mysecondproject.Screen;
import pandroidsoft.com.mysecondproject.impl.AndroidGame;

/**
 * Created by pumba30 on 22.02.2015.
 */
public class MrNomGame extends AndroidGame {
    @Override
    public Screen getStartScreen() {
        return new LoadingScreen(this);
    }

}
