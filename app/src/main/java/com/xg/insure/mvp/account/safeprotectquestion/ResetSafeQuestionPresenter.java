package com.xg.insure.mvp.account.safeprotectquestion;

/**
 * Created by server on 2016/7/18.
 */

public class ResetSafeQuestionPresenter implements ResetSafeQuestionContract.IResetSafeQuestionPresenter {
    private ResetSafeQuestionContract.IResetSafeQuestionView view;
    private final ResetSafeQuestionModel model;

    public ResetSafeQuestionPresenter(ResetSafeQuestionContract.IResetSafeQuestionView view) {
        this.view = view;
        model = new ResetSafeQuestionModel(this);
    }

    @Override
    public void obtianMsgCode(String phoneNum) {
        model.obtainMsgCode(phoneNum);
    }

    @Override
    public void resetQuestion(String msgCode, String quesion, String answer) {
model.resetQuestion(msgCode, quesion, answer);
    }

    @Override
    public void onObtainMsgCodeSuccess() {
        view.onObtainMsgCodeSuccess();
    }

    @Override
    public void onObtainMsgCodeFail() {
        view.onObtainMsgCodeFail();
    }

    @Override
    public void onResetSuccess() {
        view.onResetSuccess();
    }

    @Override
    public void onResetFail() {
        view.onResetFail();
    }
}
