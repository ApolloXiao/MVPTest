package com.apollo.mvptest.model.http;

import android.util.Log;

import com.apollo.mvptest.base.BaseView;

import io.reactivex.subscribers.ResourceSubscriber;

/**
 * Created by lei.xiao on 2018/2/6.
 */

public abstract class CommonSubscriber<T> extends ResourceSubscriber<T> {
    private static final String TAG = CommonSubscriber.class.getSimpleName();
    private BaseView mBaseView;
    private String mErrorMsg;
    private boolean mIsShowErrorState = true;

    public CommonSubscriber(BaseView mBaseView) {
        this.mBaseView = mBaseView;
    }

    public CommonSubscriber(BaseView mBaseView, String mErrorMsg) {
        this.mBaseView = mBaseView;
        this.mErrorMsg = mErrorMsg;
    }

    public CommonSubscriber(BaseView mBaseView, boolean mIsShowErrorState) {
        this.mBaseView = mBaseView;
        this.mIsShowErrorState = mIsShowErrorState;
    }

    public CommonSubscriber(BaseView mBaseView, String mErrorMsg, boolean mIsShowErrorState) {
        this.mBaseView = mBaseView;
        this.mErrorMsg = mErrorMsg;
        this.mIsShowErrorState = mIsShowErrorState;
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onError(Throwable t) {
        if (mBaseView == null) {
            return;
        }
        mBaseView.showErrorMsg(t.getMessage());
        Log.d(TAG, "onError:" + t.getMessage());
    }
}
