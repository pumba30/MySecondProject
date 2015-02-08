package pandroidsoft.com.mysecondproject;

/**
 * Created by pumba30 on 08.02.2015.
 */


//Интерфейс для создания интерфейсов Music и Audio
public interface Audio {
    //потоковый аудиофайл
    public Music newMusic(String fileName);
    //короткий аудиоэффект
    public Sound newSound(String fileName);

}

