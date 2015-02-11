package pandroidsoft.com.mysecondproject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/**
 * Created by pumba30 on 11.02.2015.
 */
public class SingleTouchTest extends Activity implements View.OnTouchListener {

    StringBuilder builder = new StringBuilder();
    TextView textView;


    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        textView = new TextView(this);
        textView.setText("Touch and drag (one finger only)");
        textView.setOnTouchListener(this);
        setContentView(textView);

    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        builder.setLength(0);
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                builder.append("down, ");
                break;
            case MotionEvent.ACTION_MOVE:
                builder.append("move, ");
                break;
            case MotionEvent.ACTION_CANCEL:
                builder.append("cansel, ");
                break;
            case MotionEvent.ACTION_UP:
                builder.append("up, ");
                break;
        }
        builder.append(event.getX());
        builder.append(". ");
        builder.append(event.getY());
        String text = builder.toString();
        Log.d("Touch test", text);
        return true;
    }
}
