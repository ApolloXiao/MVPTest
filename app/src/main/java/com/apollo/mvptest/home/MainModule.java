package com.apollo.mvptest.home;

import com.apollo.mvptest.di.scoped.ActivityScoped;
import com.apollo.mvptest.di.scoped.FragmentScoped;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
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

    @Provides
    @ActivityScoped
    @Named("mainActivityID")
    static String provideMainActivityId(MainActivity activity){
        return activity.getID();
    }

    @Provides
    @ActivityScoped
    @Named("mainPresenterID")
    static String provideMainPresenter( MainPresenter presenter){
        return presenter.getID();
    }
}
