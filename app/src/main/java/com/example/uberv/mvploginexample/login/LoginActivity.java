package com.example.uberv.mvploginexample.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.uberv.mvploginexample.R;
import com.example.uberv.mvploginexample.main.MainActivity;

public class LoginActivity extends AppCompatActivity
        implements LoginContract.LoginView, View.OnClickListener {

    private EditText mLoginEt;
    private EditText mPasswordEt;
    private Button mLoginBtn;
    private ProgressBar mProgressBar;

    private LoginContract.LoginPresenter mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mLoginEt = (EditText) findViewById(R.id.username);
        mPasswordEt = (EditText) findViewById(R.id.password);
        mProgressBar = (ProgressBar) findViewById(R.id.progress);
        mLoginBtn = (Button) findViewById(R.id.login_btn);
        mLoginBtn.setOnClickListener(this);

        mPresenter = new LoginPresenterImpl(this);
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        String username = mLoginEt.getText().toString();
        String password = mPasswordEt.getText().toString();
        mPresenter.validateCredentials(username, password);
    }

    // *** LoginView ***
    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void setUsernameError() {
        mLoginEt.setError("Username cannot be empty");
    }

    @Override
    public void setPasswordError() {
        mPasswordEt.setError("Password cannot be empty");
    }

    @Override
    public void navigateToHome() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
