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
 * 修改手机认证  第二步
 */

public class ResetPhoneCeritification2Activity extends BaseActivity {
    @BindView(R.id.iv_back_header)
    ImageView ivBackHeader;
    @BindView(R.id.tv_title_header)
    TextView tvTitleHeader;
    @BindView(R.id.iv_icon_right_header)
    ImageView ivIconRightHeader;
    @BindView(R.id.tv_right_header)
    TextView tvRightHeader;
    @BindView(R.id.et_identity_num_actiivty_reset_phone_certification2)
    EditText etIdentityNumActiivtyResetPhoneCertification2;
    @BindView(R.id.et_msg_code_actiivty_reset_phone_certification2)
    EditText etMsgCodeActiivtyResetPhoneCertification2;
    @BindView(R.id.tv_obtain_msg_code_actiivty_reset_phone_certification2)
    TextView tvObtainMsgCodeActiivtyResetPhoneCertification2;
    @BindView(R.id.bt_sure_step_actiivty_reset_phone_certification2)
    Button btSureStepActiivtyResetPhoneCertification2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_phone_ceritification2);
        ButterKnife.bind(this);
        initView();
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

                    break;
                case R.id.bt_sure_step_actiivty_reset_phone_certification2:
                    // TODO: 2016/7/5 确定

                    break;

            }
        }
    };

}
