package com.apollo.mvptest.home;

import com.apollo.mvptest.di.scoped.ActivityScoped;
import com.apollo.mvptest.di.scoped.FragmentScoped;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by lei.xiao on 2018/1/19.
 */
@Module
public abstract class MainModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract MainFragment mainFragment();

    @ActivityScoped
    @Binds
    abstract MainContract.Presenter mainPresenter(MainPresenter presenter);
}
