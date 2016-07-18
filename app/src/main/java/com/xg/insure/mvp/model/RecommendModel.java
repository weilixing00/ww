package com.xg.insure.mvp.model;

import android.widget.Toast;

import com.xg.insure.bean.RecommendResponse;
import com.xg.insure.mvp.IPresenter.IRecommendPresenter;
import com.xg.insure.mvp.Presenter.RecommendPresenter;
import com.xg.insure.net.retrofit.MyRetrofit;
import com.xg.insure.net.service.RequestService;
import com.xg.insure.net.service.TestResponse;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by server on 2016/7/12.
 * 推荐Fragment的M层
 */

public class RecommendModel {
    IRecommendPresenter recommendPresenter;
    public RecommendModel(IRecommendPresenter recommendPresenter) {
        this.recommendPresenter=recommendPresenter;
    }

    public void fetchRecommendResponse(){
//            Retrofit retrofit = MyRetrofit.retrofit();
//
//            RequestService requestService = retrofit.create(RequestService.class);
//
//            Map<String, String> map=new HashMap<>();
//            map.put("pageIndex","1");
//            map.put("pageSize","5");
//
//            Call<RecommendResponse> test = requestService.recommend(map);
//            test.enqueue(new Callback<RecommendResponse>() {
//                @Override
//                public void onResponse(Call<RecommendResponse> call, Response<RecommendResponse> response) {
//                    RecommendResponse body = response.body();
//
//                    recommendPresenter.onLoadSuccess(body);
////                    Toast.makeText(getContext(), "body"+body.count, Toast.LENGTH_SHORT).show();
//                }
//
//                @Override
//                public void onFailure(Call<RecommendResponse> call, Throwable t) {
//                    recommendPresenter.onLoadFail();
//                }
//            });
        }

}
