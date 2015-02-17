package pandroidsoft.com.mysecondproject;

import android.app.ActionBar;
import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;

/**
 * Created by pumba30 on 17.02.2015.
 */
public class SoundPoolTest extends Activity implements View.OnTouchListener {

    SoundPool soundPool;
    int shotSoundId = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textView = new TextView(this);
        textView.setOnTouchListener(this);
        setContentView(textView);

        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        soundPool = new SoundPool(20, AudioManager.STREAM_MUSIC, 0);

        try {
            AssetManager assetManager = getAssets();
            AssetFileDescriptor descriptor = assetManager.openFd("shoting.ogg");
            shotSoundId = soundPool.load(descriptor, 1);
        } catch (IOException e) {
            textView.setText("Couldnt losd sound effect from asset, " + e.getMessage());

        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            if (shotSoundId != -1) {
                soundPool.play(shotSoundId, 1, 1, 0, 0, 1);
            }
        }
        return true;
    }
}
