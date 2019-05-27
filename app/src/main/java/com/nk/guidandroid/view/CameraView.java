package com.nk.guidandroid.view;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.nk.guidandroid.R;
import com.nk.guidandroid.util.D;
import com.nk.guidandroid.util.P;

/**
 * 二维变三维，相机调整
 */
public class CameraView extends View{

    private Paint paint;
    {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    public CameraView(Context context) {
        super(context);
    }

    public CameraView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setCamera(canvas);
        canvas.drawBitmap(P.getBitmap(getResources().getDrawable(R.mipmap.il)), getWidth()/2, getHeight()/2, paint);
    }

    private void setCamera(Canvas canvas){
        Camera camera  = new Camera();
        camera.save();
        //inch
        camera.setLocation(0,0,-30);//设置相机位置
        //        camera.rotate();
//        camera.translate();
        camera.rotate(0,30,0);
//        camera.getMatrix(mMatrix);
        camera.applyToCanvas(canvas);
        camera.restore();
//        mMatrix.postTranslate(0,500);
    }
}
