package com.xg.insure.mvp.account.login;

/**
 * Created by server on 2016/7/14.
 */

public interface LoginContract {
    interface ILoginView {
        void onLoginSuccess();

        void onLoginFail();

        void onNetError();
    }

    interface ILoginPresenter {
        void performLogin(String username,String password);

        void loginSuccess();

        void loginFail();

        void onNetError();
    }
}
