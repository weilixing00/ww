package com.xg.insure.mvp.account.resetpsw;

/**
 * Created by server on 2016/7/15.
 * 重置密码的协议层
 */

public interface ResetPswContract {
    interface IResetPswPresenter{

        void performResetPsw(String phoneNum,String msgCode,String newPsw);

        void obtainMsgCode(String phoneNum);

        void onObtainMsgCodeSuccess();

        void onObtainMsgCodeFail();

        void onNetError();

        void resetSuccess();

        void resetFail();

    }
    interface IResetPswView{
        void onObtainMsgCodeSuccess();

        void onObtainMsgCodeFail();

        void onNetError();

        void resetSuccess();

        void resetFail();
    }

}
