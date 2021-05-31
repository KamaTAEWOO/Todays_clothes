package com.example.todayclothes;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;

public class ScreenshotUtil {
    private static ScreenshotUtil mInstance;
    private ScreenshotUtil() {
    }
    public static ScreenshotUtil getInstance() {
        if (mInstance == null) {
            synchronized (ScreenshotUtil.class) {
                if (mInstance == null) {
                    mInstance = new ScreenshotUtil();//^^
                }
            }
        }
        return mInstance;
    }

    // Bitmap 으로 리턴
    public Bitmap takeScreenshotForView(View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(view.getWidth(), View.MeasureSpec.EXACTLY), View.MeasureSpec.makeMeasureSpec(view.getHeight(), View.MeasureSpec.EXACTLY));//^^
        view.layout((int) view.getX(), (int) view.getY(), (int) view.getX() + view.getMeasuredWidth(), (int) view.getY() + view.getMeasuredHeight());
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache(true);
        Bitmap bitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        return bitmap;
    }
    public Bitmap takeScreenshotForScreen(Activity activity) {
        return takeScreenshotForView(activity.getWindow().getDecorView().getRootView());//^^
    }
}