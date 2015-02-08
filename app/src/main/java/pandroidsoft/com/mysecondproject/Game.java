package pandroidsoft.com.mysecondproject;

/**
 * Created by pumba30 on 08.02.2015.
 */
public interface Game {
    public Input getInput();

    public FileIO getFileIO();

    public Graphics getGraphics();

    public Audio getAudio();

    public void  setScreen(Screen screen); //установить для игры текущий экран

    public Screen getCurrentScreen(); //возвращает текущий экран

    public Screen getStartScreen();//возврат экземпляра первого экрана игры

}
