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
 * Created by server on 2016/7/5.
 * 修改邮箱认证 第二步
 */

public class ResetEmailApproveStep2Activity extends BaseActivity {


    @BindView(R.id.iv_back_header)
    ImageView ivBackHeader;
    @BindView(R.id.tv_title_header)
    TextView tvTitleHeader;
    @BindView(R.id.iv_icon_right_header)
    ImageView ivIconRightHeader;
    @BindView(R.id.tv_right_header)
    TextView tvRightHeader;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.et_new_email_address_activity_reset_email_approve_step2)
    TextView etNewEmailAddressActivityResetEmailApproveStep2;
    @BindView(R.id.et_email_verification_code_activity_reset_email_approve_step2)
    EditText etEmailVerificationCodeActivityResetEmailApproveStep2;
    @BindView(R.id.tv_obtain_verification_code_activity_reset_email_approve_step2)
    TextView tvObtainVerificationCodeActivityResetEmailApproveStep2;
    @BindView(R.id.bt_sure_activity_reset_email_approve_step2)
    Button btSureActivityResetEmailApproveStep2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_email_approve_step2);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        tvTitleHeader.setText("修改邮箱认证");
        ivBackHeader.setOnClickListener(noDoubleClick);

    }
    View.OnClickListener noDoubleClick=new NoDoubleClickListener() {
        @Override
        public void onNoDoubleClick(View v) {
            switch (v.getId()){
                case R.id.iv_back_header:
                    // TODO: 2016/7/5 finish

                    break;
                case R.id.tv_obtain_verification_code_activity_reset_email_approve_step2:
                    // TODO: 2016/7/5 获取验证码

                    break;
                case R.id.bt_sure_activity_reset_email_approve_step2:
                    // TODO: 2016/7/5 确定

                    break;

            }
        }
    };

}
