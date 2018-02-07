package com.apollo.mvptest.model.http.api;

import com.apollo.mvptest.model.bean.Weather;
import com.apollo.mvptest.model.http.response.HttpResponse;

import io.reactivex.Flowable;
import retrofit2.http.GET;

/**
 * Created by lei.xiao on 2018/2/6.
 */

public interface OneApis {

    String HOST = "http://www.sojson.com/";//测试Url

    @GET("/open/api/weather/json.shtml?city=%E5%8C%97%E4%BA%AC")
    Flowable<HttpResponse<Weather>> getWeatherInfo();
}
