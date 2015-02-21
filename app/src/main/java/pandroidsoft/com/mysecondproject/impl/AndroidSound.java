package pandroidsoft.com.mysecondproject.impl;

import android.media.SoundPool;

import pandroidsoft.com.mysecondproject.Sound;

/**
 * Created by pumba30 on 19.02.2015.
 */
public class AndroidSound implements Sound {
    int soundId;
    SoundPool soundPool;

    public AndroidSound(SoundPool soundPool, int soundId) {
        this.soundId = soundId;
        this.soundPool = soundPool;
    }

    @Override
    public void play(float volume) {
        soundPool.play(soundId, volume, volume, 0, 0, 1);
    }

    @Override
    public void dispose() {
        soundPool.unload(soundId);

    }
}
