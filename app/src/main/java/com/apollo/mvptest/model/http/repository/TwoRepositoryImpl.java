package com.apollo.mvptest.model.http.repository;

import com.apollo.mvptest.model.bean.Weather;
import com.apollo.mvptest.model.http.api.TwoApis;
import com.apollo.mvptest.model.http.response.HttpResponse;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by lei.xiao on 2018/2/6.
 */

public class TwoRepositoryImpl implements TwoRepository {
    private TwoApis twoApis;

    @Inject
    public TwoRepositoryImpl(TwoApis twoApis) {
        this.twoApis = twoApis;
    }

    @Override
    public Flowable<HttpResponse<Weather>> getWeatherInfo() {
        return twoApis.getWeatherInfo();
    }
}
