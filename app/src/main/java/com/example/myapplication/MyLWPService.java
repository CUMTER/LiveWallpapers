package com.example.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.service.wallpaper.WallpaperService;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.WindowInsets;

import com.orhanobut.logger.Logger;

public class MyLWPService extends WallpaperService {
    public MyLWPService() {
        super();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        android.os.Debug.waitForDebugger();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public Engine onCreateEngine() {

        Logger.d("create engine");
        return new MyEngine();
    }

    class MyEngine extends Engine {

        Bitmap b ;
        private final android.os.Handler handler = new Handler();

        private final Runnable mDrawThread = new Runnable() {
            public void run() {
                drawFrame();
            }
        };

        public MyEngine() {
            setBackground();
        }

        @Override
        public SurfaceHolder getSurfaceHolder() {
            return super.getSurfaceHolder();
        }

        @Override
        public int getDesiredMinimumWidth() {
            return super.getDesiredMinimumWidth();
        }

        @Override
        public int getDesiredMinimumHeight() {
            return super.getDesiredMinimumHeight();
        }

        @Override
        public boolean isVisible() {
            return super.isVisible();
        }

        @Override
        public boolean isPreview() {
            return super.isPreview();
        }

        @Override
        public void onCreate(SurfaceHolder surfaceHolder) {
            super.onCreate(surfaceHolder);
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
        }

        @Override
        public void onVisibilityChanged(boolean visible) {
            Logger.d("visibility change ");
            if(visible) {
                drawFrame();
            }else {
                handler.removeCallbacks(mDrawThread);
            }
            super.onVisibilityChanged(visible);
        }

        @Override
        public void onApplyWindowInsets(WindowInsets insets) {
            super.onApplyWindowInsets(insets);
        }

        @Override
        public void onTouchEvent(MotionEvent event) {
            super.onTouchEvent(event);
        }

        @Override
        public void onOffsetsChanged(float xOffset, float yOffset, float xOffsetStep, float yOffsetStep, int xPixelOffset, int yPixelOffset) {
            super.onOffsetsChanged(xOffset, yOffset, xOffsetStep, yOffsetStep, xPixelOffset, yPixelOffset);
        }

        @Override
        public void onSurfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            super.onSurfaceChanged(holder, format, width, height);
        }

        @Override
        public void onSurfaceRedrawNeeded(SurfaceHolder holder) {
            super.onSurfaceRedrawNeeded(holder);
        }

        @Override
        public void onSurfaceCreated(SurfaceHolder holder) {
            super.onSurfaceCreated(holder);
        }

        @Override
        public void onSurfaceDestroyed(SurfaceHolder holder) {
            super.onSurfaceDestroyed(holder);
        }

        private void setBackground() {

            b = BitmapFactory.decodeResource(getResources(),
                    R.drawable.test);
        }

        private void drawFrame() {

            Logger.d("draw frame");
            final SurfaceHolder holder = getSurfaceHolder();
            final Rect frame = holder.getSurfaceFrame();

            Canvas c = null;

            try {
                c = holder.lockCanvas();
                if (c != null) {
                    c.drawBitmap(b,0f,0f,null);
                }
            } finally {
                if (c != null) holder.unlockCanvasAndPost(c);
            }
            if(isVisible()){
                handler.postDelayed(mDrawThread,20);
            }

        }
    }
}
