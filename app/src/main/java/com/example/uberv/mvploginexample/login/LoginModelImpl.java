package com.example.uberv.mvploginexample.login;

import android.os.Handler;
import android.text.TextUtils;

public class LoginModelImpl implements LoginContract.LoginModel {

    public static final long MOCK_RESPONSE_DELAY = 2000;

    @Override
    public void login(final String username, final String password, final OnLoginFinishedListener listener) {
        // Mock login
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean isError = false;
                if (TextUtils.isEmpty(username)) {
                    isError=true;
                    listener.onUsernameError();
                }
                if (TextUtils.isEmpty(password)) {
                    isError=true;
                    listener.onPasswordError();
                }

                if(!isError){
                    listener.onSuccess();
                }
            }
        }, MOCK_RESPONSE_DELAY);
    }
}
