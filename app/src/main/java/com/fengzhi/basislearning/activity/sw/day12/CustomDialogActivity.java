package com.fengzhi.basislearning.activity.sw.day12;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import com.fengzhi.basislearning.R;
import com.fengzhi.basislearning.base.SlideBackBaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomDialogActivity extends SlideBackBaseActivity {
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.tv_return)
    TextView tvReturn;

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        title.setText("CustomDialogActivity");
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.custom_dialog_layout;
    }

    public void onCustomDialog_Click(View view) {
        //1.构造器
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("角色挑选");
        builder.setIcon(R.mipmap.icon);

        //2.获得对话框的自定义布局View
        final View custom_view = getLayoutInflater().inflate(R.layout.custom_view, null);

        //3.编写"确定"和"取消"
        builder.setPositiveButton("选好了", (dialog, which) -> {
            //先获取自定义布局中控件的值
            EditText et_name = custom_view.findViewById(R.id.et_name);
            RadioGroup rgp_role = custom_view.findViewById(R.id.rgp_role);

            //获取你选择的角色单选按钮的ID
            int checkedId = rgp_role.getCheckedRadioButtonId();

            RadioButton rdo_checked = (RadioButton) custom_view.findViewById(checkedId);

            //再将值设置到主界面上
            tvReturn.setText("您的昵称:" + et_name.getText().toString() + "\n角色:" + rdo_checked.getText().toString());

        });

        builder.setNegativeButton("算了", null);

        //4.绑定自定义界面View--->构建器
        builder.setView(custom_view);

        //系统对话框均是"模式"的, 但自定义对话框在某些Theme下不会自动获得焦点, 所以要手动设置为"模式对话框"
        builder.setCancelable(false);

        //5.显示
        builder.create().show();
    }
}
