package com.nk.guidandroid.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import com.nk.guidandroid.R;
import com.nk.guidandroid.util.D;
import com.nk.guidandroid.util.P;

import java.util.Calendar;

/**
 * 基本图形绘制
 */
public class BaseShapeView extends View{

    private int width = (int) D.dp2px(100);
    private int width2 = (int) D.dp2px(150);
    private int width3 = (int) D.dp2px(200);
    private int startX = (int) D.dp2px(10);
    private int startY = (int) D.dp2px(10);
    private int offset = (int) D.dp2px(10);
    private int rx = (int) D.dp2px(10);
    private int radius = (int) D.dp2px(50);
    private int radius2 = (int) D.dp2px(120);
    private Paint mPaint, mPaint_time, mPaint_h, mPaint_m, mPaint_s;
    {
        //初始化画笔
        mPaint = new Paint();
        mPaint.setDither(true);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(D.dp2px(10));
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setColor(Color.BLACK);

        mPaint_time = new Paint();
        mPaint_time.setDither(true);
        mPaint_time.setAntiAlias(true);
        mPaint_time.setStyle(Paint.Style.STROKE);
        mPaint_time.setStrokeWidth(D.dp2px(2));
        mPaint_time.setTextSize(15);
        mPaint_time.setStrokeCap(Paint.Cap.ROUND);
        mPaint_time.setStrokeJoin(Paint.Join.ROUND);
        mPaint_time.setColor(Color.DKGRAY);

        mPaint_h = new Paint();
        mPaint_h.setDither(true);
        mPaint_h.setAntiAlias(true);
        mPaint_h.setStyle(Paint.Style.STROKE);
        mPaint_h.setStrokeWidth(6);
        mPaint_h.setTextSize(15);
        mPaint_h.setStrokeCap(Paint.Cap.ROUND);
        mPaint_h.setStrokeJoin(Paint.Join.ROUND);
        mPaint_h.setColor(Color.DKGRAY);

        mPaint_m = new Paint();
        mPaint_m.setDither(true);
        mPaint_m.setAntiAlias(true);
        mPaint_m.setStyle(Paint.Style.STROKE);
        mPaint_m.setStrokeWidth(4);
        mPaint_m.setTextSize(15);
        mPaint_m.setStrokeCap(Paint.Cap.ROUND);
        mPaint_m.setStrokeJoin(Paint.Join.ROUND);
        mPaint_m.setColor(Color.DKGRAY);

        mPaint_s = new Paint();
        mPaint_s.setDither(true);
        mPaint_s.setAntiAlias(true);
        mPaint_s.setStyle(Paint.Style.STROKE);
        mPaint_s.setStrokeWidth(2);
        mPaint_s.setTextSize(15);
        mPaint_s.setStrokeCap(Paint.Cap.ROUND);
        mPaint_s.setStrokeJoin(Paint.Join.ROUND);
        mPaint_s.setColor(Color.DKGRAY);
    }

    public BaseShapeView(Context context) {
        super(context);
    }

