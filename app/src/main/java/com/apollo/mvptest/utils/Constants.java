package com.apollo.mvptest.utils;

import com.apollo.mvptest.base.BaseApplication;

import java.io.File;

/**
 * Created by lei.xiao on 2018/2/6.
 */

public class Constants {
    //path
    public static final String PATH_DATA = BaseApplication.getInstance().getCacheDir().
            getAbsolutePath() + File.separator + "data";
    public static final String PATH_CACHE = PATH_DATA + "/NetCache";
    public static final long CACHE_SIZE = 50 * 1024 * 1024;
}
