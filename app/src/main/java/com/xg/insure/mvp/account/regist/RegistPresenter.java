package com.xg.insure.mvp.account.regist;

/**
 * Created by server on 2016/7/14.
 */

public class RegistPresenter implements RegistContract.IRegistPresenter {
    private RegistContract.IRegistView iRegistView;
    private final RegistModel registModel;

    public RegistPresenter(RegistContract.IRegistView iRegistView) {
        this.iRegistView = iRegistView;
        registModel = new RegistModel(this);
    }

    /**
     * 注册
     * @param registParameterBean
     */
    public void regist(RegistParameterBean registParameterBean){

        registModel.regist(registParameterBean);
    }

    /**
     * 获取验证码
     * @param phoneMum
     */
    public void obtainMsgCode(String phoneMum) {
                registModel.obtainMsgCode(phoneMum);
    }


    @Override
    public void onRegistSuccess() {
        iRegistView.onRegistSuccess();
    }

    @Override
    public void onRegistFail(String error) {
            iRegistView.onRegistError(error);
    }

    @Override
    public void onNetError() {
        iRegistView.onNetError();
    }

    @Override
    public void onObtainMsgCodeFail(String error) {
        iRegistView.onObtainMsgError(error);
    }

    @Override
    public void onObtainMsgCodeSuccess() {
        iRegistView.onObtainMsgSuccess();
    }


}
