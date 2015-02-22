package pandroidsoft.com.mysecondproject;

/**
 * Created by pumba30 on 08.02.2015.
 */
public interface Graphics {
    //статичные перечисления для кодирования различных поддерживаемых нами форматов
    public static enum PixmapFormat {
        ARGB8888, ARGB4444, RGB565
    }

    public Pixmap newPixmap(String fileName, PixmapFormat format);// загружает изображение в JPEG- или PNG-формате

    public void clear(int color);//полностью очищает фреймбуфер с соответствующим цветом

    public void drawPixel(int x, int y, int color);//устанавливает значение пиксела фреймбуфера с координатами (x; y) в определенный цвет

    public void drawLine(int x, int y, int x2, int y2, int color);//Определяем начальную  и конечную точку линии, а также ее цвет

    public void drawRect(int x, int y, int width, int height, int color); //рисует прямоугольник во фреймбуфере

    /**
     * @param pixmap
     * @param x         определяют позицию левого верхнего угла расположения
     *                  цели Pixmapво фреймбуфере
     * @param y         -//-
     * @param srcX      выраженные в координатной системе Pixmap) обозначают соответствующий левый верхний угол участка
     *                  прямоугольника, используемого Pixmap
     * @param srcY      -//-
     * @param srcWhidth размер участка, который мы извлекаем из Pixmap
     * @param srcHeight -//-
     */
    public void drawPixmap(Pixmap pixmap, int x, int y, int srcX, int srcY,
                           int srcWhidth, int srcHeight);

    public void drawPixmap(Pixmap pixmap, int x, int y);

    public int getWidth(); // возвращает ширину фреймбуфера

    public int getHeight(); //возврщает длину фреймбуфера

}
