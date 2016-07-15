package com.xg.insure.mvp.account.emailapprove;

/**
 * Created by server on 2016/7/15.
 */

public class EmailApprovePresenter implements EmailApproveContract.IEmailApprovePresenter {

    private EmailApproveContract.IEmailApproveView view;
    private final EmailApproveModel emailApproveModel;

    public EmailApprovePresenter(EmailApproveContract.IEmailApproveView view) {
        this.view = view;
        emailApproveModel = new EmailApproveModel(this);
    }

    @Override
    public void obtainMsgCode(String email) {
        emailApproveModel.obtainMsgCode(email);
    }

    @Override
    public void emailApprove(String email, String msgCode) {
        emailApproveModel.emailApprove(email, msgCode);
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
    public void onApproveSuccess() {
        view.onApproveSuccess();
    }

    @Override
    public void onApproveFail() {
        view.onApproveFail();
    }
}
