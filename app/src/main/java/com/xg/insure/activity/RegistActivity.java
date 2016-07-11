package com.xg.insure.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xg.insure.R;
import com.xg.insure.base.BaseActivity;
import com.xg.insure.common.NoDoubleClickListener;
import com.xg.insure.ui.TimeCountUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by server on 2016/6/27.
 */

public class RegistActivity extends BaseActivity {
    @BindView(R.id.iv_back_header)
    ImageView ivBackHeader;
    @BindView(R.id.tv_title_header)
    TextView tvTitleHeader;
    @BindView(R.id.iv_icon_right_header)
    ImageView ivIconRightHeader;
    @BindView(R.id.tv_right_header)
    TextView tvRightHeader;
    @BindView(R.id.et_phonenum_activity_regist)
    EditText etPhonenumActivityRegist;
    @BindView(R.id.et_verification_code_activity_regist)
    EditText etVerificationCodeActivityRegist;
    @BindView(R.id.tv_obtain_verification_code_activity_regist)
    TextView tvObtainVerificationCodeActivityRegist;
    @BindView(R.id.et_login_psw_activity_regist)
    EditText etLoginPswActivityRegist;
    @BindView(R.id.et_mekasure_login_psw_activity_regist)
    EditText etMekasureLoginPswActivityRegist;
    @BindView(R.id.et_invite_code_activity_regist)
    EditText etInviteCodeActivityRegist;
    @BindView(R.id.iv_agree_deal_activity_regist)
    ImageView ivAgreeDealActivityRegist;
    @BindView(R.id.tv_deal_activity_regist)
    TextView tvDealActivityRegist;
    @BindView(R.id.bt_regist_activity_regist)
    Button btRegistActivityRegist;
    @BindView(R.id.ll_login_activity_regist)
    LinearLayout llLoginActivityRegist;
    private TimeCountUtil timeCountUtil;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        ButterKnife.bind(this);
        initView();

    }


    private void initView() {
        timeCountUtil = new TimeCountUtil(this, 60000, 1000, tvObtainVerificationCodeActivityRegist);
        tvTitleHeader.setText("注册");
        ivBackHeader.setOnClickListener(noDoubleClick);
        btRegistActivityRegist.setOnClickListener(noDoubleClick);
        tvObtainVerificationCodeActivityRegist.setOnClickListener(noDoubleClick);
        tvDealActivityRegist.setOnClickListener(noDoubleClick);
        llLoginActivityRegist.setOnClickListener(noDoubleClick);
        ivAgreeDealActivityRegist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 图标 同意协议
                if (isAgreeDeal) {
                    ivAgreeDealActivityRegist.setImageResource(R.mipmap.choose_btn2x);
                } else {
                    ivAgreeDealActivityRegist.setImageResource(R.mipmap.choose_select_btn2x);
                }
                isAgreeDeal = !isAgreeDeal;
            }
        });
    }

    private boolean isAgreeDeal = false;

    View.OnClickListener noDoubleClick = new NoDoubleClickListener() {
        @Override
        public void onNoDoubleClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.iv_back_header:
                    // TODO: 2016/6/27 finish

                    break;


                case R.id.tv_obtain_verification_code_activity_regist:
                    // TODO: 2016/6/27 获取验证码
                    timeCountUtil.start();

                    break;

                case R.id.tv_deal_activity_regist:
                    // TODO: 2016/6/27  浙商用户协议

                    break;
                case R.id.bt_regist_activity_regist:
                    // TODO: 2016/6/27 免费注册


                    break;
                case R.id.ll_login_activity_regist:
                    // TODO: 2016/6/27 已是会员 直接登录
                    intent = new Intent(RegistActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                    break;
                default:
                    throw new RuntimeException("RegistActivity找不到对应资源ID");
            }
        }
    };

}
