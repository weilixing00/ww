package com.xg.insure.mvp.account.modifyphoneapprove;

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
 * Created by server on 2016/7/5.
 * 修改手机认证  第二步
 */

public class ResetPhoneCeritification2Activity extends BaseActivity implements ResetPhoneCertificationContract.ResetPhoneStep2View{
    @BindView(R.id.iv_back_header)
    ImageView ivBackHeader;
    @BindView(R.id.tv_title_header)
    TextView tvTitleHeader;
    @BindView(R.id.iv_icon_right_header)
    ImageView ivIconRightHeader;
    @BindView(R.id.tv_right_header)
    TextView tvRightHeader;
    @BindView(R.id.et_new_phone_num_actiivty_reset_phone_certification2)
    EditText etNewPhoneNumActiivtyResetPhoneCertification2;
    @BindView(R.id.et_msg_code_actiivty_reset_phone_certification2)
    EditText etMsgCodeActiivtyResetPhoneCertification2;
    @BindView(R.id.tv_obtain_msg_code_actiivty_reset_phone_certification2)
    TextView tvObtainMsgCodeActiivtyResetPhoneCertification2;
    @BindView(R.id.bt_sure_step_actiivty_reset_phone_certification2)
    Button btSureStepActiivtyResetPhoneCertification2;
    private ResetPhoneStep2Presenter resetPhoneStep1Presenter;
    private TimeCountUtil timeCountUtil;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_phone_ceritification2);
        ButterKnife.bind(this);
        initView();

        resetPhoneStep1Presenter = new ResetPhoneStep2Presenter(this);
        timeCountUtil = new TimeCountUtil(this,60000,1000,tvObtainMsgCodeActiivtyResetPhoneCertification2);
    }

    private void initView() {
        tvTitleHeader.setText("修改手机认证");
        ivBackHeader.setOnClickListener(noDoubleClick);
        tvObtainMsgCodeActiivtyResetPhoneCertification2.setOnClickListener(noDoubleClick);
        btSureStepActiivtyResetPhoneCertification2.setOnClickListener(noDoubleClick);
    }
    View.OnClickListener noDoubleClick=new NoDoubleClickListener() {
        @Override
        public void onNoDoubleClick(View v) {
            switch (v.getId()){
                case R.id.iv_back_header:
                    // TODO: 2016/7/5 finish 
                    
                    break;
                case R.id.tv_obtain_msg_code_actiivty_reset_phone_certification2:
                    // TODO: 2016/7/5 获取验证码
                    obtainMsgCode();

                    break;
                case R.id.bt_sure_step_actiivty_reset_phone_certification2:
                    // TODO: 2016/7/5 确定
                    resetPhoneCertification();

                    break;

            }
        }
    };

    private void resetPhoneCertification() {
        String newPhoneNum = etNewPhoneNumActiivtyResetPhoneCertification2.getText().toString().toString().trim();
        String msgCode = etMsgCodeActiivtyResetPhoneCertification2.getText().toString().toString().trim();
        if (TextUtils.isEmpty(newPhoneNum)){
            JUtils.Toast("请输新手机号");
            return;
        }
        if (TextUtils.isEmpty(msgCode)){
            JUtils.Toast("请输入验证码");
            return;
        }
        if (MathUtil.phoneNumFilter(newPhoneNum)){
            JUtils.Toast("请填写正确的手机号码");
            return;
        }
        if (msgCode.length()!=6){
            JUtils.Toast("验证码错误");
            return;
        }

        resetPhoneStep1Presenter.resetPhoneCertification(newPhoneNum,msgCode);
    }

    private void obtainMsgCode() {
        String newPhoneNum = etNewPhoneNumActiivtyResetPhoneCertification2.getText().toString();
        if (TextUtils.isEmpty(newPhoneNum)){
            JUtils.Toast("请输新手机号");
            return;
        }
        if (MathUtil.phoneNumFilter(newPhoneNum)){
            JUtils.Toast("请填写正确的手机号码");
            return;
        }
        resetPhoneStep1Presenter.obtainMsgCode(newPhoneNum);
    }

    @Override
    public void onObtainMsgCodeSuccess() {
        timeCountUtil.start();
    }

    @Override
    public void onObtainMsgCodeFail() {

    }

    @Override
    public void onStep2Success() {
//        成功修改手机后提示“恭喜您，成功修改手机认证”，页面跳转到安全中心

    }

    @Override
    public void onStep2Fail() {

    }
}
