package com.fengzhi.basislearning.activity.hh.day23;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import com.fengzhi.basislearning.R;
import com.fengzhi.basislearning.base.SlideBackBaseActivity;

import butterknife.BindView;

public class DetailActivity extends SlideBackBaseActivity {
    @BindView(R.id.title)
    TextView title;
    private NotificationManager manager;

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        title.setText("DetailActivity");
        manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        //取消已经看过的通知(这个通知的id为1)
        manager.cancel(1);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_detail;
    }
}
