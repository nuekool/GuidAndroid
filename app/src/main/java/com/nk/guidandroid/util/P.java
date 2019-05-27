package com.nk.guidandroid.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

public class P {

    public static Bitmap getBitmap(Drawable drawable, int w, int h){
        Bitmap.Config config = Config.ARGB_8888;
        Bitmap b = Bitmap.createBitmap(w, h, config);
        Canvas canvas = new Canvas(b);
        drawable.setBounds(0 ,0, w, h);
        drawable.draw(canvas);
        return b;
    }

    public static Bitmap getBitmap(Drawable drawable){
        Bitmap.Config config = Config.ARGB_8888;
        int w = drawable.getIntrinsicWidth();
        int h = drawable.getIntrinsicHeight();
        Bitmap b = Bitmap.createBitmap(w, h, config);
        Canvas canvas = new Canvas(b);
        drawable.setBounds(0 ,0, w, h);
        drawable.draw(canvas);
        return b;
    }
}
