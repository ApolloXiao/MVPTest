package com.apollo.mvptest.di.module;

import com.apollo.mvptest.di.scoped.ActivityScoped;
import com.apollo.mvptest.home.MainActivity;
import com.apollo.mvptest.home.MainModule;
import com.apollo.mvptest.home.MainModule1;
import com.apollo.mvptest.usercenter.Main2Activity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(modules = {MainModule.class, MainModule1.class})
    abstract MainActivity mainActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract Main2Activity main2Activity();
}
