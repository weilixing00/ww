package com.xg.insure.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.xg.insure.R;
import com.xg.insure.base.BaseActivity;
import com.xg.insure.mvp.view.IResetPswView;

/**
 * Created by server on 2016/6/21.
 * 重置登录密码
 */

public class ResetPswActivity extends BaseActivity implements IResetPswView {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resetpsw);

    }

    //重置登录密码成功
    @Override
    public void resetPswSuccess() {

    }

    //重置登录密码失败
    @Override
    public void resetPswFail() {

    }
}
