package com.apollo.mvptest.model;

import com.apollo.mvptest.model.db.DBHelper;
import com.apollo.mvptest.model.prefs.PreferencesHelper;

/**
 * Created by lei.xiao on 2018/2/6.
 */

public abstract class BaseModel implements PreferencesHelper, DBHelper {
    private DBHelper mDBDbHelper;
    private PreferencesHelper mPreferencesHelper;

    public BaseModel(DBHelper dbHelper, PreferencesHelper preferencesHelper) {
        this.mDBDbHelper = dbHelper;
        this.mPreferencesHelper = preferencesHelper;
    }
}
