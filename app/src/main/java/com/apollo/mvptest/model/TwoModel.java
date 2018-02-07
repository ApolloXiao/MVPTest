package com.apollo.mvptest.model;

import com.apollo.mvptest.model.bean.Weather;
import com.apollo.mvptest.model.db.DBHelper;
import com.apollo.mvptest.model.http.repository.TwoRepository;
import com.apollo.mvptest.model.http.response.HttpResponse;
import com.apollo.mvptest.model.prefs.PreferencesHelper;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by lei.xiao on 2018/2/6.
 */

public class TwoModel extends BaseModel implements TwoRepository {
    private TwoRepository twoRepository;

    @Inject
    public TwoModel(DBHelper dbHelper, PreferencesHelper preferencesHelper, TwoRepository twoRepository) {
        super(dbHelper, preferencesHelper);
        this.twoRepository = twoRepository;
    }

    @Override
    public Flowable<HttpResponse<Weather>> getWeatherInfo() {
        return twoRepository.getWeatherInfo();
    }
}
