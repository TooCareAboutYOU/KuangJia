package com.kuangjia.main.api;

import com.kuangjia.main.model.ErrorMessage;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit2.Call;

/**
 * Created by zhangshuai on 2016-07-08.
 */
public interface UserAPI {

    /*
    * http://120.131.13.185:8080/goldenline-portal-clt/login.html
    * */
    @GET("/login.html")
    void getInfo(Callback<ErrorMessage> callback);
    //http://120.131.13.185:8080/goldenline-portal-clt/vote.html?voteId=1

    @GET("login.html")
    Call<ErrorMessage> getInfo1();

}
