package com.fengzhi.basislearning.activity.sw.day04;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.fengzhi.basislearning.R;
import com.fengzhi.basislearning.base.SlideBackBaseActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SpinnerActivity extends SlideBackBaseActivity {

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.sp_stu)
    Spinner spStu;
    //获取当前下拉子项中的控件值
    @BindView(R.id.iv_currHead)
    ImageView ivCurrHead;
    @BindView(R.id.tv_currName)
    TextView tvCurrName;
    @BindView(R.id.tv_currSex)
    TextView tvCurrSex;
    @BindView(R.id.tv_currBirth)
    TextView tvCurrBirth;
    //准备SimpleAdapter使用的数据源
    private List<Map<String, Object>> data = new ArrayList<>();

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        title.setText("SpinnerActivity");
        //bindByArrayAdapter();
        bindBySimpleAdapter();
    }

    private void bindBySimpleAdapter() {
        //依次录入5位学员的数据
        Map<String, Object> s1Data = new HashMap<>();
        s1Data.put("head", R.mipmap.icon);
        s1Data.put("name", "司马长空");
        s1Data.put("sex", "男");
        s1Data.put("birth", "1996-09-03");

        Map<String, Object> s2Data = new HashMap<>();
        s2Data.put("head", R.mipmap.download);
        s2Data.put("name", "司徒无忌");
        s2Data.put("sex", "女");
        s2Data.put("birth", "1999-01-03");

        Map<String, Object> s3Data = new HashMap<>();
        s3Data.put("head", R.mipmap.icon);
        s3Data.put("name", "山本56");
        s3Data.put("sex", "男");
        s3Data.put("birth", "1939-01-03");

        Map<String, Object> s4Data = new HashMap<>();
        s4Data.put("head", R.mipmap.icon);
        s4Data.put("name", "jack");
        s4Data.put("sex", "男");
        s4Data.put("birth", "1969-11-03");

        Map<String, Object> s5Data = new HashMap<>();
        s5Data.put("head", R.mipmap.download);
        s5Data.put("name", "郭靖");
        s5Data.put("sex", "男");
        s5Data.put("birth", "2005-06-01");

        data.add(s1Data);
        data.add(s2Data);
        data.add(s3Data);
        data.add(s4Data);
        data.add(s5Data);

        //创建适配器
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, data, R.layout.spinner_item,
                new String[]{"head", "name", "sex", "birth"}, new int[]{R.id.iv_head,
                R.id.tv_name, R.id.tv_sex, R.id.tv_birth});

        //绑定适配器到Spinner
        spStu.setAdapter(simpleAdapter);

        //设定Spinner的下拉事件监听
        spStu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            /**
             * 选中某一条下拉选项
             */
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //获取当前下拉子项中的控件值
                TextView tv_name = view.findViewById(R.id.tv_name);
                TextView tv_sex = view.findViewById(R.id.tv_sex);
                TextView tv_birth = view.findViewById(R.id.tv_birth);
                ImageView iv_head = view.findViewById(R.id.iv_head);
                //将上述值赋值给主界面上响应的控件
                tvCurrName.setText(tv_name.getText());
                tvCurrSex.setText(tv_sex.getText());
                tvCurrBirth.setText(tv_birth.getText());
                BitmapDrawable currBitmap = (BitmapDrawable) iv_head.getDrawable();
                ivCurrHead.setImageBitmap(currBitmap.getBitmap());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


    }

    /**
     * 使用ArrayAdapter适配器 -- 最简单的字符串列表适配器
     */
    private void bindByArrayAdapter() {
		/*//1.取得控件
		sp_edu = (Spinner)findViewById(R.id.sp_edu);

		//2.准备数据源
		List<String> data = Arrays.asList("幼儿园","小学","中学","大学");

		//2.准备与数据源搭配的适配器 -- 这里采用ArrayAdapter
		*//**
         * 在Android API的好多方法参数类型,都需要Context -- "上下文"(作用范围)
         *//*
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);


		//3.将Adapter绑定到Spinner
		sp_edu.setAdapter(adapter);*/
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_spinner;
    }
}
