package com.fengzhi.basislearning.activity.hh.day29;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.fengzhi.basislearning.R;

/**
 * 购物控件 － 100 +
 */
public class CustomView extends LinearLayout
        implements View.OnClickListener{
    private int number = 0;//数量
    private TextView textView;

    public CustomView(Context context) {
        super(context);
        newView();
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        newView();
    }

    //绘制新页面
    public void newView(){
        ImageButton btnLeft = new ImageButton(getContext());
        btnLeft.setImageResource(R.drawable.reduce);
        btnLeft.setBackgroundColor(Color.TRANSPARENT);//设置背景颜色透明

        textView = new TextView(getContext());
        textView.setText(number+"");

        LayoutParams params = new LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        //设置了文本控件的宽高
        textView.setLayoutParams(params);
        textView.setGravity(Gravity.CENTER_VERTICAL);
        textView.setPadding(10, 0, 10, 0);

        ImageButton btnRight = new ImageButton(getContext());
        btnRight.setImageResource(R.drawable.add);
        btnRight.setBackgroundColor(Color.TRANSPARENT);

        addView(btnLeft);
        addView(textView);
        addView(btnRight);


        //用来区分监听器。
        btnLeft.setTag("btnLeft");
        btnRight.setTag("btnRight");

        btnLeft.setOnClickListener(this);
        btnRight.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
      //获取到被点击的控件的tag
       String tag = (String) v.getTag();
        if ("btnLeft".equals(tag)){//减少
            if (number == 0){
                Toast.makeText(getContext(),"已经没有可以减的了",Toast.LENGTH_LONG).show();
                return;
            }

            number--;


        }else if ("btnRight".equals(tag)){//增加
            number++;
        }

        textView.setText(number +"");
    }


    //返回最后的数量
    public int getNumber(){
        return number;
    }
}
