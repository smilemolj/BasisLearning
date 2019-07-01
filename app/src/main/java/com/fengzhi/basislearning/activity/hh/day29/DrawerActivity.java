package com.fengzhi.basislearning.activity.hh.day29;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.fengzhi.basislearning.R;
import com.fengzhi.basislearning.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class DrawerActivity extends BaseActivity {
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.btnMain)
    Button btnMain;
    @BindView(R.id.drawerlayout)
    DrawerLayout drawerLayout;

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        title.setText("DrawerActivity");
//        button.setClickable(false);//设置按钮不可点击

        //打开左边的抽屉
//        drawerLayout.openDrawer(GravityCompat.START);

        //获取到左边的抽屉布局是否打开
        boolean isOpen = drawerLayout.isDrawerOpen(GravityCompat.START);

        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
                //0.0 ~ 1.0
                Log.i("info", "=====onDrawerSlide=======" + slideOffset);
            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {
                btnMain.setClickable(false);
            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {
                btnMain.setClickable(true);

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }

    public void btnOnclick(View view) {
        Toast.makeText(this, "点击了按钮", Toast.LENGTH_LONG).show();
    }

    public void btnLeft(View view) {
        Toast.makeText(this, "点击了按钮3", Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.home_more)
    public void onViewClicked() {
        drawerLayout.openDrawer(GravityCompat.START);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_drawer;
    }

}
