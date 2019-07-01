package com.fengzhi.basislearning.activity.wwj.shopcart.db;

import android.content.Context;

import com.fengzhi.basislearning.activity.wwj.shopcart.bean.DaoMaster;
import com.fengzhi.basislearning.activity.wwj.shopcart.bean.DaoSession;
import com.fengzhi.basislearning.activity.wwj.shopcart.bean.ItemShopCart;
import com.fengzhi.basislearning.activity.wwj.shopcart.bean.ItemShopCartDao;

import java.util.List;


public class DBManager {

    ItemShopCartDao itemShopCartDao;
    private static DBManager dbManager = null;

    public static DBManager getDbManager(Context context) {
        if (dbManager == null) {
            dbManager = new DBManager(context);

        }
        return dbManager;
    }

    public DBManager(Context context) {
        DaoSession daoSession = DaoMaster.newDevSession(context, "shopCart");
        itemShopCartDao = daoSession.getItemShopCartDao();
    }

    public void insert(ItemShopCart itemShopCart) {
        itemShopCartDao.insertOrReplaceInTx(itemShopCart);
    }

    public List<ItemShopCart> queryAll() {
        return itemShopCartDao.queryBuilder().list();
    }

}
