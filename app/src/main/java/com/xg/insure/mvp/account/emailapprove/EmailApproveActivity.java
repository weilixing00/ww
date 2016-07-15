package com.xg.insure.mvp.account.emailapprove;

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

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by server on 2016/6/26.
 * 邮箱认证
 */

public class EmailApproveActivity extends BaseActivity implements EmailApproveContract.IEmailApproveView{
    @BindView(R.id.iv_back_header)
    ImageView ivBackHeader;
    @BindView(R.id.tv_title_header)
    TextView tvTitleHeader;
    @BindView(R.id.iv_icon_right_header)
    ImageView ivIconRightHeader;
    @BindView(R.id.tv_right_header)
    TextView tvRightHeader;
    @BindView(R.id.et_email_address_activity_email_approve)
    EditText etEmailAddressActivityResetEmailApprove;
    @BindView(R.id.et_email_verification_code_activity_email_approve)
    EditText etEmailVerificationCodeActivityResetEmailApprove;
    @BindView(R.id.tv_obtain_verification_code_activity_email_approve)
    TextView tvObtainVerificationCodeActivityResetEmailApprove;
    @BindView(R.id.bt_sure_activity_email_approve)
    Button btSureActivityResetEmailApprove;
    private EmailApprovePresenter emailApprovePresenter;
    private TimeCountUtil timeCountUtil;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_approve);
        ButterKnife.bind(this);
        initView();
        emailApprovePresenter = new EmailApprovePresenter(this);
        timeCountUtil = new TimeCountUtil(this,60000,1000,tvObtainVerificationCodeActivityResetEmailApprove);
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
                    obtainMsgCode();
                    break;
                case R.id.bt_sure_activity_email_approve:
                    // TODO: 2016/6/26  确认
                    emailApprove();

                    break;
                default:
                    throw  new RuntimeException("邮箱认证Activity找不到对应ID");
            }
        }
    };

    private void emailApprove() {
        String emailAddress = etEmailAddressActivityResetEmailApprove.getText().toString().trim();

        String msgCode = etEmailVerificationCodeActivityResetEmailApprove.getText().toString().trim();
        if (TextUtils.isEmpty(emailAddress)){
            JUtils.Toast("请输入邮箱地址");
            return;
        }
        if (TextUtils.isEmpty(msgCode)){
            JUtils.Toast("请输入验证码");
            return;
        }

        //正则表达式验证邮箱地址


        //验证邮箱验证码
        if (msgCode.length()!=6){
            JUtils.Toast("邮箱验证码错误");
            return;
        }
        emailApprovePresenter.emailApprove(emailAddress,msgCode);



    }

    private void obtainMsgCode() {
        String emailAddress = etEmailVerificationCodeActivityResetEmailApprove.getText().toString().trim();
        if (TextUtils.isEmpty(emailAddress)){
            JUtils.Toast("请输入邮箱地址");
            return;
        }
        // TODO: 2016/7/15 正则表达式验证邮箱
//        if (MathUtil.)

        emailApprovePresenter.obtainMsgCode(emailAddress);
    }

    @Override
    public void onObtainMsgCodeSuccess() {
        timeCountUtil.start();

    }

    @Override
    public void onObtainMsgCodeFail() {

    }

    @Override
    public void onApproveSuccess() {

    }

    @Override
    public void onApproveFail() {

    }
}
