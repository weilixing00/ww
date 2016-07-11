package com.xg.insure.mvp.Presenter;

import com.xg.insure.bean.ResetLoginPswResponse;
import com.xg.insure.mvp.model.ResetLoginPswModel;
import com.xg.insure.mvp.view.IResetPswView;
import com.xg.insure.net.retrofit.MyRetrofit;
import com.xg.insure.net.service.RequestService;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by server on 2016/6/21.
 * ResetPswActivity的逻辑实现
 */

public class ResetLoginPswPresenter {
    private IResetPswView view;

    public ResetLoginPswPresenter(IResetPswView view) {
        this.view = view;
    }

    public void resetLoginPsw(ResetLoginPswModel resetLoginPswModel){
        RequestService requestService = MyRetrofit.retrofit().create(RequestService.class);
        Map<String, String> resetLoginPswMap=new HashMap<>();
        resetLoginPswMap.put("", resetLoginPswModel.getPhoneNum());
        resetLoginPswMap.put("", resetLoginPswModel.getVerificationCode());
        Call<ResetLoginPswResponse> resetLoginPswResponseCall = requestService.resetLoginPsw(resetLoginPswMap);
        resetLoginPswResponseCall.enqueue(new Callback<ResetLoginPswResponse>() {
            @Override
            public void onResponse(Call<ResetLoginPswResponse> call, Response<ResetLoginPswResponse> response) {
                ResetLoginPswResponse body = response.body();
//                body.code
            }

            @Override
            public void onFailure(Call<ResetLoginPswResponse> call, Throwable t) {

            }
        });
    }





}
