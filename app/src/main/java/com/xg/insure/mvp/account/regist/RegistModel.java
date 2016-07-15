package com.xg.insure.mvp.account.regist;

import com.xg.insure.bean.LoginMsgCodeResponse;
import com.xg.insure.bean.RegistResponse;
import com.xg.insure.mvp.account.regist.RegistContract;
import com.xg.insure.mvp.account.regist.RegistParameterBean;
import com.xg.insure.net.retrofit.MyRetrofit;
import com.xg.insure.net.service.RequestService;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by server on 2016/7/14.
 */

public class RegistModel {

    private RegistContract.IRegistPresenter iRegistPresenter;

    public RegistModel(RegistContract.IRegistPresenter iRegistPresenter) {
        this.iRegistPresenter = iRegistPresenter;
    }

    /**
     * 注册 获取返回值
     * @param registParameterBean
     */
    public void regist(RegistParameterBean registParameterBean) {

        //传递网络请求参数
        Map<String, String> map = new HashMap<>();

        MyRetrofit.retrofit()
                .create(RequestService.class)
                .resist(map)
                .enqueue(new Callback<RegistResponse>() {
                    @Override
                    public void onResponse(Call<RegistResponse> call, Response<RegistResponse> response) {
                        RegistResponse body = response.body();
                        if (body.code == 0) {
                            iRegistPresenter.onRegistSuccess();
                        } else {
                            iRegistPresenter.onRegistFail(body.error);
                        }

                    }

                    @Override
                    public void onFailure(Call<RegistResponse> call, Throwable t) {
                        iRegistPresenter.onNetError();
                    }
                });
    }

    /**
     * 获取验证码
     * @param phoneMum
     */
    public void obtainMsgCode(String phoneMum) {
        //传递网络请求参数
        Map<String, String> map = new HashMap<>();

        MyRetrofit.retrofit()
                .create(RequestService.class)
                .loginMsgCode(map)
                .enqueue(new Callback<LoginMsgCodeResponse>() {
                    @Override
                    public void onResponse(Call<LoginMsgCodeResponse> call, Response<LoginMsgCodeResponse> response) {
                        LoginMsgCodeResponse body = response.body();
                        if (body.code == 0) {
                            iRegistPresenter.onObtainMsgCodeSuccess();
                        } else {
                            iRegistPresenter.onObtainMsgCodeFail(body.error);
                        }

                    }

                    @Override
                    public void onFailure(Call<LoginMsgCodeResponse> call, Throwable t) {
                        iRegistPresenter.onNetError();
                    }
                });
    }
}
