package com.xg.insure.mvp.Presenter;

import com.xg.insure.bean.LoginResponse;
import com.xg.insure.mvp.model.User;
import com.xg.insure.mvp.view.ILoginView;
import com.xg.insure.net.retrofit.MyRetrofit;
import com.xg.insure.net.service.RequestService;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by server on 2016/6/21.
 *LoginAcvivity的逻辑类
 */

public class LoginPresenter  {
    public ILoginView view;
    public LoginPresenter(ILoginView view) {
        this.view=view;
    }

    /**
     * 用户登录
     * User 用户类
     */
    public void login(User user){
        Retrofit retrofit = MyRetrofit.retrofit();
        RequestService requestService = retrofit.create(RequestService.class);
        Map<String, String> loginParames=new HashMap<>();
        loginParames.put("",user.username);
        loginParames.put("",user.password);
        Call<LoginResponse> login = requestService.login(loginParames);
        login.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                LoginResponse body = response.body();
//               if (body.code==0){
//                   view.loginSuccess();
//               }
//                else {
//                   view.loginFail();
//               }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                view.loginFail();
            }
        });
    }
}
