package com.apollo.mvptest.model.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.apollo.mvptest.base.BaseApplication;

import javax.inject.Inject;

/**
 * Created by lei.xiao on 2018/2/6.
 */

public class PreferencesHelperImpl implements PreferencesHelper {
    private static final String SP_NAME = "my_sp";
    private SharedPreferences mSharedPreferences;

    @Inject
    public PreferencesHelperImpl() {
        mSharedPreferences = BaseApplication.getInstance().getSharedPreferences(SP_NAME, Context.
                MODE_PRIVATE);
    }
}
