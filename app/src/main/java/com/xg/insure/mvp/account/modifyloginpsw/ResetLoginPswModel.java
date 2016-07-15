package com.xg.insure.mvp.account.modifyloginpsw;

import com.xg.insure.bean.ResetLoginPswResponse;
import com.xg.insure.net.retrofit.MyRetrofit;
import com.xg.insure.net.service.RequestService;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by server on 2016/6/21.
 */

public class ResetLoginPswModel {


    private final ResetLoginPswContract.IPresenter iPresenter;

    public ResetLoginPswModel(ResetLoginPswContract.IPresenter iPresenter) {
            this.iPresenter=iPresenter;
    }


    public void performRestLoginPsw(String oriPsw, String newPsw){
        RequestService requestService = MyRetrofit.retrofit().create(RequestService.class);
        Map<String, String> resetLoginPswMap=new HashMap<>();
        resetLoginPswMap.put("", oriPsw);

        resetLoginPswMap.put("", newPsw);
        Call<ResetLoginPswResponse> resetLoginPswResponseCall = requestService.resetLoginPsw(resetLoginPswMap);
        resetLoginPswResponseCall.enqueue(new Callback<ResetLoginPswResponse>() {
            @Override
            public void onResponse(Call<ResetLoginPswResponse> call, Response<ResetLoginPswResponse> response) {
                ResetLoginPswResponse body = response.body();
                //成功
                iPresenter.onResetSuccess();

                //失败  显示错误信息
                iPresenter.onResetFail();

//                body.code
            }

            @Override
            public void onFailure(Call<ResetLoginPswResponse> call, Throwable t) {
            iPresenter.onNetError();
            }
        });
    }


}
