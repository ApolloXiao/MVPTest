package com.apollo.mvptest.model.http.api;

import com.apollo.mvptest.model.bean.UserInfo;
import com.apollo.mvptest.model.http.response.HttpResponse;

import io.reactivex.Flowable;
import retrofit2.http.GET;

/**
 * Created by lei.xiao on 2018/2/6.
 */

public interface OneApis {

    String HOST = "http://www.baidu.com/";

    @GET("two/")
    Flowable<HttpResponse<UserInfo>> getUserInfo();
}
