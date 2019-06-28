package com.fengzhi.basislearning.activity.hh.day17;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.fengzhi.basislearning.R;
import com.fengzhi.basislearning.base.SlideBackBaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Handler2Activity extends SlideBackBaseActivity {
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.img)
    ImageView img;

    private Handler handler;
    private String path = "https://www.baidu.com/img/bd_logo1.png?where=super";

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        title.setText("Handler2Activity");
        new Thread(new Runnable() {
            @Override
            public void run() {//子线程
                //如果是在子线程中创建的handler对象，就必须调用Looper.prepare()，Looper.loop()
                //因为在主线程中默认已经自动调用了这两个方法，所以如果是在主线程中创建handler对象，就可以直接创建
                Looper.prepare();
                //需要处理（接收）数据，所以就在这创建handler对象
                handler = new Handler() {
                    @Override
                    public void handleMessage(Message msg) {
                        super.handleMessage(msg);
                        String content = (String) msg.obj;
                        Log.i("info", "=========" + content);
                    }
                };
                Looper.loop();
            }
        }).start();

    }

    //点击按钮发送数据到子线程中
    public void sendToWorker(View view) {
        String content = "要传递的数据";
        //传送数据
        Message message = Message.obtain();
        message.obj = content;
        handler.sendMessage(message);
    }


    public void btnDownLoad(View view) {
    	/*	HandlerNetworkUtil.doNetwork(path, new DataCallback() {
				@Override
				public void doData(byte[] bytes) {
					Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
					img.setImageBitmap(bitmap);
				}
			});
			*/
        Handler handler2 = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                byte[] bytes = (byte[]) msg.obj;
                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                img.setImageBitmap(bitmap);
            }
        };
        HandlerNetworkUtil2.doNetwork(path, handler2);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_handler2;
    }
}
