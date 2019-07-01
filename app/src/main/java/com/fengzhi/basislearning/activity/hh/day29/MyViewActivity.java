package com.fengzhi.basislearning.activity.hh.day29;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.fengzhi.basislearning.R;
import com.fengzhi.basislearning.base.SlideBackBaseActivity;

import butterknife.BindView;

public class MyViewActivity extends SlideBackBaseActivity {
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.img)
    DownImg img;
    @BindView(R.id.cv)
    CustomView cv;
    private String path = "https://www.baidu.com/img/bd_logo1.png?where=super";

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        title.setText("MyViewActivity");
        img.downLoad(path);
    }

    //点击确定购买
    public void btnSure(View view) {
        int number = cv.getNumber();
        Toast.makeText(this, "购买的数量是" + number, Toast.LENGTH_LONG).show();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_my_view;
    }
}
