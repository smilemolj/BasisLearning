package com.fengzhi.basislearning.activity.hh.day17;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.fengzhi.basislearning.R;
import com.fengzhi.basislearning.base.SlideBackBaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QieHuanActivity extends SlideBackBaseActivity {
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.img)
    ImageView img;
    private int curId = R.mipmap.ic_launcher;
    private Handler handler;

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        title.setText("QieHuanActivity");
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                int flag = msg.what;
                if (flag == 1) {
                    int index = msg.arg1;
                    img.setImageResource(index);
                } else if (flag == 2) {
                    if (curId == R.mipmap.ic_launcher) {
                        curId = R.mipmap.download;
                    } else {
                        curId = R.mipmap.ic_launcher;
                    }
                    img.setImageResource(curId);
                    //Thread.sleep(2000);最好不要在主线程中有sleep操作
                    handler.sendEmptyMessageDelayed(2, 2000);
                }
            }
        };
    }

    public void btnShow(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {

                    if (curId == R.mipmap.ic_launcher) {
                        curId = R.mipmap.download;
                    } else {
                        curId = R.mipmap.ic_launcher;
                    }

                    Message message = Message.obtain();
                    message.what = 1;
                    message.arg1 = curId;
                    handler.sendMessage(message);

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//					handler.sendMessageDelayed(message, 2000);
                }
            }
        }).start();
    }

    public void btnShow2(View view) {
        handler.sendEmptyMessage(2);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_qie_huan;
    }
}
