package com.apollo.mvptest.base;

import com.apollo.mvptest.di.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

/**
 * Created by lei.xiao on 2018/1/19.
 */

public class BaseApplication extends DaggerApplication{

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }
}
