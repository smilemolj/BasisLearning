package com.fengzhi.basislearning.activity.wwj.shopcart.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fengzhi.basislearning.R;
import com.fengzhi.basislearning.activity.wwj.shopcart.bean.ItemShopCart;
import com.fengzhi.basislearning.activity.wwj.shopcart.callback.OnItemCheckedListener;
import com.fengzhi.basislearning.activity.wwj.shopcart.callback.OnNumAscListener;
import com.fengzhi.basislearning.activity.wwj.shopcart.callback.OnNumDescListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MyAdapter extends BaseAdapter {
    List<ItemShopCart> shopCartList = new ArrayList<>();
    Context context;
    CheckBox cb_all;
    Map<Integer,Boolean> map ;

    OnItemCheckedListener onItemCheckedListener;
    OnNumAscListener onNumAscListener;
    OnNumDescListener onNumDescListener;

    public MyAdapter(Context context, CheckBox cb_all) {
        this.context = context;
        this.cb_all = cb_all;
    }

    public void setOnNumDescListener(OnNumDescListener onNumDescListener) {
        this.onNumDescListener = onNumDescListener;
    }

    public void setOnItemCheckedListener(OnItemCheckedListener onItemCheckedListener) {
        this.onItemCheckedListener = onItemCheckedListener;
    }

    public void setOnNumAscListener(OnNumAscListener onNumAscListener) {
        this.onNumAscListener = onNumAscListener;
    }

    public void setShopCartList(List<ItemShopCart> shopCartList) {
        this.shopCartList = shopCartList;
        notifyDataSetChanged();
    }

    public void setMap(Map<Integer, Boolean> map) {
        this.map = map;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return shopCartList.size();
    }

    @Override
    public Object getItem(int position) {
        return shopCartList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ShopViewHolder shopViewHolder;

        //复用
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_shopcart, parent, false);
            shopViewHolder = new ShopViewHolder(convertView);
            convertView.setTag(shopViewHolder);
        } else {
            shopViewHolder = (ShopViewHolder) convertView.getTag();
        }
        shopViewHolder.checkBox.setTag(position);
        shopViewHolder.checkBox.setChecked(map.get(position));
        shopViewHolder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (onItemCheckedListener!=null){
                   onItemCheckedListener.onItemCheckedListener(shopViewHolder.checkBox,position);
               }
            }
        });

        Glide.with(context).load(shopCartList.get(position).getImgUrl()).into(shopViewHolder.imageView);
        shopViewHolder.tv_asc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onNumAscListener!=null)
                {
                    onNumAscListener.onNumAscListener();
                }
            }
        });
        shopViewHolder.tv_desc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onNumDescListener!=null)
                {
                    onNumDescListener.onNumDescListener();
                }
            }
        });
        shopViewHolder.tv_description.setText(shopCartList.get(position).getDescription());
        shopViewHolder.tv_price.setText(shopCartList.get(position).getPrice()+"元");
        shopViewHolder.tv_num.setText(String.valueOf(shopCartList.get(position).getNum()));
        return convertView;
    }

    //查找控件减少findVIewBYId的次数
    static class ShopViewHolder {
        CheckBox checkBox;
        ImageView imageView;
        TextView tv_description;
        TextView tv_price;
        TextView tv_num;
        TextView tv_desc;
        TextView tv_asc;
        View itemView;

        public ShopViewHolder(View itemView) {
            this.itemView = itemView;
            checkBox = (CheckBox) itemView.findViewById(R.id.checkBox);
            imageView = (ImageView) itemView.findViewById(R.id.imageView2);
            tv_description = (TextView) itemView.findViewById(R.id.tv_description);
            tv_price = (TextView) itemView.findViewById(R.id.tv_price);
            tv_num = (TextView) itemView.findViewById(R.id.textView5);
            tv_desc = (TextView) itemView.findViewById(R.id.tv_desc);
            tv_asc = (TextView) itemView.findViewById(R.id.tv_asc);

        }
    }
}
