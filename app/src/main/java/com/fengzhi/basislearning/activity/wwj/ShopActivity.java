package com.fengzhi.basislearning.activity.wwj;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fengzhi.basislearning.R;
import com.fengzhi.basislearning.activity.wwj.shopcart.activity.GoodsDetailActivity;
import com.fengzhi.basislearning.activity.wwj.shopcart.adapter.GoodsAdapter;
import com.fengzhi.basislearning.activity.wwj.shopcart.apiservice.HttpApiService;
import com.fengzhi.basislearning.activity.wwj.shopcart.bean.Goods;
import com.fengzhi.basislearning.base.SlideBackBaseActivity;

import butterknife.BindView;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ShopActivity extends SlideBackBaseActivity {
    @BindView(R.id.title)
    TextView title;
    //RecyclerView负责布局复用,不负责布局，布局由布局管理器
    //用有限的窗口加载大量数据集合
    RecyclerView recyclerView;

    GoodsAdapter adapter;
    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        title.setText("ShopActivity");
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        //网格布局
        GridLayoutManager gridLayoutManager = new GridLayoutManager(
                this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);


        //一进入程序加载空数据
        adapter = new GoodsAdapter(this);
        recyclerView.setAdapter(adapter);

        //点击事件
        adapter.setOnItemClicklistener((componentBean, pos) -> {
            Log.e("======", "+=======" + componentBean.getDescription());
            String sourceId = componentBean.getAction().getSourceId();
            Intent intent = new Intent(ShopActivity.this, GoodsDetailActivity.class);
            intent.putExtra("sourceId", sourceId);
            intent.putExtra("bean",componentBean);
            startActivity(intent);
        });

        //填充数据
        getGoodsData("连衣裙");
    }
    //http://api-v2.mall.hichao.com/search/skus?query=连衣裙&sort=all&ga=%252Fsearch%252Fskus&flag=&cat=&asc=1
    public void getGoodsData(String key) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api-v2.mall.hichao.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        HttpApiService httpApiService = retrofit.create(HttpApiService.class);
        Observable<Goods> observable = httpApiService.getGoodsList(
                key, "all", "%252Fsearch%252Fskus", "", "", "1"
        );
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Goods>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                    @Override
                    public void onNext(Goods goods) {
                        // Log.e("=====","===onNext===="+goods.getData().getItems().size());
                        adapter.setItemsBeanList(goods.getData().getItems());
                    }
                });


    }
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_shop;
    }
}
