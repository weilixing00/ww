package com.xg.insure.mvp.account.modifyloginpsw;

/**
 * Created by server on 2016/6/21.
 * ResetPswActivity的逻辑实现
 */

public class ResetLoginPswPresenter implements ResetLoginPswContract.IPresenter {
    private ResetLoginPswContract.View view;
    private final ResetLoginPswModel resetLoginPswModel;

    public ResetLoginPswPresenter(ResetLoginPswContract.View view) {
        this.view = view;
        resetLoginPswModel = new ResetLoginPswModel(this);
    }

    public void resetLoginPsw(ResetLoginPswModel resetLoginPswModel) {

    }


    @Override
    public void perform(String oriPsw, String newPsw) {
        resetLoginPswModel.performRestLoginPsw(oriPsw, newPsw);
    }

    @Override
    public void onResetSuccess() {
        view.onResetSuccess();
    }

    @Override
    public void onResetFail() {
        view.onResetFail();
    }

    @Override
    public void onNetError() {
        view.onNetError();
    }
}
