package com.xg.insure.mvp.account.tradepsw;

/**
 * Created by server on 2016/7/18.
 */

public class SetTradePswPresenter implements TradePswContract.ITradePswPresenter {

    private TradePswContract.ITradePswView view;
    private final SetTradePswModel setTradePswModel;

    public SetTradePswPresenter(TradePswContract.ITradePswView view) {
        this.view = view;
        setTradePswModel = new SetTradePswModel(this);
    }

    @Override
    public void obtainMsgCode(String phoneNum) {
        setTradePswModel.obtainMsgCode(phoneNum);
    }

    @Override
    public void setTradePsw(String phoneNum, String msgCode, String tradePsw) {
        setTradePswModel.setTradePsw(phoneNum, msgCode, tradePsw);
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
