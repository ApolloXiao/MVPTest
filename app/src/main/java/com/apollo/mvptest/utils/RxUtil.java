package com.apollo.mvptest.utils;

import com.apollo.mvptest.model.http.exception.ApiException;
import com.apollo.mvptest.model.http.response.HttpResponse;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lei.xiao on 2018/2/6.
 */
public class RxUtil {
    /**
     * 统一线程处理
     *
     * @param <T>
     * @return
     */
    public static <T> FlowableTransformer<T, T> rxSchedulerHelper() {    //compose简化线程
        return new FlowableTransformer<T, T>() {
            @Override
            public Flowable<T> apply(Flowable<T> observable) {
                return observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    /**
     * 统一返回结果处理
     *
     * @param <T>
     * @return
     */
    public static <T> FlowableTransformer<HttpResponse<T>, T> handleResult() {   //compose判断结果
        return new FlowableTransformer<HttpResponse<T>, T>() {
            @Override
            public Flowable<T> apply(Flowable<HttpResponse<T>> httpResponseFlowable) {
                return httpResponseFlowable.flatMap(new Function<HttpResponse<T>, Flowable<T>>() {
                    @Override
                    public Flowable<T> apply(HttpResponse<T> tMyHttpResponse) {
                        if (tMyHttpResponse.getCode() == 200) {
                            return createData(tMyHttpResponse.getData());
                        } else {
                            return Flowable.error(new ApiException("服务器返回error"));
                        }
                    }
                });
            }
        };
    }

    /**
     * 生成Flowable
     *
     * @param <T>
     * @return
     */
    public static <T> Flowable<T> createData(final T t) {
        return Flowable.create(new FlowableOnSubscribe<T>() {
            @Override
            public void subscribe(FlowableEmitter<T> emitter) throws Exception {
                try {
                    emitter.onNext(t);
                    emitter.onComplete();
                } catch (Exception e) {
                    emitter.onError(e);
                }
            }
        }, BackpressureStrategy.BUFFER);
    }
}
