package com.xg.insure.net.service;

import com.xg.insure.bean.LoginMsgCodeResponse;
import com.xg.insure.bean.LoginResponse;
import com.xg.insure.bean.RecommendResponse;
import com.xg.insure.bean.RegistResponse;
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

    /**
     * 注册登录密码调用的接口
     * @param fields
     * @return
     */
    @FormUrlEncoded
    @POST(HttpConstant.RESET_LOGIN_PSW)
    Call<RegistResponse> resist(@FieldMap Map<String,String> fields);
    /**
     * 获取登录验证码调用的接口
     * @param fields
     * @return
     */
    @FormUrlEncoded
    @POST(HttpConstant.RESET_LOGIN_PSW)
    Call<LoginMsgCodeResponse> loginMsgCode(@FieldMap Map<String,String> fields);


    //推荐Fragment的调用接口
    @FormUrlEncoded
    @POST(HttpConstant.RECOMMEND)
    Call<RecommendResponse> recommend(@FieldMap Map<String, String> fields);

    /**
     * 获取用户登录状态 各种认证状态
     */
    @FormUrlEncoded
    @POST(HttpConstant.Test)
    Call<UserStatusResponse> fetchUserStatus(@FieldMap Map<String, String> fields);

}
