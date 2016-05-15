package com.sttimchenko.censushelper.authentication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Stanislav on 14.05.2016.
 */
public interface AuthPresenter {
    void onLoginButtonClicked();
    void onCreate(AppCompatActivity activity, Bundle savedInstanceState);
    void onDestroy();
}
