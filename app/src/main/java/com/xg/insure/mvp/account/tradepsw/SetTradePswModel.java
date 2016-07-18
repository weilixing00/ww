package com.xg.insure.mvp.account.tradepsw;

/**
 * Created by server on 2016/7/18.
 */

public class SetTradePswModel {
    private TradePswContract.ITradePswPresenter presenter;

    public SetTradePswModel(TradePswContract.ITradePswPresenter presenter) {
        this.presenter = presenter;
    }

    public void obtainMsgCode(String phoneNum) {

    }

    public void setTradePsw(String phoneNum, String msgCode, String tradePsw) {

    }

}
