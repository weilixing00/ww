package com.xg.insure.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jaeger.library.StatusBarUtil;
import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.xg.insure.R;
import com.xg.insure.base.BaseActivity;
import com.xg.insure.common.NoDoubleClickListener;
import com.xg.insure.mvp.view.ILoginView;
import com.xg.insure.util.JUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by server on 2016/6/21.
 * 登录界面
 */

public class LoginActivity extends BaseActivity implements ILoginView {
    @BindView(R.id.iv_back_header)
    ImageView ivBackHeader;
    @BindView(R.id.tv_title_header)
    TextView tvTitleHeader;
    @BindView(R.id.et_phonenum_activity_login)
    EditText etPhonenumActivityLogin;
    @BindView(R.id.et_psw_activity_login)
    EditText etPswActivityLogin;
    @BindView(R.id.tv_forget_psw_activity_login)
    TextView tvForgetPswActivityLogin;
    @BindView(R.id.bt_login_activity_login)
    Button btLoginActivityLogin;
    @BindView(R.id.ll_regist_activity_login)
    LinearLayout llRegistActivityLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initView();

    }

    private void initView() {




        ivBackHeader.setOnClickListener(noDoubleClick);
        llRegistActivityLogin.setOnClickListener(noDoubleClick);
        tvTitleHeader.setText("登录");

    }

    @Override
    public void loginSuccess() {
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public void loginFail() {
        JUtils.Toast("网络链接错误");
    }
    View.OnClickListener noDoubleClick=new NoDoubleClickListener() {
        @Override
        public void onNoDoubleClick(View v) {
            switch (v.getId()){
                case R.id.iv_back_header:
                    finish();
                    break;
                case R.id.ll_regist_activity_login:
                    startActivity(new Intent(LoginActivity.this,RegistActivity.class));
                    finish();
                    break;
                default:
                    throw new RuntimeException("LoginActivity找不到对应资源ID");

            }
        }
    };

}
