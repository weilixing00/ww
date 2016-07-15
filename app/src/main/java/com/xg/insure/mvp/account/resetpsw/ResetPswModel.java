package com.xg.insure.mvp.account.resetpsw;

/**
 * Created by server on 2016/7/15.
 */

public class ResetPswModel {
    private  ResetPswContract.IResetPswPresenter iResetPswPresenter;

    public ResetPswModel(ResetPswContract.IResetPswPresenter iResetPswPresenter) {
        this.iResetPswPresenter = iResetPswPresenter;
    }

    public void obtainMsgCode(String phoneNum){

    }

    public void resetPsw(String phoneNum,String msgCode,String newPsw){

    };
}
