package com.xg.insure.mvp.account.safeprotectquestion;

/**
 * Created by server on 2016/7/18.
 */

public interface ResetSafeQuestionContract {
    interface IResetSafeQuestionView{

        void onObtainMsgCodeSuccess();

        void onObtainMsgCodeFail();

        void onResetSuccess();

        void onResetFail();
    }

    interface IResetSafeQuestionPresenter{
        void obtianMsgCode(String phoneNum);

        void resetQuestion(String msgCode,String quesion,String answer);

        void onObtainMsgCodeSuccess();

        void onObtainMsgCodeFail();

        void onResetSuccess();

        void onResetFail();
    }
}
