package com.fengzhi.basislearning.activity.hh;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.fengzhi.basislearning.R;
import com.fengzhi.basislearning.activity.hh.day17.HandlerLoadActivity;
import com.fengzhi.basislearning.base.SlideBackBaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 通过handler传输数据的时候：
 * 1.通过同一个消息对象的同一个属性传值只能传递一个数据  eg：message.arg1 = 1   message.arg1 = 100
 * 2.处理数据的时候，可以获取到没有传值的属性。这些值都是默认初始值
 * 3.一个handler对象，可以传递多个消息对象
 */
public class HandlerActivity extends SlideBackBaseActivity {

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.btn)
    Button btn;
    private Handler handler;

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        title.setText("HandlerActivity");
        handler = new Handler() {
            //4.重写handleMessage接收传递过来的消息
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
				/*String result = (String) msg.obj;
				int arg1 = msg.arg1;
				int arg2 = msg.arg2;
				int what = msg.what;
				//int arg12 = msg.arg1;
				btn.setText(result+arg1+arg2+what);
				*/

                int what = msg.what;
                switch (what) {
                    case 3://代表传递的是第一个消息
                        String result = (String) msg.obj;
                        int arg1 = msg.arg1;
                        int arg2 = msg.arg2;
                        btn.setText(result + arg1 + arg2);
                        break;
                    case 5://代表传递的是第二个消息
                        String result2 = (String) msg.obj;
                        btn.setText(result2);
                        break;

                    default:
                        break;
                }

            }
        };
    }

    public void btnOnclick(View view) {
        //    			try {
        //					Thread.sleep(6000);
        //				} catch (InterruptedException e) {
        //					e.printStackTrace();
        //				}

        new Thread(new Runnable() {
            @Override
            public void run() {//子线程
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                String result = "经过网络下载得到的数据";
                //btn.setText(result);错误的
                //1.获取到一个消息对象
                Message message = handler.obtainMessage();
                //2.把要传递的数据封装到消息对象中
                message.obj = result;
                message.arg1 = 1;
                message.arg2 = 2;//和arg1一样的功能。运输整数数据
                message.what = 3;//一般传递的是标记（用来区分不同的message对象）
                //3.发送带有数据的消息对象
                handler.sendMessage(message);


                Message message2 = Message.obtain();
                message2.obj = "第二个消息传递的数据";
                message2.what = 5;
//                handler.sendMessage(message2);
                //发送延迟消息1000:消息发送要延迟的时间（单位：毫秒）
                handler.sendMessageDelayed(message2, 1000);


                //发送空消息
                handler.sendEmptyMessage(7);
                //等价于：
                Message message3 = Message.obtain();
                message3.what = 7;
                handler.sendMessage(message3);

            }
        }).start();

    }

    @OnClick(R.id.button2)
    public void onViewClicked() {
        startActivity(HandlerLoadActivity.class, null, false);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_handler;
    }
}
