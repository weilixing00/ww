package com.xg.insure.mvp.account.modifyphoneapprove;

/**
 * Created by server on 2016/7/15.
 */

public class ResetPhoneStep1Presenter implements ResetPhoneCertificationContract.ResetPhoneStep1Presenter {
    private ResetPhoneCertificationContract.ResetPhoneCertificationStep1View resetPhoneCertificationStep1View;
    private final ResetPhoneStep1Model resetPhoneStep1Model;

    public ResetPhoneStep1Presenter(ResetPhoneCertificationContract.ResetPhoneCertificationStep1View resetPhoneCertificationStep1View) {
        this.resetPhoneCertificationStep1View = resetPhoneCertificationStep1View;
        resetPhoneStep1Model = new ResetPhoneStep1Model(this);

    }

    @Override
    public void obtainMsgCode(String phoneMum) {
        resetPhoneStep1Model.obtainMsgCode(phoneMum);
    }

    @Override
    public void nextStep(String identityNum, String msgCode) {
        resetPhoneStep1Model.nextStep(identityNum, msgCode);
    }

    @Override
    public void onObtainMsgCodeSuccess() {
        resetPhoneCertificationStep1View.onObtainMsgCodeSuccess();
    }

    @Override
    public void onObtainMsgCodeFail() {
        resetPhoneCertificationStep1View.onObtainMsgCodeFail();
    }

    @Override
    public void onStep1Success() {
        resetPhoneCertificationStep1View.onStep1Success();
    }

    @Override
    public void onStep1Fail() {
        resetPhoneCertificationStep1View.onStep1Fail();
    }
}
