package com.sttimchenko.censushelper.model;

/**
 * Created by Stanislav on 14.05.2016.
 */
public class LoginResponse {
    public static final int ACCEPTED = 0;
    public static final int WRONG_USERNAME = 1;
    public static final int WRONG_PASSWORD = 2;
    public static final int WRONG_DATA = 3;

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
