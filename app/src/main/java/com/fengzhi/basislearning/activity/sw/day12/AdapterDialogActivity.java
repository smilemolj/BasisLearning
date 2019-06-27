package com.fengzhi.basislearning.activity.sw.day12;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.fengzhi.basislearning.R;
import com.fengzhi.basislearning.base.SlideBackBaseActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

public class AdapterDialogActivity extends SlideBackBaseActivity {

    @BindView(R.id.title)
    TextView title;

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        title.setText("AdapterDialogActivity");
    }

    public void onAdapterDialog_Click(View view) {
        //1.构建器
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("适配器对话框");

        //2.数据源
        int[] imgs = {R.mipmap.icon,
                R.mipmap.download,
                R.mipmap.ic_launcher,
                R.mipmap.icon,
                R.mipmap.download};

        String[] names = {"加密", "安全", "设置", "网络", "俺的文档"};

        List<Map<String, Object>> data = new ArrayList<>();
        for (int i = 0; i < imgs.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("logo", imgs[i]);
            map.put("name", names[i]);

            data.add(map);
        }

        //3.适配器
        SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.list_item,
                new String[]{"logo", "name"}, new int[]{R.id.iv_logo, R.id.tv_name});

        //4.绑定适配器给对话框(构建器)
        builder.setAdapter(adapter, (dialog, which) -> Toast.makeText(AdapterDialogActivity.this, "你点击的是第" + which + "条!", Toast.LENGTH_SHORT).show());

        //5.显示对话框
        builder.create().show();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.adapter_dialog_layout;
    }
}
