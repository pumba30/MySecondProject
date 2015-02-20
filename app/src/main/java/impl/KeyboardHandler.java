package impl;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

import pandroidsoft.com.mysecondproject.Input;
import pandroidsoft.com.mysecondproject.Input.KeyEvent;
import pandroidsoft.com.mysecondproject.Pool;

/**
 * Created by pumba30 on 19.02.2015.
 */
public class KeyboardHandler implements View.OnKeyListener {
    boolean[] pressedKeys = new boolean[128];
    Pool<Input.KeyEvent> keyEventPool;
    List<Input.KeyEvent> keyEventsBuffer = new ArrayList<Input.KeyEvent>();
    List<Input.KeyEvent> keyEvents = new ArrayList<Input.KeyEvent>();

    public KeyboardHandler(View view) {
        Pool.PoolObjectFactory<Input.KeyEvent> factory = new Pool.PoolObjectFactory<Input.KeyEvent>() {
            @Override
            public Input.KeyEvent createObject() {
                return new Input.KeyEvent();
            }
        };
        keyEventPool = new Pool<Input.KeyEvent>(factory, 100);
        view.setOnKeyListener(this);
        view.setFocusableInTouchMode(true);
        view.requestFocus();
    }

    @Override
    public boolean onKey(View v, int keyCode, android.view.KeyEvent event) {
        if (event.getAction() == android.view.KeyEvent.ACTION_MULTIPLE) {
            return false;
        }

        synchronized (this) {
            Input.KeyEvent keyEvent = keyEventPool.newObject();
            keyEvent.keyCode = keyCode;
        }
        return false;
    }


}
