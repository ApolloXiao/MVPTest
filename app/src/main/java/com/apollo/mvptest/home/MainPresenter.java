package com.apollo.mvptest.home;

import com.apollo.mvptest.base.RxPresenter;
import com.apollo.mvptest.di.scoped.ActivityScoped;
import com.apollo.mvptest.model.OneModel;
import com.apollo.mvptest.model.bean.Weather;
import com.apollo.mvptest.model.http.CommonSubscriber;
import com.apollo.mvptest.model.http.response.HttpResponse;
import com.apollo.mvptest.utils.RxUtil;

import org.reactivestreams.Publisher;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;

/**
 * Created by lei.xiao on 2018/1/19.
 */
@ActivityScoped
public class MainPresenter extends RxPresenter<MainContract.View> implements MainContract.Presenter{

    private OneModel oneModel;


    @Inject
    MainPresenter(OneModel oneModel){
        this.oneModel=oneModel;
    }

    @Override
    public void setText() {
        getWeatherInfo();
    }

    private void getWeatherInfo(){
        addSubscribe(oneModel.getWeatherInfo()
                .compose(RxUtil.<HttpResponse<Weather>>rxSchedulerHelper())
                .flatMap(new Function<HttpResponse<Weather>, Publisher<Weather>>() {
                    @Override
                    public Publisher<Weather> apply(HttpResponse<Weather> userInfoHttpResponse) throws Exception {
                        return Flowable.just(userInfoHttpResponse.getData());
                    }
                })
                .subscribeWith(new CommonSubscriber<Weather>(view){

                    @Override
                    public void onNext(Weather weather) {
                        view.setText(weather.getQuality());
                    }
                }));
    }

    public String getID(){
        return "MainPresenterID";
    }

}
