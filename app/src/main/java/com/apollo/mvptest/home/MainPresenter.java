package com.apollo.mvptest.home;

import android.util.Log;

import com.apollo.mvptest.base.RxPresenter;
import com.apollo.mvptest.di.scoped.ActivityScoped;
import com.apollo.mvptest.model.OneModel;
import com.apollo.mvptest.model.bean.UserInfo;
import com.apollo.mvptest.model.http.CommonSubscriber;
import com.apollo.mvptest.model.http.response.HttpResponse;
import com.apollo.mvptest.utils.RxUtil;

import org.reactivestreams.Publisher;

import java.util.concurrent.TimeUnit;

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
        String text="Test";
        view.setText(text);
    }

    private void getUserInfo(){
        addSubscribe(oneModel.getUserInfo()
                .compose(RxUtil.<HttpResponse<UserInfo>>rxSchedulerHelper())
                .flatMap(new Function<HttpResponse<UserInfo>, Publisher<UserInfo>>() {
                    @Override
                    public Publisher<UserInfo> apply(HttpResponse<UserInfo> userInfoHttpResponse) throws Exception {
                        return Flowable.just(userInfoHttpResponse.getData());
                    }
                })
                .subscribeWith(new CommonSubscriber<UserInfo>(view){

                    @Override
                    public void onNext(UserInfo userInfo) {

                    }
                }));
    }

}
