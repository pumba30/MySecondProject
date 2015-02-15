package pandroidsoft.com.mysecondproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/**
 * Created by pumba30 on 15.02.2015.
 */
public class MultiTouchTest extends Activity implements View.OnTouchListener {

    StringBuilder builder = new StringBuilder();
    TextView textView;

    float[] x = new float[10];
    float[] y = new float[10];
    boolean[] touched = new boolean[10];

    private void updateTextView() {
        builder.setLength(0);
        for (int i = 0; i < 10; i++) {
            builder.append(touched[i]);
            builder.append(", ");
            builder.append(x[i]);
            builder.append(", ");
            builder.append(y[i]);
            builder.append("\n");
        }
        textView.setText(builder.toString());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textView = new TextView(this);
        textView.setText("Touch and drag (multiple fingers supported)!");
        ;
        textView.setOnTouchListener(this);
        setContentView(textView);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        //Начинаем с получения типа
        //события на основе целого числа, возвращенного методом event.getAction();
        //получаем номер указателя и соответствующий ему идентификатор из MotionEvent
        int action = event.getAction() & MotionEvent.ACTION_MASK;
        int pointerIndex = (event.getAction() & MotionEvent.ACTION_POINTER_ID_MASK) >>
                MotionEvent.ACTION_POINTER_ID_SHIFT;
        int pointerId = event.getPointerId(pointerIndex);

        switch (action) {
            //Для таких идентификаторов указателей мы устанавливаем состояние
            //касания в true, а также сохраняем текущие координаты этого указателя.
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_POINTER_DOWN:
                touched[pointerId] = true;
                x[pointerId] = (int) event.getX(pointerIndex);
                y[pointerId] = (int) event.getY(pointerIndex);
                break;
            //Произошел отрыв указателя от экрана
            // Состояние касания для таких иденти-фикаторов устанавливается в false,
            //сохраняются их последние известные
            //координаты.
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
            case MotionEvent.ACTION_CANCEL:
                touched[pointerId] = false;
                x[pointerId] = (int) event.getX(pointerIndex);
                y[pointerId] = (int) event.getY(pointerIndex);
                break;
            //Один или несколько пальцев двигаются по экрану
            //Мы проверяем количество событий, находящихся в данный момент в MotionEvent,
            // и затем обновляем координаты для номеров указателей от 0 до MotionEvent
            case MotionEvent.ACTION_MOVE:
                int pointerCount = event.getPointerCount();
                for (int i = 0; i < pointerCount; i++) {
                    pointerIndex = i;
                    pointerId = event.getPointerId(pointerIndex);
                    x[pointerId] = (int) event.getX(pointerIndex);
                    y[pointerId] = (int) event.getY(pointerIndex);
                }
                break;
        }
        updateTextView();
        return true;
    }
}
