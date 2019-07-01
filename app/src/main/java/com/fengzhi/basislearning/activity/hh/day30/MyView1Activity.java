package com.fengzhi.basislearning.activity.hh.day30;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.fengzhi.basislearning.R;
import com.fengzhi.basislearning.base.BaseActivity;
import com.fengzhi.basislearning.base.SlideBackBaseActivity;

import butterknife.BindView;

public class MyView1Activity extends BaseActivity {
    @BindView(R.id.title)
    TextView title;

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        title.setText("MyView1Activity");
//        ScreenProtectView screenProtectView = new ScreenProtectView(this);
//        setContentView(screenProtectView);
//
//        screenProtectView.startRun();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_my_view1;
    }
}
