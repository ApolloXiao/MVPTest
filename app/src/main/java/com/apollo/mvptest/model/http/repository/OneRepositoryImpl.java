package com.apollo.mvptest.model.http.repository;

import com.apollo.mvptest.model.bean.UserInfo;
import com.apollo.mvptest.model.http.api.OneApis;
import com.apollo.mvptest.model.http.response.HttpResponse;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by lei.xiao on 2018/2/6.
 */

public class OneRepositoryImpl implements OneRepository {
    private OneApis oneApis;

    @Inject
    public OneRepositoryImpl(OneApis oneApis) {
        this.oneApis = oneApis;
    }

    @Override
    public Flowable<HttpResponse<UserInfo>> getUserInfo() {
        return oneApis.getUserInfo();
    }
}
