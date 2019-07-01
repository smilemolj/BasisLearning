package com.fengzhi.basislearning.activity.wwj.shopcart.apiservice;

import com.fengzhi.basislearning.activity.wwj.shopcart.bean.Goods;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface HttpApiService {


    // query=连衣裙
    // &sort=all
    // &ga=%252Fsearch%252Fskus
    // &flag=
    // &cat=
    // &asc=1
    //获取商品列表的地址
    @GET("search/skus?")
    Observable<Goods>  getGoodsList(@Query("query") String query, @Query("sort") String sort,
                                    @Query("ga") String ga, @Query("flag") String flag, @Query(
                                            "cat") String cat, @Query("asc") String asc);




}