    public BaseShapeView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawColor(canvas);
        drawLine(canvas);
        drawRect(canvas);
        drawRoundRect(canvas);
        drawCircle(canvas);
        drawOval(canvas);
        drawArc(canvas);
        drawPoint(canvas);
        drawPath(canvas);
    }

    private void drawColor(Canvas canvas){
        canvas.drawColor(Color.LTGRAY);
    }

    private void drawLine(Canvas canvas){
        canvas.drawLine(startX, startY, startX + width, startY + width, mPaint);
    }

    private void drawRect(Canvas canvas){
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(startX + width + offset, startY, startX + width + offset + width, startY + width, mPaint);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void drawRoundRect(Canvas canvas){
        canvas.drawRoundRect(startX + width + offset + width + offset, startY,
                startX + width + offset + width+  offset + width,
                startY + width, rx, rx, mPaint);
    }


    private void drawCircle(Canvas canvas){
        canvas.drawCircle(startX + width/2, startY + width + offset + width / 2, radius, mPaint);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void drawOval(Canvas canvas){
        canvas.drawOval(startX + width + offset, startY + width + offset,
                startX + width + offset + width2, startY + width + offset + width, mPaint);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void drawArc(Canvas canvas){
        canvas.drawArc(startX + width + offset + width2 + offset,
                startY + width + offset,
                startX + width + offset + width2 + offset + width,
                startY + width + offset + width, 120, 90, true, mPaint);
    }

    private void drawPoint(Canvas canvas){
        canvas.drawPoint(startX + width/2, startY + width + offset + width + offset + width/2, mPaint);
    }

    /**
     * 画个表盘
     * @param canvas
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void drawPath(Canvas canvas){
        mPaint.setColor(Color.BLACK);
        int rx = getWidth() / 2;
        int ry = startY + width + offset + width + offset + width + offset * 3;
        //初始化刻度
        Path pathCircle  = new Path();
        pathCircle.addCircle(rx, ry, radius2, Path.Direction.CCW);
        Path pathCircle_temp  = new Path();
        pathCircle_temp.addCircle(rx, ry, radius2 - D.dp2px(5), Path.Direction.CCW);
        Path pathCircle_h  = new Path();
        pathCircle_h.addCircle(rx, ry,radius2-D.dp2px(30), Path.Direction.CCW);
        Path pathCircle_m  = new Path();
        pathCircle_m.addCircle(rx, ry,radius2 - D.dp2px(15), Path.Direction.CCW);
        //初始化PathMeasure测量path坐标，
        PathMeasure measure = new PathMeasure();
        //第二个参数影响测试结果：path未关闭，forceCLose未关闭
        measure.setPath(pathCircle_temp,true);
        PathMeasure measure_h = new PathMeasure();
        measure_h.setPath(pathCircle_h,true);
        PathMeasure measure_m = new PathMeasure();
        measure_m.setPath(pathCircle_m,true);
        //获取刻度path
        Path pathDuration = new Path();
        for (int i = 60; i>0 ;i --){
            Path path = new Path();
            float pos [] = new float[2];
            float tan [] = new float[2];
            float pos2 [] = new float[2];
            float tan2 [] = new float[2];
            float pos3 [] = new float[2];
            float tan3 [] = new float[2];
            //得到路径上某一长度的位置以及该位置的正切值
            measure.getPosTan(measure.getLength()*i/60, pos, tan);
            measure_h.getPosTan(measure_h.getLength()*i/60, pos2, tan2);
            measure_m.getPosTan(measure_m.getLength()*i/60, pos3, tan3);

            float x = pos[0];
            float y = pos[1];
            float x2 = pos2[0];
            float y2 = pos2[1];
            float x3 = pos3[0];
            float y3 = pos3[1];

            path.moveTo(x , y);
            //圆圈路径绘制
            if(i% 5 ==0){
                path.lineTo(x2,y2);
                path.close();
            }else{
                path.lineTo(x3,y3);
            }
            pathDuration.addPath(path);
        }

        canvas.drawPath(pathCircle, mPaint);
        canvas.drawPath(pathDuration, mPaint_time);

        drawBitmap(canvas, rx, ry);
        drawClockLine(canvas, rx, ry);
        drawText(canvas, rx, (int) (ry + radius2 + D.dp2px(50)));
    }

    private void drawBitmap(Canvas canvas, int x, int y){
        Bitmap bm = P.getBitmap(getResources().getDrawable(R.mipmap.logo), (int)D.dp2px(40), (int)D.dp2px(10));
        canvas.drawBitmap(bm, x - bm.getWidth()/2, y - radius2 + D.dp2px(40), mPaint);
    }

    private void drawClockLine(Canvas canvas, int x, int y){
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR);//Calendar.HOUR获取的是12小时制，Calendar.HOUR_OF_DAY获取的是24小时制
        int min = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        //计算时分秒指针各自需要偏移的角度
        float hourAngle = (float)hour / 12 * 360 + (float)min / 60 * (360 / 12);//360/12是指每个数字之间的角度
        float minAngle = (float)min / 60 * 360;
        float secAngle = (float)second / 60 * 360;
        //下面将时、分、秒指针按照各自的偏移角度进行旋转，每次旋转前要先保存canvas的原始状态
        canvas.save();
        canvas.rotate(hourAngle,x, y);
        canvas.drawLine(x, y, x + D.dp2px(50), y, mPaint_h);//时针长度设置为65

        canvas.restore();
        canvas.save();
        canvas.rotate(minAngle,x, y);
        canvas.drawLine(x, y, x + D.dp2px(70), y, mPaint_m);//分针长度设置为90

        canvas.restore();
        canvas.save();
        canvas.rotate(secAngle,x, y);
        canvas.drawLine(x, y, x + D.dp2px(90), y, mPaint_s);//秒针长度设置为110

        canvas.restore();
    }

    private void drawText(Canvas canvas, int x, int y){
        String text = "2019 浪琴名匠";
        mPaint.setTypeface(Typeface.createFromAsset(getResources().getAssets(), "fonts/ts.ttf"));
        mPaint.setTextSize(D.dp2px(48));
        mPaint.setColor(Color.DKGRAY);
        int tw = (int) mPaint.measureText(text);
        canvas.drawText(text, x - tw/2 , y, mPaint);
    }
}
