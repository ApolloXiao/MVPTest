package com.apollo.mvptest.home;

import com.apollo.mvptest.base.BasePresenter;
import com.apollo.mvptest.base.BaseView;

/**
 * Created by lei.xiao on 2018/1/19.
 */

public class MainContract {
    interface View extends BaseView<Presenter>{
        void setText(String text);
    }

    interface Presenter extends BasePresenter<View>{
        void setText();
    }
}
