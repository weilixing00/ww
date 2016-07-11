package com.xg.insure.mvp.model;

import com.xg.insure.mvp.IPresenter.IMorePresenter;
import com.xg.insure.net.retrofit.MyRetrofit;
import com.xg.insure.net.service.RequestService;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by server on 2016/7/8.
 * 更多Fragment的数据层 网络请求
 */

public class MoreModel {


//    private final IMorePresenter iMorePresenter;
//
//    public MoreModel(IMorePresenter iMorePresenter) {
//        this.iMorePresenter = iMorePresenter;
//    }


    public void getUserStats(final IMorePresenter iMorePresenter) {
        //进行网络请求

        //传递网络请求参数
        Map<String, String> map = new HashMap<>();

        MyRetrofit.retrofit()
                .create(RequestService.class)
                .fetchUserStatus(map)
                .enqueue(new Callback<UserStatusResponse>() {
                    @Override
                    public void onResponse(Call<UserStatusResponse> call, Response<UserStatusResponse> response) {
                        UserStatusResponse body = response.body();
                        iMorePresenter.onLoadSuccess(body);

                    }

                    @Override
                    public void onFailure(Call<UserStatusResponse> call, Throwable t) {
                        iMorePresenter.onLoadFail();
                    }
                });
    }

}
