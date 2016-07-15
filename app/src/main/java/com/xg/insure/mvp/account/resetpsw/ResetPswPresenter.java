package com.xg.insure.mvp.account.resetpsw;

/**
 * Created by server on 2016/7/15.
 */

public class ResetPswPresenter implements ResetPswContract.IResetPswPresenter {

    private ResetPswContract.IResetPswView iResetPswView;
    private ResetPswModel resetPswModel;


    public ResetPswPresenter(ResetPswContract.IResetPswView iResetPswView) {
        this.iResetPswView = iResetPswView;
        resetPswModel=new ResetPswModel(this);
    }




    @Override
    public void performResetPsw(String phoneNum, String msgCode, String newPsw) {
            resetPswModel.resetPsw(phoneNum, msgCode, newPsw);
    }

    @Override
    public void obtainMsgCode(String phoneNum) {
            resetPswModel.obtainMsgCode(phoneNum);
    }

    @Override
    public void onObtainMsgCodeSuccess() {

    }

    @Override
    public void onObtainMsgCodeFail() {

    }

    @Override
    public void onNetError() {

    }

    @Override
    public void resetSuccess() {

    }

    @Override
    public void resetFail() {

    }
}
