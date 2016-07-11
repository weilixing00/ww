package com.xg.insure.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xg.insure.R;
import com.xg.insure.base.BaseActivity;
import com.xg.insure.common.NoDoubleClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by server on 2016/6/27.
 * 安全中心
 */

public class SecurityCenterActivity extends BaseActivity {

    @BindView(R.id.iv_back_header)
    ImageView ivBackHeader;
    @BindView(R.id.tv_title_header)
    TextView tvTitleHeader;
    @BindView(R.id.iv_icon_right_header)
    ImageView ivIconRightHeader;
    @BindView(R.id.tv_right_header)
    TextView tvRightHeader;
    @BindView(R.id.iv_slevel1_activity_security_center)
    ImageView ivSlevel1ActivitySecurityCenter;
    @BindView(R.id.iv_slevel2_activity_security_center)
    ImageView ivSlevel2ActivitySecurityCenter;
    @BindView(R.id.iv_slevel3_activity_security_center)
    ImageView ivSlevel3ActivitySecurityCenter;
    @BindView(R.id.iv_slevel4_activity_security_center)
    ImageView ivSlevel4ActivitySecurityCenter;
    @BindView(R.id.iv_slevel5_activity_security_center)
    ImageView ivSlevel5ActivitySecurityCenter;
    @BindView(R.id.iv_slevel6_activity_security_center)
    ImageView ivSlevel6ActivitySecurityCenter;
    @BindView(R.id.iv_slevel7_activity_security_center)
    ImageView ivSlevel7ActivitySecurityCenter;
    @BindView(R.id.tv_account_activity_security_center)
    TextView tvAccountActivitySecurityCenter;
    @BindView(R.id.tv_login_psw_activity_security_center)
    TextView tvLoginPswActivitySecurityCenter;
    @BindView(R.id.ll_reset_login_psw_activity_security_center)
    LinearLayout llResetLoginPswActivitySecurityCenter;
    @BindView(R.id.tv_trade_psw_activity_security_center)
    TextView tvTradePswActivitySecurityCenter;
    @BindView(R.id.ll_reset_trade_psw_activity_security_center)
    LinearLayout llResetTradePswActivitySecurityCenter;
    @BindView(R.id.tv_question_activity_security_center)
    TextView tvQuestionActivitySecurityCenter;
    @BindView(R.id.ll_reset_question_activity_security_center)
    LinearLayout llResetQuestionActivitySecurityCenter;
    @BindView(R.id.tv_username_activity_security_center)
    TextView tvUsernameActivitySecurityCenter;
    @BindView(R.id.tv_phone_verification_activity_security_center)
    TextView tvPhoneVerificationActivitySecurityCenter;
    @BindView(R.id.textView7)
    TextView textView7;
    @BindView(R.id.ll_reset_phone_verificaion_activity_security_center)
    LinearLayout llResetPhoneVerificaionActivitySecurityCenter;
    @BindView(R.id.tv_email_activity_security_center)
    TextView tvEmailActivitySecurityCenter;
    @BindView(R.id.ll_reset_email_activity_security_center)
    LinearLayout llResetEmailActivitySecurityCenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security_center);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        tvTitleHeader.setText("安全中心");
        ivBackHeader.setOnClickListener(noDoubleClick);
        llResetEmailActivitySecurityCenter.setOnClickListener(noDoubleClick);
        llResetLoginPswActivitySecurityCenter.setOnClickListener(noDoubleClick);
        llResetPhoneVerificaionActivitySecurityCenter.setOnClickListener(noDoubleClick);
        llResetQuestionActivitySecurityCenter.setOnClickListener(noDoubleClick);
        llResetTradePswActivitySecurityCenter.setOnClickListener(noDoubleClick);

    }


    View.OnClickListener noDoubleClick = new NoDoubleClickListener() {
        @Override
        public void onNoDoubleClick(View v) {
            switch (v.getId()) {
                case R.id.iv_back_header:
                    // TODO: 2016/6/27 finish

                    break;
                case R.id.ll_reset_login_psw_activity_security_center:
                    // TODO: 2016/6/27 修改登录密码

                    break;
                case R.id.ll_reset_trade_psw_activity_security_center:
                    // TODO: 2016/6/27 修改交易密码

                    break;
                case R.id.ll_reset_question_activity_security_center:
                    // TODO: 2016/6/27 修改验证问题

                    break;
                case R.id.ll_reset_phone_verificaion_activity_security_center:
                    // TODO: 2016/6/27 修改手机验证

                    break;
                case R.id.ll_reset_email_activity_security_center:
                    // TODO: 2016/6/27 更换邮箱

                    break;

            }
        }
    };

}
