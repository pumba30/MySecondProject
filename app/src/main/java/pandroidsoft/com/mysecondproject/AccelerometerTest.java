package pandroidsoft.com.mysecondproject;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by pumba30 on 17.02.2015.
 */
public class AccelerometerTest extends Activity implements SensorEventListener {

    StringBuilder builder = new StringBuilder();
    TextView textView;


    @TargetApi(Build.VERSION_CODES.KITKAT_WATCH)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textView = new TextView(this);
        setContentView(textView);

        //проверка доступности  датчика аксселерометрв
        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if (sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER).size() == 0) {
            textView.setText("No accelerometer installed");
        } else {
            Sensor accelerometer = sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER).get(0);
            if (!sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_GAME)) {
                textView.setText("Couldn`t register sensor listener");


            }
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        builder.setLength(0);
        builder.append("x: ");
        builder.append(event.values[0]);
        builder.append(" y: ");
        builder.append(event.values[1]);
        builder.append(" z: ");
        builder.append(event.values[2]);
        textView.setText(builder.toString());


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //здесь пока ничего не делаем
    }
}
