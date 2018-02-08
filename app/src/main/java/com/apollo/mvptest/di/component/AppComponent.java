package com.apollo.mvptest.di.component;

import android.app.Application;

import com.apollo.mvptest.base.BaseApplication;
import com.apollo.mvptest.di.module.ActivityBindingModule;
import com.apollo.mvptest.di.module.ApplicationModule;
import com.apollo.mvptest.di.module.HttpModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {HttpModule.class,
        ApplicationModule.class,
        ActivityBindingModule.class,
        AndroidSupportInjectionModule.class})
public interface AppComponent extends AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();
    }
}
