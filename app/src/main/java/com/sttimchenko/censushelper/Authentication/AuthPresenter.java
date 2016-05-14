package com.sttimchenko.censushelper.authentication;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Stanislav on 14.05.2016.
 */
public interface AuthPresenter {
    void onLoginButtonClicked();
    void onCreate(Activity activity, Bundle savedInstanceState);
    void onDestroy();
}
