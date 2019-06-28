package com.fengzhi.basislearning.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.fengzhi.basislearning.R;
import com.fengzhi.basislearning.activity.sw.day04.ChooseActivity;
import com.fengzhi.basislearning.activity.sw.day04.AutocompleteActivity;
import com.fengzhi.basislearning.activity.sw.day04.SpinnerActivity;
import com.fengzhi.basislearning.activity.sw.day06.SaveActivity;
import com.fengzhi.basislearning.activity.sw.day12.DialogActivity;
import com.fengzhi.basislearning.base.BaseActivity;
import com.fengzhi.basislearning.gl.day13.CalendarDemo;
import com.fengzhi.basislearning.gl.day13.DateDemo;
import com.fengzhi.basislearning.gl.day13.RandomDemo;
import com.fengzhi.basislearning.gl.day13.StringDemo;
import com.fengzhi.basislearning.gl.day14.ArrarListDemo;
import com.fengzhi.basislearning.gl.day14.CollectionsDemo;
import com.fengzhi.basislearning.gl.day19.HelloThread;
import com.fengzhi.basislearning.gl.day19.TestSingle;
import com.fengzhi.basislearning.gl.day19.Ticket;
import com.fengzhi.basislearning.th.JsonDemo;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.title)
    TextView title;
    private long lastClickTime;

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        title.setText("Android基础学习");
    }

    @OnClick({R.id.button, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6,
            R.id.button7, R.id.button8, R.id.button9, R.id.button10, R.id.button11, R.id.button12
            , R.id.button13, R.id.button14, R.id.button15})
    public void onViewClicked(View view) {
        switch (view.getId()) {
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
                ArrarListDemo.learn();
                break;
            case R.id.button6:
                CollectionsDemo.learn();
                break;
            case R.id.button7:
                HelloThread.learn();
                break;
            case R.id.button8:
                Ticket.learn();
                break;
            case R.id.button9:
                System.out.println(TestSingle.getInstance().toString());
                break;
            case R.id.button10:
                JsonDemo.learn();
                break;
            case R.id.button11:
                startActivity(new Intent(this, ChooseActivity.class));
                break;
            case R.id.button12:
                startActivity(new Intent(this, AutocompleteActivity.class));
                break;
            case R.id.button13:
                startActivity(new Intent(this, SpinnerActivity.class));
                break;
            case R.id.button14:
                startActivity(new Intent(this, SaveActivity.class));
                break;
            case R.id.button15:
                startActivity(new Intent(this, DialogActivity.class));
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (lastClickTime <= 0) {
            Toast.makeText(this, "再按一次退出应用", Toast.LENGTH_SHORT).show();
            lastClickTime = System.currentTimeMillis();
        } else {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastClickTime < 2000) {
                finish();
            } else {
                Toast.makeText(this, "再按一次退出应用", Toast.LENGTH_SHORT).show();
                lastClickTime = System.currentTimeMillis();
            }
        }
    }//双击退出

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }
}
