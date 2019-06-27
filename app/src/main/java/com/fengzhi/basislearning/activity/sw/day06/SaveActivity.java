package com.fengzhi.basislearning.activity.sw.day06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.fengzhi.basislearning.R;

import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

public class SaveActivity extends SwipeBackActivity {

    private EditText et_MainActivity;
    private TextView tv_MainActivity;
    private Bundle savedBundle;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("et_MainActivity", et_MainActivity.getText().toString());
        savedBundle = outState;
    }

    /**
     * 在常用的app周期变化中都不会运行,所以我们的现场恢复其实应该考虑Activity的生命周期来恢复!!比如onCreate, 或onStart, onResume
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    /**
     * 点击按钮,跳转到OtherActivity
     */
    public void onToOther_Click(View view) {
        startActivity(new Intent(this, OtherActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //必须保留 -- 加载app的系统设置
        setContentView(R.layout.activity_save);
        et_MainActivity = (EditText) findViewById(R.id.et_MainActivity);
        tv_MainActivity = (TextView) findViewById(R.id.tv_MainActivity);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (null != savedBundle) {
            String savedData = savedBundle.getString("et_MainActivity");
            tv_MainActivity.setText(null != savedData ? savedData : "无数据还原");
        }
    }
}
