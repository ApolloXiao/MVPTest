package com.apollo.mvptest.usercenter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.apollo.mvptest.R;
import com.apollo.mvptest.base.BaseActivity;

import javax.inject.Inject;

public class Main2Activity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
}
