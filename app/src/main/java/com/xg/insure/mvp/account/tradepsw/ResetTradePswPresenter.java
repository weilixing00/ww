package com.xg.insure.mvp.account.tradepsw;

/**
 * Created by server on 2016/7/18.
 */

public class ResetTradePswPresenter implements TradePswContract.ITradePswPresenter {

    private final ResetTradePswModel model;
    private final TradePswContract.ITradePswView view;


    public ResetTradePswPresenter(TradePswContract.ITradePswView view) {
        this.view = view;
        model = new ResetTradePswModel(this);
    }

    @Override
    public void obtainMsgCode(String phoneNum) {
        model.obtainMsgCode(phoneNum);
    }

    @Override
    public void setTradePsw(String phoneNum, String msgCode, String tradePsw) {
            model.resetTradePsw(phoneNum, msgCode, tradePsw);
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
    public void onNetError() {
        view.onNetError();
    }

    @Override
    public void onSetTradePswSuccess() {
            view.onTradePswSuccess();
    }

    @Override
    public void onSetTradePswFail() {
        view.onTradePswFail();
    }
}
