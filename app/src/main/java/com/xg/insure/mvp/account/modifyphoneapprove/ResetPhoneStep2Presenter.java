package com.xg.insure.mvp.account.modifyphoneapprove;

/**
 * Created by server on 2016/7/15.
 */

public class ResetPhoneStep2Presenter implements ResetPhoneCertificationContract.ResetPhoneStep2Presenter {
    private ResetPhoneCertificationContract.ResetPhoneStep2View resetPhoneStep2View;
    private final ResetPhoneStep2Model resetPhoneStep2Model;

    public ResetPhoneStep2Presenter(ResetPhoneCertificationContract.ResetPhoneStep2View resetPhoneStep2View) {
        this.resetPhoneStep2View = resetPhoneStep2View;
        resetPhoneStep2Model = new ResetPhoneStep2Model(this);
    }

    @Override
    public void obtainMsgCode(String phoneMum) {
        resetPhoneStep2Model.obtainMsgCode(phoneMum);
    }

    @Override
    public void resetPhoneCertification(String newPhoneNum, String msgCode) {
        resetPhoneStep2Model.reset(newPhoneNum, msgCode);
    }

    @Override
    public void onObtainMsgCodeSuccess() {
        resetPhoneStep2View.onObtainMsgCodeSuccess();
    }

    @Override
    public void onObtainMsgCodeFail() {
        resetPhoneStep2View.onObtainMsgCodeFail();
    }

    @Override
    public void onStep2Success() {
        resetPhoneStep2View.onStep2Success();
    }

    @Override
    public void onStep2Fail() {
        resetPhoneStep2View.onStep2Fail();
    }
}
