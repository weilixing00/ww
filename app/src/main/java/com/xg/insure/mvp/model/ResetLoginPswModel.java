package com.xg.insure.mvp.model;

import com.xg.insure.net.retrofit.BaseResponse;

/**
 * Created by server on 2016/6/21.
 */

public class ResetLoginPswModel {
    private String phoneNum;
    private String verificationCode;

    public ResetLoginPswModel(String phoneNum, String verificationCode) {
        this.phoneNum = phoneNum;
        this.verificationCode = verificationCode;
    }


    public String getPhoneNum() {
        return phoneNum;
    }

    public String getVerificationCode() {
        return verificationCode;
    }
}
