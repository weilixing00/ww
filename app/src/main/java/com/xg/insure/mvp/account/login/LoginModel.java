package com.xg.insure.mvp.account.login;

import com.xg.insure.bean.LoginResponse;
import com.xg.insure.net.retrofit.MyRetrofit;
import com.xg.insure.net.service.RequestService;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by server on 2016/7/14.
 */

public class LoginModel {
    private LoginContract.ILoginPresenter iLoginPresenter;

    public LoginModel(LoginContract.ILoginPresenter iLoginPresenter) {
        this.iLoginPresenter = iLoginPresenter;
    }

    public void login(String username, String password){
        Retrofit retrofit = MyRetrofit.retrofit();
        RequestService requestService = retrofit.create(RequestService.class);
        Map<String, String> loginParames=new HashMap<>();
        loginParames.put("",username);
        loginParames.put("",password);
        Call<LoginResponse> login = requestService.login(loginParames);
        login.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                LoginResponse body = response.body();
               if (body.code==0){
                   iLoginPresenter.loginSuccess();
               }
                else {
                   iLoginPresenter.loginFail();
               }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                iLoginPresenter.onNetError();
            }
        });
    }

}
