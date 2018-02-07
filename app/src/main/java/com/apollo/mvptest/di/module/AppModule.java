package com.apollo.mvptest.di.module;

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

import dagger.Module;
import dagger.Provides;

/**
 * Created by lei.xiao on 2018/2/6.
 */

@Module
public class AppModule {
    @Provides
    @Singleton
    OneRepository provideOneRepository(OneRepositoryImpl oneRepository) {
        return oneRepository;
    }

    @Provides
    @Singleton
    TwoRepository provideTwoRepository(TwoRepositoryImpl twoRepository) {
        return twoRepository;
    }

    @Provides
    @Singleton
    DBHelper provideDBHelper(DBHelperImpl dbHelper) {
        return dbHelper;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(PreferencesHelperImpl preferencesHelper) {
        return preferencesHelper;
    }

    @Provides
    @Singleton
    OneModel provideOneModel(DBHelperImpl dbHelper, PreferencesHelperImpl preferencesHelper, OneRepositoryImpl oneRepository) {
        return new OneModel(dbHelper, preferencesHelper, oneRepository);
    }

    @Provides
    @Singleton
    TwoModel provideTwoModel(DBHelperImpl dbHelper, PreferencesHelperImpl preferencesHelper, TwoRepositoryImpl twoRepository) {
        return new TwoModel(dbHelper, preferencesHelper, twoRepository);
    }
}
