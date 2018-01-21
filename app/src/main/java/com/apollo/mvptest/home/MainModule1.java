package com.apollo.mvptest.home;

import com.apollo.mvptest.di.ActivityScoped;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lei.xiao on 2018/1/19.
 */
@Module
public abstract class MainModule1 {
    @Provides
    @ActivityScoped
    static String provideId() {
        return "123";
    }
}