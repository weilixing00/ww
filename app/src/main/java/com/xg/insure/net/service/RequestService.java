package com.xg.insure.net.service;

import com.xg.insure.bean.LoginResponse;
import com.xg.insure.bean.ResetLoginPswResponse;
import com.xg.insure.constant.HttpConstant;
import com.xg.insure.mvp.model.UserStatusResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by server on 2016/6/21.
 */

public interface RequestService {
    /**
     * 登录调用接口
     * @param fields
     * @return
     */
    @FormUrlEncoded
    @POST(HttpConstant.LOGIN)
    Call<LoginResponse> login(@FieldMap Map<String,String> fields);
    //第二种传递方式
//    Call<LoginResponse> login(@Field(KeyConstant.ParamsKeyConstant.) String fields);

    /**
     * 修改登录密码调用接口
     * @param fields
     * @return
     */
    @FormUrlEncoded
    @POST(HttpConstant.RESET_LOGIN_PSW)
    Call<ResetLoginPswResponse> resetLoginPsw(@FieldMap Map<String,String> fields);

    //测试用的  到时候删了
    @FormUrlEncoded
    @POST(HttpConstant.Test)
    Call<TestResponse> test(@FieldMap Map<String, String> fields);

    /**
     * 获取用户登录状态 各种认证状态
     */
    @FormUrlEncoded
    @POST(HttpConstant.Test)
    Call<UserStatusResponse> fetchUserStatus(@FieldMap Map<String, String> fields);

}
