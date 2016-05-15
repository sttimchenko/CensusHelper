package com.sttimchenko.censushelper.authentication;

import com.sttimchenko.censushelper.model.LoginResponse;

import rx.Observable;

/**
 * Created by Stanislav on 14.05.2016.
 */
public interface AuthModel {
    Observable<LoginResponse> checkAuthData(String username, String password);
}
