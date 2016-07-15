package com.xg.insure.mvp.account.resetpsw;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.xg.insure.R;
import com.xg.insure.base.BaseActivity;
import com.xg.insure.common.NoDoubleClickListener;
import com.xg.insure.ui.TimeCountUtil;
import com.xg.insure.util.JUtils;
import com.xg.insure.util.MathUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by server on 2016/6/21.
 * 重置登录密码
 */

public class ResetPswActivity extends BaseActivity implements ResetPswContract.IResetPswView {

    @BindView(R.id.iv_back_header)
    ImageView ivBackHeader;
    @BindView(R.id.tv_title_header)
    TextView tvTitleHeader;
    @BindView(R.id.iv_icon_right_header)
    ImageView ivIconRightHeader;
    @BindView(R.id.tv_right_header)
    TextView tvRightHeader;
    @BindView(R.id.et_phonenum_activity_resetpsw)
    EditText etPhonenumActivityResetpsw;
    @BindView(R.id.et_verification_code_activity_resetpsw)
    EditText etVerificationCodeActivityResetpsw;
    @BindView(R.id.tv_obtain_verification_code_activity_resetpsw)
    TextView tvObtainVerificationCodeActivityResetpsw;
    @BindView(R.id.et_new_psw_activity_resetpsw)
    EditText etNewPswActivityResetpsw;
    @BindView(R.id.et_mekasure_psw_activity_resetpsw)
    EditText etMekasurePswActivityResetpsw;
    @BindView(R.id.bt_sure_activity_resetpsw)
    Button btSureActivityResetpsw;
    private ResetPswPresenter resetPswPresenter;
    private TimeCountUtil timeCountUtil;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resetpsw);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        resetPswPresenter = new ResetPswPresenter(this);
        timeCountUtil = new TimeCountUtil(this,60000,1000,tvObtainVerificationCodeActivityResetpsw);
        tvTitleHeader.setText("重置密码");
        ivBackHeader.setOnClickListener(noDoubleClick);
        tvObtainVerificationCodeActivityResetpsw.setOnClickListener(noDoubleClick);
        btSureActivityResetpsw.setOnClickListener(noDoubleClick);
    }


    View.OnClickListener noDoubleClick=new NoDoubleClickListener() {
        @Override
        public void onNoDoubleClick(View v) {
            switch (v.getId()){
                case R.id.iv_back_header:
                    // TODO: 2016/7/15 finish
                        finish();
                    break;
                case R.id.tv_obtain_verification_code_activity_resetpsw:
                    //获取验证码
                    obtainMsgCode();
                    break;
                case R.id.bt_sure_activity_resetpsw:
                    //确定
                        resetPsw();
                    break;
            }
        }
    };

    private void resetPsw() {
        String phoneNum = etPhonenumActivityResetpsw.getText().toString();
        String msgCode = etVerificationCodeActivityResetpsw.getText().toString();
        String newPsw = etNewPswActivityResetpsw.getText().toString();
        String confirmNewPsw = etMekasurePswActivityResetpsw.getText().toString();
        if (TextUtils.isEmpty(phoneNum)){
            JUtils.Toast("手机号码不能为空，请输入");
            return;
        }
        if (TextUtils.isEmpty(msgCode)){
            JUtils.Toast("验证码不能为空，请输入");
            return;
        }
        if (TextUtils.isEmpty(newPsw)){
            JUtils.Toast("密码不能为空，请输入");
            return;
        }
        if (TextUtils.isEmpty(confirmNewPsw)){
            JUtils.Toast("请输入确认密码");
            return;
        }

        if (newPsw.equals(confirmNewPsw)){
            JUtils.Toast("两次密码不一致");
            return;
        }
        if (!MathUtil.phoneNumFilter(phoneNum)){
            JUtils.Toast("手机输入有误，请核实正确后输入");
            return;
        }
        if (msgCode.length()!=6){
            JUtils.Toast("验证码错误，请核实正确后输入");
            return;
        }
        if (!MathUtil.pswFilter(newPsw)){
            JUtils.Toast("密码为6-15位字母、标点符号、数字至少包含2种");
            return;
        }
        resetPswPresenter.performResetPsw(phoneNum,msgCode,newPsw);

    }

    private void obtainMsgCode() {
        String phoneNum = etPhonenumActivityResetpsw.getText().toString();
        if (TextUtils.isEmpty(phoneNum)){
            JUtils.Toast("手机号码不能为空，请输入");
            return;
        }
        if (!MathUtil.phoneNumFilter(phoneNum)){
            JUtils.Toast("手机输入有误，请核实正确后输入");
            return;
        }
        resetPswPresenter.obtainMsgCode(phoneNum);
    }


    @Override
    public void onObtainMsgCodeSuccess() {
        timeCountUtil.start();

    }

    @Override
    public void onObtainMsgCodeFail() {

    }

    @Override
    public void onNetError() {

    }

    @Override
    public void resetSuccess() {

    }

    @Override
    public void resetFail() {

    }
}
