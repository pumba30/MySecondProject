package pandroidsoft.com.mysecondproject;

import java.util.List;

/**
 * Created by pumba30 on 06.02.2015.
 */

//интерфейс pandroidsoft.com.mysecondproject.Input, классы KeyEvent и TouchEvent
public interface Input {


    public static class KeyEvent {
        public static final int KEY_DOWN = 0;
        public static final int KEY_UP = 1;

        public int type; //тип клавиши
        public int keyCode; //код клавиши
        public char keyChar; //юникод, сли тип события KEY_UP
    }

    //TouchEvent, позиция пальца относительно исходного элемента интерфейса
    //и ID указателя, выданный данному пальцу драйвером сенсорного экрана
    public static class TouchEvent {
        public static final int TOUCH_DOWN = 0;
        public static final int TOUCH_UP = 1;
        public static final int TOUCH_DRAGGEDUP = 2;

        public int type; //тип клвиши
        public int x, y; //позиция
        public int pointer; //ID указателя
    }

    public boolean isKeyPressed(int keyCode); //получает keyCode и возвращает результат — нажата соответствующая кнопка в даннный момент или нет

    public boolean isTouchDown(int pointer); //возвращает состояние переданного им указателя

    public int getTouchX(int pointer);

    public int getTouchY(int pointer);

    public float getAccselX();

    public float getAccselY();

    public float getAccselZ();

    //возвращают экземпляры KeyEvent и TouchEvent, хранящие информацию
    //с посследнего раза, когда мы вызывали эти методы
    public List<KeyEvent> getKeyEvent();

    public List<TouchEvent> getTouchEvent();

}
