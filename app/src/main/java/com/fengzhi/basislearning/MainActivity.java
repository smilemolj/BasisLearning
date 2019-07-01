package com.fengzhi.basislearning;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationManagerCompat;

import com.fengzhi.basislearning.activity.hh.day17.HandlerActivity;
import com.fengzhi.basislearning.activity.hh.day21.ViewPagerActivity;
import com.fengzhi.basislearning.activity.hh.day23.BroNotifaActivity;
import com.fengzhi.basislearning.activity.hh.day26.BaiduMapActivity;
import com.fengzhi.basislearning.activity.hh.day26.BaiduMapActivity1;
import com.fengzhi.basislearning.activity.hh.day28.MyViewActivity;
import com.fengzhi.basislearning.activity.hh.day29.DrawerActivity;
import com.fengzhi.basislearning.activity.hh.day30.MyView1Activity;
import com.fengzhi.basislearning.activity.sw.day04.AutocompleteActivity;
import com.fengzhi.basislearning.activity.sw.day04.ChooseActivity;
import com.fengzhi.basislearning.activity.sw.day04.SpinnerActivity;
import com.fengzhi.basislearning.activity.sw.day06.SaveActivity;
import com.fengzhi.basislearning.activity.sw.day12.DialogActivity;
import com.fengzhi.basislearning.activity.sw.day13.SavePrefsActivity;
import com.fengzhi.basislearning.activity.wwj.ShopActivity;
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
import com.fengzhi.basislearning.utils.DialogUtil;
import com.fengzhi.basislearning.utils.IntentUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.title)
    TextView title;
    private long lastClickTime;
    private boolean areNotificationsEnabled = true;

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        title.setText("Android基础学习");
        checkNotification();
    }

    @OnClick({R.id.button, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6,
            R.id.button7, R.id.button8, R.id.button9, R.id.button10, R.id.button11, R.id.button12
            , R.id.button13, R.id.button14, R.id.button15, R.id.button16, R.id.button17,
            R.id.button18, R.id.button19, R.id.button20, R.id.button21, R.id.button22,
            R.id.button23, R.id.button24, R.id.button25})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //<editor-fold desc="点击1">
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
            case R.id.button16:
                startActivity(new Intent(this, SavePrefsActivity.class));
                break;
            case R.id.button17:
                startActivity(new Intent(this, HandlerActivity.class));
                break;
            case R.id.button18:
                startActivity(new Intent(this, ViewPagerActivity.class));
                break;
            //</editor-fold>
            case R.id.button19:
                startActivity(new Intent(this, BroNotifaActivity.class));
                break;
            case R.id.button20:
                startActivity(new Intent(this, BaiduMapActivity.class));
                break;
            case R.id.button21:
                startActivity(new Intent(this, BaiduMapActivity1.class));
                break;
            case R.id.button22:
                startActivity(new Intent(this, MyViewActivity.class));
                break;
            case R.id.button23:
                startActivity(new Intent(this, DrawerActivity.class));
                break;
            case R.id.button24:
                startActivity(new Intent(this, MyView1Activity.class));
                break;
            case R.id.button25:
                startActivity(new Intent(this, ShopActivity.class));
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

    private void checkNotification() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            NotificationManagerCompat notificationManagerCompat =
                    NotificationManagerCompat.from(mContext);
            areNotificationsEnabled = notificationManagerCompat.areNotificationsEnabled();
        }
        if (!areNotificationsEnabled) {
            DialogUtil.getInstance().showDialog(mContext, "应用未打开通知，请允许", () -> {
//                    点击确定后跳转到app信息页面，用于设置权限
                Intent intent = IntentUtil.getAppInfoIntent("com.fengzhi.basislearning");
                startActivity(intent);
            });
        }
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }
}
