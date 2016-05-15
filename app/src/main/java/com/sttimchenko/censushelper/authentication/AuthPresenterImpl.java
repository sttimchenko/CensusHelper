package com.sttimchenko.censushelper.authentication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sttimchenko.censushelper.database.DatabaseFactory;
import com.sttimchenko.censushelper.main.MainActivity;
import com.sttimchenko.censushelper.model.LoginResponse;

import rx.functions.Action1;

public class AuthPresenterImpl implements AuthPresenter {

    private AuthModel model;
    private AuthView view;

    private AppCompatActivity activity;

    public AuthPresenterImpl(AuthModel model, AuthView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void onCreate(AppCompatActivity activity, Bundle savedInstanceState) {
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
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
    }
}
