package com.example.uberv.mvploginexample.login;

public class LoginPresenterImpl implements LoginContract.LoginPresenter, LoginContract.LoginModel.OnLoginFinishedListener {

    private LoginContract.LoginView mLoginView;
    private LoginContract.LoginModel mLoginModel;

    public LoginPresenterImpl(LoginContract.LoginView loginView) {
        mLoginView = loginView;
        mLoginModel = new LoginModelImpl();
    }

    /**
     * The only interraction between the View (LoginActivity) and the Model (LoginModelImpl) is
     * the web call to authenticate the user with given credentials (mock)
     */
    @Override
    public void validateCredentials(String username, String password) {
        if (mLoginView != null) {
            mLoginView.showProgress();
        }

        mLoginModel.login(username, password, this);
    }

    @Override
    public void onDestroy() {
        mLoginView = null;
    }

    // *** OnLoginFinished ***
    @Override
    public void onUsernameError() {
        if(mLoginView!=null){
            mLoginView.setUsernameError();
            mLoginView.hideProgress();
        }
    }

    @Override
    public void onPasswordError() {
        if(mLoginView!=null){
            mLoginView.setPasswordError();
            mLoginView.hideProgress();
        }
    }

    @Override
    public void onSuccess() {
        if(mLoginView!=null){
            mLoginView.hideProgress();
            mLoginView.navigateToHome();
        }
    }
}
