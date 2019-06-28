package com.fengzhi.basislearning.activity.hh.day17;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.fengzhi.basislearning.R;
import com.fengzhi.basislearning.base.SlideBackBaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 如果需要用到message消息的传输，那么创建的handler对象就必须重写handleMessage（）方法
 * 如果是通过handler.post（）来处理的数据，那么handler对象就不需要重写handleMessage（）方法
 * <p>
 * <p>
 * 总结：
 * 把数据从子线程回拋到主线程的方法：
 * 1.利用handler的发送消息（handler对象必须重写handleMessage（）方法）
 * 2.利用handler的post的方法，把线程回拋到主线程（handler对象不用重写handleMessage（）方法）
 * 3.利用控件的post方法，把线程回拋到主线程
 * 4.在activity中调用runOnUiThread（），强制把数据运行在主线程
 */
public class Handler1Activity extends SlideBackBaseActivity {
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.tvTime)
    TextView tvTime;
    private int time = 10;
    private Handler handler;

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        title.setText("Handler1Activity");
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == 1) {
                    tvTime.setText(time + "");
                    time--;
                    if (time != (-1)) {
                        handler.sendEmptyMessageDelayed(1, 1000);
                    }
                }
            }
        };
        new Thread(() -> {//子线程
            //错误本身是存在的。只是由于刚绘制视图，错误还没有被检测出来
            tvTime.setText("new Text");
        }).start();
    }

    //点击开始倒计时
    public void start(View view) {
        handler.sendEmptyMessage(1);
    }

    public void runToMain(View view) {
        new Thread(() -> {//子线程
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            final String result = "下载的json字符串";
//						handler.post(new Runnable() {
//							@Override
//							public void run() {//主线程
//								tvTime.setText(result);
//							}
//						});

						tvTime.post(() -> tvTime.setText(result));

            runOnUiThread(() -> tvTime.setText(result));
        }).start();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_handler1;
    }
}
