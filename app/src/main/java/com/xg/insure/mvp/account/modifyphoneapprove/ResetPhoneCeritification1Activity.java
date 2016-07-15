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
 * Created by server on 2016/6/28.
 * 修改手机认证  第一步
 *
 */

public class ResetPhoneCeritification1Activity extends BaseActivity  implements ResetPhoneCertificationContract.ResetPhoneCertificationStep1View{

    @BindView(R.id.iv_back_header)
    ImageView ivBackHeader;
    ;
    @BindView(R.id.tv_title_header)
    TextView tvTitleHeader;
    @BindView(R.id.iv_icon_right_header)
    ImageView ivIconRightHeader;
    @BindView(R.id.tv_right_header)
    TextView tvRightHeader;
    @BindView(R.id.et_identity_num_actiivty_reset_phone_certification1)
    EditText etIdentityNumActiivtyResetPhoneCertification1;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.tv_phone_num_actiivty_reset_phone_certification1)
    TextView tvPhoneNumActiivtyResetPhoneCertification1;
    @BindView(R.id.et_msg_code_actiivty_reset_phone_certification1)
    EditText etMsgCodeActiivtyResetPhoneCertification1;
    @BindView(R.id.tv_obtain_msg_code_actiivty_reset_phone_certification1)
    TextView tvObtainMsgCodeActiivtyResetPhoneCertification1;
    @BindView(R.id.bt_next_step_actiivty_reset_phone_certification1)
    Button btNextStepActiivtyResetPhoneCertification1;
    private ResetPhoneStep1Presenter resetPhoneStep1Presenter;
    private TimeCountUtil timeCountUtil;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_phone_ceritification1);
        ButterKnife.bind(this);
        initView();

        resetPhoneStep1Presenter = new ResetPhoneStep1Presenter(this);
        timeCountUtil = new TimeCountUtil(this,60000,1000,tvObtainMsgCodeActiivtyResetPhoneCertification1);
    }

    private void initView() {
        tvTitleHeader.setText("修改手机认证");
        ivBackHeader.setOnClickListener(noDoubleClick);
        tvObtainMsgCodeActiivtyResetPhoneCertification1.setOnClickListener(noDoubleClick);
        btNextStepActiivtyResetPhoneCertification1.setOnClickListener(noDoubleClick);
    }

    View.OnClickListener noDoubleClick = new NoDoubleClickListener() {
        @Override
        public void onNoDoubleClick(View v) {

            switch (v.getId()) {
                case R.id.iv_back_header:
                    // TODO: 2016/6/28 finish

                    break;

                case R.id.tv_obtain_msg_code_actiivty_reset_phone_certification1:
                    // TODO: 2016/6/28 获取验证码
                    obtainMsgCode();

                    break;
                case R.id.bt_next_step_actiivty_reset_phone_certification1:
                    // TODO: 2016/6/28 下一步
                    nextStep();

                    break;
                default:
                    throw new RuntimeException("ResetPhoneCeritification1Activity 没有找到对应资源ID");
            }
        }
    };

    /**
     * 下一步
     */
    private void nextStep() {
        String identityNum = etIdentityNumActiivtyResetPhoneCertification1.getText().toString();
        String msgCode = etMsgCodeActiivtyResetPhoneCertification1.getText().toString();
        if (TextUtils.isEmpty(identityNum)){
            JUtils.Toast("请输入身份证号");
            return;
        }
        if (TextUtils.isEmpty(msgCode)){
            JUtils.Toast("请输入验证码");
            return;
        }
        if (MathUtil.identityCardFilter(identityNum)){
            JUtils.Toast("身份证号码错误");
            return;
        }
        if (msgCode.length()!=6){
            JUtils.Toast("验证码错误");
            return;
        }

        resetPhoneStep1Presenter.nextStep(identityNum,msgCode);
    }

    /**
     * 获取验证码
     */
    private void obtainMsgCode() {
        String phoneNum = tvPhoneNumActiivtyResetPhoneCertification1.getText().toString();
        resetPhoneStep1Presenter.obtainMsgCode(phoneNum);
    }

    @Override
    public void onObtainMsgCodeSuccess() {
        timeCountUtil.start();

    }

    @Override
    public void onObtainMsgCodeFail() {

    }

    @Override
    public void onStep1Success() {
        //跳转到第二步 (带参?)

    }

    @Override
    public void onStep1Fail() {

    }


}
