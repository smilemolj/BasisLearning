package com.fengzhi.basislearning.activity.wwj.shopcart.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ListView;

import com.fengzhi.basislearning.R;
import com.fengzhi.basislearning.activity.wwj.shopcart.adapter.MyAdapter;
import com.fengzhi.basislearning.activity.wwj.shopcart.bean.ItemShopCart;
import com.fengzhi.basislearning.activity.wwj.shopcart.callback.OnItemCheckedListener;
import com.fengzhi.basislearning.activity.wwj.shopcart.callback.OnNumAscListener;
import com.fengzhi.basislearning.activity.wwj.shopcart.callback.OnNumDescListener;
import com.fengzhi.basislearning.activity.wwj.shopcart.db.DBManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCartActivity extends AppCompatActivity {
    ListView listView;

    MyAdapter myAdapter;
    CheckBox cb_all;

    Map<Integer, Boolean> map;
    List<ItemShopCart> shopCartList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        initData();
        setListener();
        //监听的是状态发生的变化setOnCheckedChangeListener
    }
    public void initData() {
        listView = (ListView) findViewById(R.id.listview);
        cb_all = (CheckBox) findViewById(R.id.cb_all);
        //先加载空列表
        myAdapter = new MyAdapter(this, cb_all);
        listView.setAdapter(myAdapter);

        //getSupportActionBar().setTitle("购物车");
        //真实情况，调用服务器接口地址查询购物车列表，列表展示(模拟数据库查询列表展示)
        shopCartList = DBManager.getDbManager(this).queryAll();
        myAdapter.setShopCartList(shopCartList);


        map = new HashMap<>();
        for (int i = 0; i < shopCartList.size(); i++) {
            map.put(i, false);
        }
        //初始默认值设置
        myAdapter.setMap(map);
    }

    public void setListener() {

        myAdapter.setOnItemCheckedListener(new OnItemCheckedListener() {
            @Override
            public void onItemCheckedListener(CheckBox checkBox, int pos) {
                ItemChecked(checkBox, pos);
            }
        });
        myAdapter.setOnNumAscListener(new OnNumAscListener() {
            @Override
            public void onNumAscListener() {
                //更新数据库中的num数量刷新，

            }
        });

        myAdapter.setOnNumDescListener(new OnNumDescListener() {
            @Override
            public void onNumDescListener() {

            }
        });

        cb_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < shopCartList.size(); i++) {
                    map.put(i, cb_all.isChecked());
                }
                //设置点击发生变化刷新
                myAdapter.setMap(map);

            }
        });

    }

    public void ItemChecked(CheckBox cb, int pos) {
        int trueCount = 0;
        if (cb.isChecked()) {

            //选中，
            if (cb.getTag() != null
                    && cb.getTag().equals(pos)) {
                map.put(pos, true);
            }


            //统计true的个数
            for (int i = 0; i < map.size(); i++) {
                boolean flag = map.get(i);
                if (flag == true) {
                    trueCount++;
                }
            }
            if (trueCount == myAdapter.getCount()) {
                //表示全选按钮要选中
                cb_all.setChecked(true);
            }

        } else {
            //不选中，
            if (cb.getTag() != null
                    && cb.getTag().equals(pos)) {
                map.put(pos, false);
            }

            //表示全选按钮要取消
            cb_all.setChecked(false);
        }
    }
}
