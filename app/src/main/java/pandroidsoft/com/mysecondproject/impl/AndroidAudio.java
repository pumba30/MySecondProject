package pandroidsoft.com.mysecondproject.impl;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;

import java.io.IOException;

import pandroidsoft.com.mysecondproject.Audio;
import pandroidsoft.com.mysecondproject.Music;
import pandroidsoft.com.mysecondproject.Sound;

/**
 * Created by pumba30 on 19.02.2015.
 */
public class AndroidAudio implements Audio {

    AssetManager assets;
    SoundPool soundPool;

    public AndroidAudio(Activity activity) {
        activity.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        this.assets = activity.getAssets();
        this.soundPool = new SoundPool(20, AudioManager.STREAM_MUSIC, 0);
    }

    @Override
    public Music newMusic(String fileName) {
        try {
            AssetFileDescriptor assetFileDescriptor = assets.openFd(fileName);
            return new AndroidMusic(assetFileDescriptor);
        } catch (IOException e) {
            throw new RuntimeException("Невозможно загрузить музыку '" + fileName + "'");
        }

    }

    @Override
    public Sound newSound(String fileName) {
        try{
            AssetFileDescriptor assetFileDescriptor = assets.openFd(fileName);
            int soundId = soundPool.load(assetFileDescriptor, 0);
            return new AndroidSound(soundPool, soundId);
        } catch (IOException e){
            throw new RuntimeException("Невозможно загрузить звук '" + fileName + "'");
        }
    }
}
