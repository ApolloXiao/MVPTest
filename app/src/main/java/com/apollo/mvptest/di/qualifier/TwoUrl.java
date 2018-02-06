package com.apollo.mvptest.di.qualifier;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by lei.xiao on 2018/2/6.
 */

@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface TwoUrl {
}
