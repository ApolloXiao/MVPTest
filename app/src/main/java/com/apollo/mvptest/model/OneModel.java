package com.apollo.mvptest.model;

import com.apollo.mvptest.model.bean.Weather;
import com.apollo.mvptest.model.db.DBHelper;
import com.apollo.mvptest.model.http.repository.OneRepository;
import com.apollo.mvptest.model.http.response.HttpResponse;
import com.apollo.mvptest.model.prefs.PreferencesHelper;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by lei.xiao on 2018/2/6.
 */

public class OneModel extends BaseModel implements OneRepository {
    private OneRepository oneRepository;

    @Inject
    public OneModel(DBHelper dbHelper, PreferencesHelper preferencesHelper, OneRepository oneRepository) {
        super(dbHelper, preferencesHelper);
        this.oneRepository = oneRepository;
    }

    @Override
    public Flowable<HttpResponse<Weather>> getWeatherInfo() {
        return oneRepository.getWeatherInfo();
    }
}
