package com.fengzhi.basislearning.activity.hh.day21;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.fengzhi.basislearning.R;
import com.fengzhi.basislearning.base.SlideBackBaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewPagerActivity extends SlideBackBaseActivity {
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        title.setText("ViewPagerActivity");
        viewPager.setAdapter(new MyAdapter());
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_view_pager;
    }

    //ViewPager的适配器
    class MyAdapter extends PagerAdapter {

        //返回viewpager所要看到的视图界面的个数
        @Override
        public int getCount() {
            return 3;
        }

        /**
         * 创建当前位置position上面的视图页面，并且要把当前创建的视图页面添加到容器对象中container
         *
         * @param container：指代当前创建的页面，要添加到的容器对象。在这里指代即将要绑定的那个viewpager对象
         * @param position：当前要创建的页面的位置信息。从0开始
         * @return 当前要看到（创建）的页面，必须返回
         */
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            //1.创建当前页面要展示的视图
            ImageView img = new ImageView(ViewPagerActivity.this);
            img.setImageResource(R.mipmap.download);
            //2.添加到容器类对象中
            container.addView(img);
            //3.返回当前视图页面
            return img;
        }

        /**
         * 移除指定位置上的视图页面
         *
         * @param container：要移除的页面所属的容器对象
         * @param position:当前要移除页面的位置信息
         * @param object：当前要移除的内容
         */
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            //这句代码，执行的任务就是抛出异常，所以必须要注释
            //super.destroyItem(container, position, object);
            //因为当时添加视图的时候就是创建的图片控件，所以这里的object其实就是imageview
            container.removeView((ImageView) object);
        }

        //判断当前看到的视图界面是否是通过instantiateItem（）返回回来的对象
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }
}
