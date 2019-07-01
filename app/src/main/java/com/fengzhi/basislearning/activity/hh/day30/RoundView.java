package com.fengzhi.basislearning.activity.hh.day30;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * 测量方法
 */
public class RoundView extends View{
    private Paint paint;

    public RoundView(Context context) {
        super(context);
        //在构造方法中初始化画笔
        initPaint();
    }

    public RoundView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    private void initPaint(){
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
    }

    //绘制界面
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(50,50,50,paint);

    }


    /**
     * 测量控件的宽高
     * @param widthMeasureSpec:和控件的宽度和宽度模式有关，组成的一个数据
     * @param heightMeasureSpec：和控件的高度和高度模式有关，组成的一个数据
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        //获取到宽度模式
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        //获取到宽度的大小
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);


        //获取到高度的模式
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        //获取到高度的大小
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        //EXACTLY:说明当前控件宽/高给的值是match_parent或者一个确定的值200dp
        //AT_MOST：说明当前控件的宽/高给的值是wrap_content
        if (widthMode == MeasureSpec.EXACTLY  && heightMode == MeasureSpec.EXACTLY){

            Log.i("info","=====当前控件的宽高为一个固定值====="+widthSize+"=="+heightSize);

        }else if (widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.AT_MOST){
            //768   1022
            Log.i("info","=====当前控件的宽高为内容包裹==========="+widthSize+"=="+heightSize);

//            widthSize = 100;
//            heightSize = 100;
//            setMeasuredDimension(widthSize,heightSize);
//            Log.i("info", "=result===" + widthSize + heightSize);
        }


        //单方向测量
        if (widthMode == MeasureSpec.AT_MOST){
            widthSize = 100;
        }

        if (heightMode == MeasureSpec.AT_MOST){
            heightSize = 100;
        }

        //重新设置控件的宽高
        setMeasuredDimension(widthSize,heightSize);


    }
}
