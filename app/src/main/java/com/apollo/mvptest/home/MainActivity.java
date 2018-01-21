package com.apollo.mvptest.home;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import com.apollo.mvptest.R;
import com.apollo.mvptest.base.BaseActivity;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainFragment.OnFragmentInteractionListener{

    @Inject
    MainFragment mainFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainFragment fragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.content);
        if (fragment == null) {
            fragment = mainFragment;
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.content, fragment);
            transaction.commit();
        }

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
