package com.apollo.mvptest.utils;

import android.content.Context;
import android.net.ConnectivityManager;

import com.apollo.mvptest.base.BaseApplication;

/**
 * Created by lei.xiao on 2018/2/6.
 */

public class Utils {

    public static boolean isNetworkConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) BaseApplication.getInstance().
                getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null;
    }
}
