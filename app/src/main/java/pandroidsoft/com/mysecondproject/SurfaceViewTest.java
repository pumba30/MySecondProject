package pandroidsoft.com.mysecondproject;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by pumba30 on 19.02.2015.
 */
public class SurfaceViewTest extends Activity {
    FastRenderView renderView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        renderView = new FastRenderView(this);
        setContentView(renderView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        renderView.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        renderView.pause();
    }


    class FastRenderView extends SurfaceView implements Runnable {
        Thread renderThread = null;
        SurfaceHolder surfaceHolder;
        volatile boolean running = false;

        public FastRenderView(Context context) {
            super(context);
            surfaceHolder = getHolder();
        }

        public void resume() {
            running = true;
            renderThread = new Thread(this);
            renderThread.start();
        }

        public void pause() {
            running = false;
            while (true) {
                try {
                    renderThread.join();

                } catch (InterruptedException e) {
                    //повтор?
                }
            }
        }

        @Override
        public void run() {
            while (running) {
                if (!surfaceHolder.getSurface().isValid()) {
                    continue;
                }

                Canvas canvas = surfaceHolder.lockCanvas();
                canvas.drawRGB(255, 0, 0);
                surfaceHolder.unlockCanvasAndPost(canvas);
            }
        }
    }
}




