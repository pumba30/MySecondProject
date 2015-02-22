package pandroidsoft.com.mysecondproject.impl;

import android.graphics.Bitmap;

import pandroidsoft.com.mysecondproject.Graphics;
import pandroidsoft.com.mysecondproject.Pixmap;

/**
 * Created by pumba30 on 21.02.2015.
 */
public class AndroidPixmap implements Pixmap {

    Bitmap bitmap;
    Graphics.PixmapFormat format;

    public AndroidPixmap(Bitmap bitmap, Graphics.PixmapFormat format) {
        this.bitmap = bitmap;
        this.format = format;
    }


    @Override
    public int getWidth() {
        return bitmap.getWidth();
    }

    @Override
    public int getHeight() {
        return bitmap.getHeight();
    }

    @Override
    public Graphics.PixmapFormat getFormat() {
        return format;
    }

    @Override
    public void dispose() {
        bitmap.recycle();
    }
}
