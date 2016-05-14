package com.sttimchenko.censushelper.authentication;

import android.support.design.widget.TextInputLayout;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Stanislav on 14.05.2016.
 */
public class AuthViewHolder {
    protected EditText etUsername;
    protected EditText etPassword;
    protected TextInputLayout tilUsername;
    protected TextInputLayout tilPassword;
    protected Button button;

    public AuthViewHolder(EditText etUsername, EditText etPassword, TextInputLayout tilUsername
            , TextInputLayout tilPassword, Button button) {
        this.etUsername = etUsername;
        this.etPassword = etPassword;
        this.tilUsername = tilUsername;
        this.tilPassword = tilPassword;
        this.button = button;
    }
}
