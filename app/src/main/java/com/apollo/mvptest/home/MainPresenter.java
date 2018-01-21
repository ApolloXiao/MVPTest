package com.apollo.mvptest.home;

import android.support.annotation.Nullable;

import com.apollo.mvptest.di.ActivityScoped;

import javax.inject.Inject;

/**
 * Created by lei.xiao on 2018/1/19.
 */
@ActivityScoped
public class MainPresenter implements MainContract.Presenter {
    @Nullable
    private MainContract.View mainView;

    @Inject
    MainPresenter(){

    }

    @Override
    public void setText() {
        String text="Test";
        mainView.setText(text);
    }

    @Override
    public void attachView(MainContract.View view) {
        mainView=view;
    }

    @Override
    public void detachView() {
        mainView=null;
    }
}
