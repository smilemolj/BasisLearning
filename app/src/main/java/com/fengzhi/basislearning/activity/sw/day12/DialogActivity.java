package com.fengzhi.basislearning.activity.sw.day12;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.fengzhi.basislearning.R;
import com.fengzhi.basislearning.base.SlideBackBaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DialogActivity extends SlideBackBaseActivity {
    @BindView(R.id.title)
    TextView title;

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        title.setText("Dialog");
    }

    @OnClick({R.id.button1, R.id.button2, R.id.button3, R.id.button4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button1:
                startActivity(AdapterDialogActivity.class,null,false);
                break;
            case R.id.button2:
                startActivity(CustomDialogActivity.class,null,false);
                break;
            case R.id.button3:
                break;
            case R.id.button4:
                break;
        }
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_dialog;
    }
}
