package com.xg.insure.mvp.account.modifyloginpsw;

/**
 * Created by server on 2016/7/15.
 */

public interface ResetLoginPswContract {
    interface View {
        void onResetSuccess();

        void onResetFail();

        void onNetError();
    }

    interface IPresenter{
        void perform(String oriPsw, String newPsw);

        void onResetSuccess();

        void onResetFail();

        void onNetError();
    }
}
