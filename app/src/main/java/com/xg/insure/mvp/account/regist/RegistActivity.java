package com.xg.insure.mvp.account.regist;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.xg.insure.R;
import com.xg.insure.mvp.account.login.LoginActivity;
import com.xg.insure.base.BaseActivity;
import com.xg.insure.common.NoDoubleClickListener;
import com.xg.insure.ui.TimeCountUtil;
import com.xg.insure.util.JUtils;
import com.xg.insure.util.MathUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by server on 2016/6/27.
 * 注册页面
 */

public class RegistActivity extends BaseActivity implements RegistContract.IRegistView {
    @BindView(R.id.iv_back_header)
    ImageView ivBackHeader;
    @BindView(R.id.tv_title_header)
    TextView tvTitleHeader;
    @BindView(R.id.iv_icon_right_header)
    ImageView ivIconRightHeader;
    @BindView(R.id.tv_right_header)
    TextView tvRightHeader;
    @BindView(R.id.et_phonenum_activity_regist)
    EditText etPhoneNumActivityRegist;
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
    private RegistPresenter registPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        ButterKnife.bind(this);
        initView();

        registPresenter = new RegistPresenter(this);
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

    //同意协议 图标默认为勾选状态
    private boolean isAgreeDeal = true;

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
                    obtainMsgCode();

                    break;

                case R.id.tv_deal_activity_regist:
                    // TODO: 2016/6/27  浙商用户协议

                    break;
                case R.id.bt_regist_activity_regist:
                    // TODO: 2016/6/27 免费注册
                    regist();

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

    private void obtainMsgCode() {
        String phoneMum = etPhoneNumActivityRegist.getText().toString();
        if (TextUtils.isEmpty(phoneMum)) {
            JUtils.Toast("手机号不能为空");
            return;
        }
        registPresenter.obtainMsgCode(phoneMum);

    }

    //注册
    private void regist() {
        //邀请码
        String inveteCode = etInviteCodeActivityRegist.getText().toString();
        //登录密码
        String loginPsw = etLoginPswActivityRegist.getText().toString();
        //注册手机号
        String phoneNum = etPhoneNumActivityRegist.getText().toString();
        //短信验证码
        String msgCode = etVerificationCodeActivityRegist.getText().toString();
        //确认密码
        String makeSurePsw = etMekasureLoginPswActivityRegist.getText().toString();
        if (TextUtils.isEmpty(phoneNum)) {
            Toast.makeText(this, "手机号码不能为空，请输入", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(msgCode)) {
            Toast.makeText(this, "验证码不能为空，请输入", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(loginPsw)) {
            Toast.makeText(this, "密码不能为空，请输入", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(makeSurePsw)) {
            Toast.makeText(this, "请输入确认密码", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!MathUtil.phoneNumFilter(phoneNum)) {
            Toast.makeText(this, "请输入正确的手机号", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!loginPsw.equals(makeSurePsw)) {
            Toast.makeText(this, "两次密码不一致", Toast.LENGTH_SHORT).show();
            return;
        }
        if (msgCode.length() != 6) {
            Toast.makeText(this, "请输入正确的短信验证码", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!MathUtil.pswFilter(loginPsw)){
            JUtils.Toast("密码为6-15位字母、标点符号、数字至少包含2种");
            return;
        }
        //未同意协议
        if (!isAgreeDeal) {
            Toast.makeText(this, "请阅读并同意《浙商用户协议》", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO: 2016/7/14 RegistParameterBean 构造方法中写入传递参数
        RegistParameterBean registParameter = new RegistParameterBean();

        registPresenter.regist(registParameter);

    }


    @Override
    public void onRegistSuccess() {

    }

    @Override
    public void onRegistError(String error) {
        JUtils.Toast(error);
    }

    @Override
    public void onNetError() {
        JUtils.Toast("网络连接错误");
    }

    /**
     * 获取验证码成功
     */
    @Override
    public void onObtainMsgSuccess() {
        timeCountUtil.start();

    }

    @Override
    public void onObtainMsgError(String error) {
        JUtils.Toast("验证码错误，请核实正确后输入");
    }
}
