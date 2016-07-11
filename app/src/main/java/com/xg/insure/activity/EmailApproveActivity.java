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
 * 邮箱认证
 */

public class EmailApproveActivity extends BaseActivity {
    @BindView(R.id.iv_back_header)
    ImageView ivBackHeader;
    @BindView(R.id.tv_title_header)
    TextView tvTitleHeader;
    @BindView(R.id.iv_icon_right_header)
    ImageView ivIconRightHeader;
    @BindView(R.id.tv_right_header)
    TextView tvRightHeader;
    @BindView(R.id.et_new_email_address_activity_email_approve)
    EditText etNewEmailAddressActivityResetEmailApprove;
    @BindView(R.id.et_email_verification_code_activity_email_approve)
    EditText etEmailVerificationCodeActivityResetEmailApprove;
    @BindView(R.id.tv_obtain_verification_code_activity_email_approve)
    TextView tvObtainVerificationCodeActivityResetEmailApprove;
    @BindView(R.id.bt_sure_activity_email_approve)
    Button btSureActivityResetEmailApprove;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_approve);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        tvTitleHeader.setText("邮箱认证");
        ivBackHeader.setOnClickListener(noDoubleClick);
        tvObtainVerificationCodeActivityResetEmailApprove.setOnClickListener(noDoubleClick);
        btSureActivityResetEmailApprove.setOnClickListener(noDoubleClick);
    }


    View.OnClickListener noDoubleClick=new NoDoubleClickListener() {
        @Override
        public void onNoDoubleClick(View v) {
            switch (v.getId()){
                case R.id.iv_back_header:
                    // TODO: 2016/6/26 finish

                    break;
                case R.id.tv_obtain_verification_code_activity_email_approve:
                    // TODO: 2016/6/26 获取验证码

                    break;
                case R.id.bt_sure_activity_email_approve:
                    // TODO: 2016/6/26  确认

                    break;
                default:
                    throw  new RuntimeException("邮箱认证Activity找不到对应ID");


            }
        }
    };

}
