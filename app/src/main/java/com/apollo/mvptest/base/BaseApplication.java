package com.apollo.mvptest.base;

import com.apollo.mvptest.di.component.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

/**
 * Created by lei.xiao on 2018/1/19.
 */

public class BaseApplication extends DaggerApplication {
    private static BaseApplication baseApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        if (baseApplication == null) {
            baseApplication = this;
        }
    }

    public static BaseApplication getInstance() {
        if (baseApplication == null) {
            return new BaseApplication();
        } else {
            return baseApplication;
        }
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }
}
