package com.xg.insure.mvp.account.modifyphoneapprove;

/**
 * Created by server on 2016/7/15.
 */

public class ResetPhoneStep1Model {
    private ResetPhoneStep1Presenter resetPhoneStep1Presenter;

    public ResetPhoneStep1Model(ResetPhoneStep1Presenter resetPhoneStep1Presenter) {
        this.resetPhoneStep1Presenter = resetPhoneStep1Presenter;
    }

    public void obtainMsgCode(String phoneNum){
        // TODO: 2016/7/15 获取验证码

    }

    public void nextStep(String identityNum, String msgCode){
        // TODO: 2016/7/15 下一步

    }
}
