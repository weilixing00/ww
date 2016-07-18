package com.xg.insure.mvp.account.login;

/**
 * Created by server on 2016/6/21.
 * LoginAcvivity的逻辑类
 */

public class LoginPresenter implements LoginContract.ILoginPresenter {
    public LoginContract.ILoginView view;
    private final LoginModel loginModel;

    public LoginPresenter(LoginContract.ILoginView view) {
        this.view = view;
        loginModel = new LoginModel(this);
    }


    /**
     * 用户登录
     * User 用户类
     */
    public void performLogin(String username, String password) {
        loginModel.login(username, password);

    }

    @Override
    public void loginSuccess() {
        view.onLoginSuccess();
    }

    @Override
    public void loginFail() {
        view.onLoginFail();
    }

    @Override
    public void onNetError() {
        view.onNetError();
    }
}
