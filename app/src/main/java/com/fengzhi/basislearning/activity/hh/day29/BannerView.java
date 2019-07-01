package com.fengzhi.basislearning.activity.hh.day29;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.fengzhi.basislearning.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现广告控件：viewpager＋radiobutton
 * 作业：写一个方法，这个方法中传入viewpager的数据源。
 * 根据数据源展示viewpager的内容，以及radiobutton的个数
 */
public class BannerView extends RelativeLayout implements ViewPager.OnPageChangeListener,
        RadioGroup.OnCheckedChangeListener {
    private ViewPager viewPager;
    private RadioGroup group;
    private List<Integer> pagerData = new ArrayList<>();

    public BannerView(Context context) {
        super(context);
        newView();
    }

    public BannerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        newView();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        //获取到指定位置上的radiogroup中的子控件对象
        RadioButton rb = (RadioButton) group.getChildAt(position);
        rb.setChecked(true);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        for (int i = 0; i < group.getChildCount(); i++) {
            RadioButton rb = (RadioButton) group.getChildAt(i);
            if (rb.isChecked()) {
                viewPager.setCurrentItem(i);
            }
        }

    }

    //添加视图界面
    private void newView() {
        viewPager = new ViewPager(getContext());
        addView(viewPager);
        viewPager.addOnPageChangeListener(this);

        group = new RadioGroup(getContext());
        group.setOnCheckedChangeListener(this);
        group.setOrientation(LinearLayout.HORIZONTAL);

        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        params.addRule(ALIGN_PARENT_BOTTOM);
        params.addRule(ALIGN_PARENT_RIGHT);
        group.setLayoutParams(params);

        for (int i = 0; i < 4; i++) {
            RadioButton rb = new RadioButton(getContext());
            group.addView(rb);

            if (i == 0) {
                rb.setChecked(true);//默认设置第一个单选控件被选中
            }
        }

        addView(group);

        //给viewpager设置数据源
        pagerData.add(R.drawable.add);
        pagerData.add(R.drawable.reduce);
        pagerData.add(R.mipmap.ic_launcher);
        pagerData.add(android.R.drawable.ic_menu_camera);

        MyAdapter adapter = new MyAdapter();
        viewPager.setAdapter(adapter);

    }

    class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return pagerData.size();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView img = new ImageView(getContext());
            img.setImageResource(pagerData.get(position));

            container.addView(img);

            return img;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            //super.destroyItem(container, position, object);
            container.removeView((ImageView) object);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }

}
