package com.apollo.mvptest.di.module;

import android.app.Application;
import android.content.Context;

import com.apollo.mvptest.model.OneModel;
import com.apollo.mvptest.model.TwoModel;
import com.apollo.mvptest.model.db.DBHelper;
import com.apollo.mvptest.model.db.DBHelperImpl;
import com.apollo.mvptest.model.http.repository.OneRepository;
import com.apollo.mvptest.model.http.repository.OneRepositoryImpl;
import com.apollo.mvptest.model.http.repository.TwoRepository;
import com.apollo.mvptest.model.http.repository.TwoRepositoryImpl;
import com.apollo.mvptest.model.prefs.PreferencesHelper;
import com.apollo.mvptest.model.prefs.PreferencesHelperImpl;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * This is a Dagger module. We use this to bind our Application class as a Context in the AppComponent
 * By using Dagger Android we do not need to pass our Application instance to any module,
 * we simply need to expose our Application as Context.
 * One of the advantages of Dagger.Android is that your
 * Application & Activities are provided into your graph for you.
 * {@link
 * com.apollo.mvptest.di.component.AppComponent}.
 */
@Module
public abstract class ApplicationModule {
    //expose Application as an injectable context
    @Binds
    abstract Context bindContext(Application application);

    @Provides
    @Singleton
    static OneRepository provideOneRepository(OneRepositoryImpl oneRepository) {
        return oneRepository;
    }

    @Provides
    @Singleton
    static TwoRepository provideTwoRepository(TwoRepositoryImpl twoRepository) {
        return twoRepository;
    }

    @Provides
    @Singleton
    static DBHelper provideDBHelper(DBHelperImpl dbHelper) {
        return dbHelper;
    }

    @Provides
    @Singleton
    static PreferencesHelper providePreferencesHelper(PreferencesHelperImpl preferencesHelper) {
        return preferencesHelper;
    }

    @Provides
    @Singleton
    static OneModel provideOneModel(DBHelperImpl dbHelper, PreferencesHelperImpl preferencesHelper, OneRepositoryImpl oneRepository) {
        return new OneModel(dbHelper, preferencesHelper, oneRepository);
    }

    @Provides
    @Singleton
    static TwoModel provideTwoModel(DBHelperImpl dbHelper, PreferencesHelperImpl preferencesHelper, TwoRepositoryImpl twoRepository) {
        return new TwoModel(dbHelper, preferencesHelper, twoRepository);
    }
}

