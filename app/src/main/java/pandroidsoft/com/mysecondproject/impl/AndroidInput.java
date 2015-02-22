package pandroidsoft.com.mysecondproject.impl;

import android.content.Context;
import android.os.Build;
import android.view.View;

import java.util.List;

import pandroidsoft.com.mysecondproject.Input;

/**
 * Created by pumba30 on 21.02.2015.
 */
public class AndroidInput implements Input {
    AccelerometerHandler accelHandler;
    KeyboardHandler keyHandler;
    TouchHandler touchHandler;

    public AndroidInput(Context context, View view, float scaleX, float scaleY) {
        accelHandler = new AccelerometerHandler(context);
        keyHandler = new KeyboardHandler(view);
        touchHandler = new MultiTouchHandler(view, scaleX, scaleY);
    }


    @Override
    public boolean isKeyPressed(int keyCode) {
        return keyHandler.isKeyPressed(keyCode);
    }

    @Override
    public boolean isTouchDown(int pointer) {
        return touchHandler.isTouchDown(pointer);
    }

    @Override
    public int getTouchX(int pointer) {
        return touchHandler.getTouchX(pointer);
    }

    @Override
    public int getTouchY(int pointer) {
        return touchHandler.getTouchY(pointer);
    }

    @Override
    public float getAccselX() {
        return accelHandler.getAccelX();
    }

    @Override
    public float getAccselY() {
        return accelHandler.getAccelY();
    }

    @Override
    public float getAccselZ() {
        return accelHandler.getAccelZ();
    }

    @Override
    public List<KeyEvent> getKeyEvent() {
        return keyHandler.getKeyEvents();
    }

    @Override
    public List<TouchEvent> getTouchEvents() {
        return touchHandler.getTouchEvents();
    }
}
