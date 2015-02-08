package pandroidsoft.com.mysecondproject;

/**
 * Created by pumba30 on 08.02.2015.
 */
public interface Sound {

    public void play(float volume);

    public void dispose();//освободить системные ресурсы, для освобождения памяти и потенциально связанных системных ресурсов
}
