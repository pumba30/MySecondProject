package pandroidsoft.com.mysecondproject;

/**
 * Created by pumba30 on 08.02.2015.
 */
public interface Music {

    public void play();

    public void stop();

    public void pause();

    public void setLooping(boolean looping);

    public void setVolume(float volume);

    public boolean isPlaying();

    public boolean isStopped();

    public boolean isLooping();

    public void dispose();//освободить системные ресурсы, для освобождения памяти и потенциально связанных системных ресурсов

}
