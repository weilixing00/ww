package com.xg.insure.mvp.account.tradepsw;

/**
 * Created by server on 2016/7/18.
 */

public interface TradePswContract {
    interface ITradePswView {
        void onObtainMsgCodeSuccess();

        void onObtainMsgCodeFail();

        void onNetError();

        void onTradePswSuccess();

        void onTradePswFail();
    }

    interface ITradePswPresenter {
        void obtainMsgCode(String phoneNum);

        void setTradePsw(String phoneNum,String msgCode,String tradePsw);

        void onObtainMsgCodeSuccess();

        void onObtainMsgCodeFail();

        void onNetError();

        void onSetTradePswSuccess();

        void onSetTradePswFail();
    }

}
