package com.xg.insure.mvp.account.regist;

/**
 * Created by server on 2016/7/14.
 */

public interface RegistContract {
    interface IRegistPresenter {
        void onRegistSuccess();

        void onRegistFail(String error);

        void onNetError();

        void onObtainMsgCodeFail(String error);

        //获取验证码成功 参数里面返回对应的验证码
        void onObtainMsgCodeSuccess();
    }


    interface IRegistView {

        void onRegistSuccess();

        void onRegistError(String error);

        void onNetError();

        void onObtainMsgSuccess();

        void onObtainMsgError(String error);
    }
}
