package com.fengzhi.basislearning.activity.wwj.shopcart.callback;

import com.fengzhi.basislearning.activity.wwj.shopcart.bean.Goods;

public interface OnItemClicklistener {

    void onItemClickListener(Goods.DataBean.ItemsBean.ComponentBean componentBean, int pos);

}
