package com.fengzhi.basislearning.activity.sw.day12;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import com.fengzhi.basislearning.R;
import com.fengzhi.basislearning.base.SlideBackBaseActivity;

import butterknife.BindView;

public class NormalDialogActivity extends SlideBackBaseActivity {
    @BindView(R.id.title)
    TextView title;

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        title.setText("NormalDialogActivity");
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.normaldialog_layout;
    }

    public void onShowDialog_Click(View view) {
        // 1.创建对话框构建器
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // 设置相关属性
        builder.setTitle("对话框");
        builder.setMessage("确认删除吗?");
        builder.setIcon(R.mipmap.download);

        // 2.编写"确认"和"取消"的事件
        builder.setPositiveButton("狠心干掉", (dialog, which) -> SToast("安息吧,这不是你的错!"));

        /*
         * builder.setNegativeButton("再留一留", new
         * DialogInterface.OnClickListener() {
         *
         * @Override public void onClick(DialogInterface dialog, int which) {
         * //提示点击了"取消" -- 按钮上面的字显示的"再留一留" } });
         */
        builder.setNegativeButton("再留一留", null);

        //3.显示对话框
        //builder.show();
        builder.create().show(); //推荐

    }
}
