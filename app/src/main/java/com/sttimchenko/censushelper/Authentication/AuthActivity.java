package com.sttimchenko.censushelper.authentication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.sttimchenko.censushelper.R;

public class AuthActivity extends AppCompatActivity implements AuthView, View.OnClickListener {
    private AuthPresenter presenter;
    private AuthViewHolder holder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        holder = new AuthViewHolder(
                (EditText) findViewById(R.id.et_username),
                (EditText) findViewById(R.id.et_password),
                (TextInputLayout) findViewById(R.id.til_username),
                (TextInputLayout) findViewById(R.id.til_password),
                (Button) findViewById(R.id.button)
        );

        final AuthModel model = new AuthModelImpl();

        presenter = new AuthPresenterImpl(model, this);

        presenter.onCreate(this, savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        holder.button.setOnClickListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        holder.button.setOnClickListener(null);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public void setUsernameAndPasswordEmptyError() {
        holder.tilUsername.setError(getString(R.string.error_username));
        holder.tilPassword.setError(getString(R.string.error_password));
    }

    @Override
    public void setUsernameEmptyError() {
        holder.tilPassword.setErrorEnabled(false);
        holder.tilUsername.setError(getString(R.string.error_username));
    }

    @Override
    public void setPasswordEmptyError() {
        holder.tilUsername.setErrorEnabled(false);
        holder.tilPassword.setError(getString(R.string.error_password));
    }

    @Override
    public String getUsername() {
        return holder.etUsername.getText().toString();
    }

    @Override
    public String getPassword() {
        return holder.etPassword.getText().toString();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                presenter.onLoginButtonClicked();
                break;
        }
    }
}
