package pandroidsoft.com.mysecondproject;

/**
 * Created by pumba30 on 08.02.2015.
 */
public interface Pixmap {

    public int getWidth(); //возвращает ширину объекта Pixmap в пикселах

    public int getHeight(); //возвращает длину объекта Pixmap в пикселах

    public Graphics.PixmapFormat getFormat(); //возвращает формат, используемый для хранения Pixmap  в оперативной памяти

    public void dispose();
}
