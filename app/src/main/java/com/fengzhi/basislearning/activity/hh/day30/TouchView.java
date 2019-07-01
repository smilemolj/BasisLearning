package com.fengzhi.basislearning.activity.hh.day30;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.fengzhi.basislearning.R;

/**
 * 可以让控件上的图片随着手指的滑动而改变位置
 */
public class TouchView extends View {
    private Paint paint;
    private float x, y;//绘制图片的左上角的坐标
    private  float imgW,imgH;//绘制的图片的宽高的大小
    private boolean isInImg;//判断用户的手指是否按在了图片上


    public TouchView(Context context) {
        super(context);
        paint = new Paint();
    }

    public TouchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap = BitmapFactory.
                decodeResource(getResources(), R.mipmap.location);
        canvas.drawBitmap(bitmap, x, y, paint);

        //获取到当前控件的宽高
        int width = getWidth();
        int height = getHeight();

        //获取到绘制的图片的宽高
        imgW = bitmap.getWidth();
        imgH = bitmap.getHeight();

        //Log.i("info",width+"=="+height);
        //Log.i("info",width1+"=="+height1);
    }

    //控件的触摸事件
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //获取到当前的手势动作
        int curAction = event.getAction();

        //获取到当前的手指触摸到屏幕的x，y坐标
        float curX = event.getX();
        float curY = event.getY();

        if (curAction == MotionEvent.ACTION_DOWN) {
            //判断手指是否按在了图片上 x<curX<(x+w)   y<curY<(y+H)
            if (curX >x && curX <(x +imgW)   &&  curY>y && curY<(y +imgH)){
                isInImg = true;
            }else{
                isInImg = false;
            }
            Log.i("info", "====ACTION_DOWN=====" + curX + "==" + curY+"=="+isInImg);

        } else if (curAction == MotionEvent.ACTION_MOVE) {
            Log.i("info", "====ACTION_MOVE=====");
            //
            if (isInImg) {
                x = curX - imgW/2;
                y = curY  - imgH/2;
                //重新绘制图片  相当于重新调用onDraw
                invalidate();
            }

        } else if (curAction == MotionEvent.ACTION_UP) {
            Log.i("info", "====ACTION_UP=====");
            isInImg = false;
        }

        return true;
    }
}
