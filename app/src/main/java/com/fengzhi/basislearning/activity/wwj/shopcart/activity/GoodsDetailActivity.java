package com.fengzhi.basislearning.activity.wwj.shopcart.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.fengzhi.basislearning.R;
import com.fengzhi.basislearning.activity.wwj.shopcart.bean.Goods;
import com.fengzhi.basislearning.activity.wwj.shopcart.bean.ItemShopCart;
import com.fengzhi.basislearning.activity.wwj.shopcart.db.DBManager;
import com.fengzhi.basislearning.base.SlideBackBaseActivity;

import butterknife.BindView;

public class GoodsDetailActivity extends SlideBackBaseActivity {
    @BindView(R.id.title)
    TextView title;
    String path = "http://m.hichao.com/lib/interface.php?m=goodsdetail&sid=%s";
    WebView webView;
    ProgressBar progressBar;
    Goods.DataBean.ItemsBean.ComponentBean componentBean;

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        title.setText("GoodsDetailActivity");
        webView = (WebView) findViewById(R.id.webView);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                Log.e("=====", "===onProgressChanged====" + newProgress);
                progressBar.setProgress(newProgress);
                if (newProgress == 100) {
                    progressBar.setVisibility(View.GONE);
                }
            }
        });
    }

    public void lookShoppingCart(View view) {
        startActivity(new Intent(GoodsDetailActivity.this, ShoppingCartActivity.class));
    }


    public void buy(View view) {
        //立即购买
    }

    public void insertDB(View view) {
        //加入到购物车(说明：真实项目情况是post发送给网络服务器存储，模拟插入到数据库)
        ItemShopCart itemShopCart = new ItemShopCart();
        itemShopCart.setDescription(componentBean.getDescription());
        itemShopCart.setId(Long.parseLong(componentBean.getAction().getSourceId()));
        itemShopCart.setImgUrl(componentBean.getPicUrl());
        itemShopCart.setNum(1);
        itemShopCart.setPrice(componentBean.getPrice());
        DBManager.getDbManager(this).insert(itemShopCart);


    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_goods_detail;
    }
}
