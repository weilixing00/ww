package com.xg.insure.mvp.account.emailapprove;

/**
 * Created by server on 2016/7/15.
 */

public class EmailApproveModel {
    private EmailApprovePresenter emailApprovePresenter;

    public EmailApproveModel(EmailApprovePresenter emailApprovePresenter) {
        this.emailApprovePresenter = emailApprovePresenter;
    }

    public void obtainMsgCode(String emailAddress){

    }
    public void emailApprove(String emailAddress,String msgCode){

    }
}
