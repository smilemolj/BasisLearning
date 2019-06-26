package com.fengzhi.basislearning;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
//可在logcat添加过滤条件   System.out
    @OnClick(R.id.button)
    public void onViewClicked() {
        StringDemo.learn();
    }
}
