package com.xg.insure.mvp.account.modifyphoneapprove;

/**
 * Created by server on 2016/7/15.
 */

public class ResetPhoneStep2Model {
    private ResetPhoneCertificationContract.ResetPhoneStep2Presenter presenter;

    public ResetPhoneStep2Model(ResetPhoneCertificationContract.ResetPhoneStep2Presenter presenter) {
        this.presenter = presenter;
    }

    public void obtainMsgCode(String phoneNum){

    }

    public void reset(String newPhoneNum,String msgCode){

    }
}
