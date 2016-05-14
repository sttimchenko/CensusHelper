package com.sttimchenko.censushelper.authentication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.sttimchenko.censushelper.map.MapsActivity;
import com.sttimchenko.censushelper.model.LoginResponse;

import rx.functions.Action1;

public class AuthPresenterImpl implements AuthPresenter {

    private AuthModel model;
    private AuthView view;

    private Activity activity;

    public AuthPresenterImpl(AuthModel model, AuthView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void onCreate(Activity activity, Bundle savedInstanceState) {
        this.activity = activity;
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onLoginButtonClicked() {
        String username = view.getUsername();
        String password = view.getPassword();

        model.checkAuthData(username, password).subscribe(new Action1<LoginResponse>() {
            @Override
            public void call(LoginResponse loginResponse) {
                if (loginResponse.getState() == LoginResponse.ACCEPTED) accountApproved();
                else if (loginResponse.getState() == LoginResponse.WRONG_DATA) view.setUsernameAndPasswordEmptyError();
                else if (loginResponse.getState() == LoginResponse.WRONG_PASSWORD) view.setPasswordEmptyError();
                else if (loginResponse.getState() == LoginResponse.WRONG_USERNAME) view.setUsernameEmptyError();
            }
        });
    }

    private void accountApproved(){
        Intent intent = new Intent(activity, MapsActivity.class);
        activity.startActivity(intent);
    }
}
