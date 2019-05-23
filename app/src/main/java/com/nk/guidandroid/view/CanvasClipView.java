package com.nk.guidandroid.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/**
 * 范围裁剪
 */
public class CanvasClipView extends View{
    public CanvasClipView(Context context) {
        super(context);
    }

    public CanvasClipView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    private void clipRect(){

    }

    private void clipPath(){

    }

    private void clipOurRect(){

    }

    private void clipOutPath(){

    }
}
