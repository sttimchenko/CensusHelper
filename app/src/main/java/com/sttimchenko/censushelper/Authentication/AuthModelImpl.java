package com.sttimchenko.censushelper.authentication;

import com.sttimchenko.censushelper.Constants;
import com.sttimchenko.censushelper.model.LoginResponse;

import rx.Observable;
import rx.Subscriber;

public class AuthModelImpl implements AuthModel {
    @Override
    public Observable<LoginResponse> checkAuthData(final String username, final String password) {
        return Observable.create(new Observable.OnSubscribe<LoginResponse>() {
            @Override
            public void call(Subscriber<? super LoginResponse> subscriber) {
                LoginResponse response = new LoginResponse();

                if (Constants.USERNAME.equals(username) && Constants.PASSWORD.equals(password)){
                    response.setState(LoginResponse.ACCEPTED);
                } else if (!Constants.USERNAME.equals(username) && !Constants.PASSWORD.equals(password)){
                    response.setState(LoginResponse.WRONG_DATA);
                } else if (!Constants.USERNAME.equals(username)){
                    response.setState(LoginResponse.WRONG_USERNAME);
                } else {
                    response.setState(LoginResponse.WRONG_PASSWORD);
                }

                subscriber.onNext(response);
            }
        });
    }
}
