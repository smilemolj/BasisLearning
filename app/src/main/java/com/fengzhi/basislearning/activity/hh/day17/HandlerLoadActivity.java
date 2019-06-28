package com.fengzhi.basislearning.activity.hh.day17;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.fengzhi.basislearning.R;
import com.fengzhi.basislearning.base.SlideBackBaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HandlerLoadActivity extends SlideBackBaseActivity {
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.img)
    ImageView img;
    private String path = "https://www.baidu.com/img/bd_logo1.png?where=super";
    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            byte[] bytes = (byte[]) msg.obj;
            if (bytes != null) {
                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                img.setImageBitmap(bitmap);
            } else {
                Toast.makeText(HandlerLoadActivity.this, "下载失败", Toast.LENGTH_LONG).show();
            }
        }
    };

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        title.setText("HandlerLoadActivity");

    }

    //下载图片
    public void downLoad(View view) {
        new Thread(() -> {
            byte[] bytes = NetworkUtils.getBytes(path);
            Message message = handler.obtainMessage();
            message.obj = bytes;
            handler.sendMessage(message);
        }).start();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_handlerload;
    }
}
