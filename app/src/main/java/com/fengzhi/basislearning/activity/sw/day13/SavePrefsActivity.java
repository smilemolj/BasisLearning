package com.fengzhi.basislearning.activity.sw.day13;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.fengzhi.basislearning.R;
import com.fengzhi.basislearning.base.SlideBackBaseActivity;

import butterknife.BindView;

public class SavePrefsActivity extends SlideBackBaseActivity {

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_intro)
    EditText etIntro;
    private SharedPreferences prefs;

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        title.setText("SavePrefsActivity");

        //1.以MODE_PRIVATE模式(仅被当前app访问的SharedPreference键值对)
        prefs = getSharedPreferences("myConfig", MODE_PRIVATE);

        String name = prefs.getString("name", null);
        String intro = prefs.getString("intro", null);

        if (null != name && null != intro) {
            Toast.makeText(this, "正在读取保存的数据!", Toast.LENGTH_LONG).show();
            etName.setText(name);
            etIntro.setText(intro);
        }
    }

    public void onSavePrefs_Click(View view) {
        //2.创建编辑器Editor
        SharedPreferences.Editor editor = prefs.edit();

        //3.保存键值对
        editor.putString("name", etName.getText().toString());
        editor.putString("intro", etIntro.getText().toString());

        //4.提交存盘
        editor.commit();
        Toast.makeText(this, "保存数据成功!", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.save_prefs_layout;
    }
}
