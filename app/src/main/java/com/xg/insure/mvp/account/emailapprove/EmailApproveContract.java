package com.xg.insure.mvp.account.emailapprove;

/**
 * Created by server on 2016/7/15.
 */

public interface EmailApproveContract {
    interface IEmailApproveView{
        void onObtainMsgCodeSuccess();
        void onObtainMsgCodeFail();
        void onApproveSuccess();
        void onApproveFail();
    }
    interface IEmailApprovePresenter{
        void obtainMsgCode(String email);
        void emailApprove(String email,String msgCode);

        void onObtainMsgCodeSuccess();
        void onObtainMsgCodeFail();
        void onApproveSuccess();
        void onApproveFail();
    }
}
