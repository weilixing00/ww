package com.xg.insure.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.xg.insure.R;
import com.xg.insure.base.BaseActivity;
import com.xg.insure.common.NoDoubleClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by server on 2016/6/26.
 * 修改邮箱认证  第一步
 */

public class ResetEmailApproveStep1Activity extends BaseActivity {


    @BindView(R.id.iv_back_header)
    ImageView ivBackHeader;
    @BindView(R.id.tv_title_header)
    TextView tvTitleHeader;
    @BindView(R.id.iv_icon_right_header)
    ImageView ivIconRightHeader;
    @BindView(R.id.tv_right_header)
    TextView tvRightHeader;
    @BindView(R.id.et_identity_num_activity_reset_email_approve_step1)
    EditText etIdentityNumActivityResetEmailApproveStep1;
    @BindView(R.id.et_email_address_activity_reset_email_approve_step1)
    EditText etEmailAddressActivityResetEmailApproveStep1;
    @BindView(R.id.et_email_verification_code_activity_reset_email_approve_step1)
    EditText etEmailVerificationCodeActivityResetEmailApproveStep1;
    @BindView(R.id.tv_obtain_verification_code_activity_reset_email_approve_step1)
    TextView tvObtainVerificationCodeActivityResetEmailApproveStep1;
    @BindView(R.id.bt_sure_activity_reset_email_approve_step1)
    Button btSureActivityResetEmailApproveStep1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_email_approve_step1);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        tvTitleHeader.setText("修改邮箱验证");
        ivBackHeader.setOnClickListener(noDoubleClick);
        tvObtainVerificationCodeActivityResetEmailApproveStep1.setOnClickListener(noDoubleClick);
        btSureActivityResetEmailApproveStep1.setOnClickListener(noDoubleClick);
    }

    View.OnClickListener noDoubleClick = new NoDoubleClickListener() {
        @Override
        public void onNoDoubleClick(View v) {
            switch (v.getId()) {
                case R.id.iv_back_header:
                    // TODO: 2016/6/26 finish

                    break;
                case R.id.tv_obtain_verification_code_activity_reset_email_approve_step1:
                    // TODO: 2016/6/26 获取验证码

                    break;
                case R.id.bt_sure_activity_reset_email_approve_step1:
                    // TODO: 2016/6/26 下一步

                    break;
                default:
                    throw new RuntimeException("修改邮箱认证找到不到对应资源ID");


            }
        }
    };

}
