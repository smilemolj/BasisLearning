package com.fengzhi.basislearning.activity.hh.day30;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * 在手机的屏幕范围内，绘制的图案自动跳转
 * <p>
 * <p>
 * 自定义控件。实现有下载功能的图片控件。
 */
public class ScreenProtectView extends View {
    private Paint paint;
    private static final int radius = 30;//半径
    private float cx = radius;//圆心的x，y坐标
    private float cy = radius;
    private boolean isGoRight = true;//判断是否能继续往右走
    private boolean isGoDown = true;//判断是否能继续往下走
    private float width, height;//控件的宽，高


    public ScreenProtectView(Context context) {
        super(context);
        initPaint();
    }

    public ScreenProtectView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    private void initPaint() {
        paint = new Paint();
        paint.setColor(Color.GRAY);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(cx, cy, radius, paint);

        //获取控件的宽高
        width = getWidth();
        height = getHeight();

    }

    //启动运行
    public void startRun() {
        new Thread(() -> {//子线程
            while (true) {
                if ((cx + radius) >= width) {//不能继续往右
                    isGoRight = false;
                }

                if (cx <= radius) {//不能继续往左
                    isGoRight = true;
                }

                if ((cy + radius) >= height) {//不能继续往下
                    isGoDown = false;
                }

                if (cy <= radius) {//不能继续往上
                    isGoDown = true;
                }


                if (isGoRight) {//如果是往右移动，圆心的x坐标往右加像素点
                    cx += 5;
                } else {
                    cx -= 5;
                }


                if (isGoDown) {//如果往下移动，圆心的y坐标就加像素点
                    cy += 5;
                } else {
                    cy -= 5;
                }

//                postInvalidate();
                invalidate();//在主线程中更新界面

                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }).start();
    }


}
