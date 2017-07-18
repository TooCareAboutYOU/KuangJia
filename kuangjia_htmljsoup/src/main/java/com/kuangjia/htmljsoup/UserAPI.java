package com.kuangjia.htmljsoup;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by zhangshuai on 2016-07-08.
 */
public interface UserAPI {

    @GET("/login.html")
    void getInfo(Callback<ErrorMessage> callback);
    //http://120.131.13.185:8080/goldenline-portal-clt/vote.html?voteId=1

}
