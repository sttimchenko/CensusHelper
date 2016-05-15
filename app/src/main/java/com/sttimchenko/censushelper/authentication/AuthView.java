package com.sttimchenko.censushelper.authentication;

/**
 * Created by Stanislav on 14.05.2016.
 */
public interface AuthView {
    void setUsernameEmptyError();
    void setPasswordEmptyError();
    void setUsernameAndPasswordEmptyError();
    String getUsername();
    String getPassword();
}
