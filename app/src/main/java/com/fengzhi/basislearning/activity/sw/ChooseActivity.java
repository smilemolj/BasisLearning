package com.fengzhi.basislearning.activity.sw;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.fengzhi.basislearning.R;
import com.fengzhi.basislearning.base.SlideBackBaseActivity;

import java.util.LinkedHashSet;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

public class ChooseActivity extends SlideBackBaseActivity implements CompoundButton.OnCheckedChangeListener {

    @BindView(R.id.title)
    TextView title;

    @BindView(R.id.rdo_man)
    RadioButton rdoMan;
    @BindView(R.id.rdo_woman)
    RadioButton rdoWoman;
    @BindView(R.id.rgp_sex)
    RadioGroup rgpSex;

    @BindView(R.id.btn_choose)
    Button btnChoose;
    @BindView(R.id.tv_result)
    TextView tvResult;
    @BindView(R.id.ck_all)
    CheckBox ckAll;
    @BindView(R.id.ck_newyork)
    CheckBox ckNewyork;
    @BindView(R.id.ck_mars)
    CheckBox ckMars;
    @BindView(R.id.ck_lineuniverse)
    CheckBox ckLineuniverse;

    //定义一个存储用户所选择地点的集合
    private Set<String> places = new LinkedHashSet<>();

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        title.setText("ChooseActivity");
        //为复选框绑定选项勾选的监听器
        ckNewyork.setOnCheckedChangeListener(this);
        ckMars.setOnCheckedChangeListener(this);
        ckLineuniverse.setOnCheckedChangeListener(this);

        rgpSex.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.rdo_man:
                    tvResult.setText(rdoMan.getText() + ",宽:" + rdoMan.getLayoutParams().width);
                    //想想:为什么宽度不是80dp?
                    break;
                case R.id.rdo_woman:
                    tvResult.setText(rdoMan.getText());
                    break;
                default:
                    break;
            }
        });
        ckAll.setOnCheckedChangeListener((buttonView, isChecked) -> {
            ckNewyork.setChecked(isChecked);
            ckMars.setChecked(isChecked);
            ckLineuniverse.setChecked(isChecked);
        });
    }

    @OnClick({R.id.btn_choose})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_choose:
                if (rdoMan.isChecked()) tvResult.setText(rdoMan.getText());
                else tvResult.setText(rdoMan.getText());
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) places.add(buttonView.getText().toString());
        else places.remove(buttonView.getText().toString());
        tvResult.setText("");//清空提示信息
        //将当前选择的所有地点设置给tv_result
        for (String place : places) {
            tvResult.append(place + "\n");
        }
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main2;
    }
}
