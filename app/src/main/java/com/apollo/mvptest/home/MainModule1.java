package com.apollo.mvptest.home;

import com.apollo.mvptest.di.scoped.ActivityScoped;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lei.xiao on 2018/1/19.
 */
@Module
public class MainModule1 {
    @Provides
    @ActivityScoped
    String provideId() {
        return "123";
    }
}
