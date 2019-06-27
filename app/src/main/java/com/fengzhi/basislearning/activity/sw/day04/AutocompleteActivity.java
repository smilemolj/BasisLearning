package com.fengzhi.basislearning.activity.sw.day04;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.fengzhi.basislearning.R;
import com.fengzhi.basislearning.base.SlideBackBaseActivity;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;

public class AutocompleteActivity extends SlideBackBaseActivity {
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.auto_tv_title)
    AutoCompleteTextView autoTvTitle;

    //准备数据源及适配器
    private List<String> data;
    private ArrayAdapter<String> adapter;

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        title.setText("AutocompleteActivity");
        autoTvTitle.setTextColor(Color.rgb(255, 255, 255));
        data = Arrays.asList("中国好声音", "中国新歌声", "中国好厨师", "中国好程序员", "美国好美食", "ROBOT");
        if (null == adapter)
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        autoTvTitle.setAdapter(adapter);
        //编写文本改变的事件
        autoTvTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.i("AutocompleteActivity", "您正在输入:" + s.toString());
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_autocomplete;
    }

}
