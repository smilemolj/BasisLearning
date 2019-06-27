package com.fengzhi.basislearning.activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.fengzhi.basislearning.R;
import com.fengzhi.basislearning.gl.DateDemo;
import com.fengzhi.basislearning.gl.RandomDemo;
import com.fengzhi.basislearning.gl.StringDemo;
import com.fengzhi.basislearning.gl.day13.CalendarDemo;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.title)
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setting();
    }

    @OnClick({R.id.title_back, R.id.button, R.id.button2, R.id.button3, R.id.button4, R.id.button5})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.button:
                StringDemo.learn();
                break;
            case R.id.button2:
                RandomDemo.learn();
                break;
            case R.id.button3:
                DateDemo.learn();
                break;
            case R.id.button4:
                CalendarDemo.learn();
                break;
            case R.id.button5:
                startActivity(new Intent(this, Main2Activity.class));
                break;
        }
    }

    private void setting() {
        title.setText("java基础学习");
        //禁止横屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            //将View全屏
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            //将状态栏改成背景色改成透明的
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

}
