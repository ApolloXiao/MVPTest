package com.apollo.mvptest.model.http.repository;

import com.apollo.mvptest.model.bean.UserInfo;
import com.apollo.mvptest.model.http.response.HttpResponse;

import io.reactivex.Flowable;

/**
 * Created by lei.xiao on 2018/2/6.
 */

public interface TwoRepository {

    Flowable<HttpResponse<UserInfo>> getUserInfo();
}
