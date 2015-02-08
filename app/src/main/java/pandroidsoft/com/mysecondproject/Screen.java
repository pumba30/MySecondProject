package pandroidsoft.com.mysecondproject;

/**
 * Created by pumba30 on 08.02.2015.
 */
public abstract class Screen {

    protected final Game game;

    public Screen(Game game) {
        this.game = game;
    }

    public abstract void update(float deltaTime);//обновляет состояние экрана

    public abstract void present(float deltaTime);//обновляет состояние экрана

    public abstract void pause();//метод поставновки игры на паузу

    public abstract void resume();//метод выхода игры из паузы

    public abstract void dispose();

}
