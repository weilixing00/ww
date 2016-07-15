package com.xg.insure.mvp.account.modifyphoneapprove;

/**
 * Created by server on 2016/7/15.
 */

public interface ResetPhoneCertificationContract {
    interface ResetPhoneCertificationStep1View{

        void onObtainMsgCodeSuccess();

        void onObtainMsgCodeFail();

        void onStep1Success();

        void onStep1Fail();
    }
    interface ResetPhoneStep1Presenter {
        void obtainMsgCode(String phoneMum);

        void nextStep(String identityNum,String msgCode);

        void onObtainMsgCodeSuccess();

        void onObtainMsgCodeFail();

        void onStep1Success();

        void onStep1Fail();
    }
    interface ResetPhoneStep2View {

        void onObtainMsgCodeSuccess();

        void onObtainMsgCodeFail();

        void onStep2Success();

        void onStep2Fail();
    }
    interface ResetPhoneStep2Presenter {
        void obtainMsgCode(String phoneMum);

        void resetPhoneCertification(String newPhoneNum,String msgCode);

        void onObtainMsgCodeSuccess();

        void onObtainMsgCodeFail();

        void onStep2Success();

        void onStep2Fail();
    }
}
