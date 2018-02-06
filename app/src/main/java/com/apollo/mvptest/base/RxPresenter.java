package com.apollo.mvptest.base;


import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by lei.xiao on 2018/1/19.
 */

public class RxPresenter<T extends BaseView> implements BasePresenter<T> {

    public T view;
    private CompositeDisposable mCompositeDisposable;

    private void unSubscribe() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.clear();
        }
    }

    protected void addSubscribe(Disposable subscription) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(subscription);
    }

    @Override
    public void attachView(T view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
        unSubscribe();
    }
}
