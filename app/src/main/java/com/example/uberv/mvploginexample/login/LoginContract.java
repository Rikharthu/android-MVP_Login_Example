package com.example.uberv.mvploginexample.login;

public interface LoginContract {
    interface LoginPresenter {
        void validateCredentials(String username, String password);

        void onDestroy();
    }

    interface LoginView {
        void showProgress();

        void hideProgress();

        void setUsernameError();

        void setPasswordError();

        void navigateToHome();
    }

    interface LoginModel {
        interface OnLoginFinishedListener {
            void onUsernameError();

            void onPasswordError();

            void onSuccess();
        }

        void login(String username, String password, OnLoginFinishedListener listener);

    }
}
