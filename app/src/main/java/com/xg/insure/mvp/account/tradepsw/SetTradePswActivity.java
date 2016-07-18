package com.xg.insure.mvp.account.tradepsw;

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
 * 设置交易密码
 */

public class SetTradePswActivity extends BaseActivity implements TradePswContract.ITradePswView {
    @BindView(R.id.iv_back_header)
    ImageView ivBackHeader;
    @BindView(R.id.tv_title_header)
    TextView tvTitleHeader;
    @BindView(R.id.iv_icon_right_header)
    ImageView ivIconRightHeader;
    @BindView(R.id.tv_right_header)
    TextView tvRightHeader;
    @BindView(R.id.tv_phone_num_activity_set_trade_psw)
    TextView tvPhoneNumActivitySetTradePsw;
    @BindView(R.id.et_msg_code_activity_set_trade_psw)
    EditText etMsgCodeActivitySetTradePsw;
    @BindView(R.id.tv_obtain_msg_code_activity_set_trade_psw)
    TextView tvObtainMsgCodeActivitySetTradePsw;
    @BindView(R.id.et_set_trade_psw_activity_set_trade_psw)
    EditText etSetTradePswActivitySetTradePsw;
    @BindView(R.id.et_confirm_trade_psw_activity_set_trade_psw)
    EditText etConfirmTradePswActivitySetTradePsw;
    @BindView(R.id.bt_sure_activity_set_trade_psw)
    Button btSureActivitySetTradePsw;
    private SetTradePswPresenter setSetTradePswPresenter;
    private TimeCountUtil timeCountUtil;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_trade_psw);
        ButterKnife.bind(this);
        initView();

        setSetTradePswPresenter = new SetTradePswPresenter(this);
        timeCountUtil = new TimeCountUtil(this,60000,1000,tvObtainMsgCodeActivitySetTradePsw);
    }

    private void initView() {
        tvTitleHeader.setText("设置交易密码");
        tvObtainMsgCodeActivitySetTradePsw.setOnClickListener(noDoubleClick);
        btSureActivitySetTradePsw.setOnClickListener(noDoubleClick);
        ivBackHeader.setOnClickListener(noDoubleClick);
    }

    View.OnClickListener noDoubleClick = new NoDoubleClickListener() {
        @Override
        public void onNoDoubleClick(View v) {
            switch (v.getId()) {
                case R.id.iv_back_header:
                    // TODO: 2016/7/5  finish

                    break;
                case R.id.tv_obtain_msg_code_activity_set_trade_psw:
                    // TODO: 2016/7/5 获取验证码
                    obtainMsgCode();
                    break;
                case R.id.bt_sure_activity_set_trade_psw:
                    // TODO: 2016/7/5 确认
                    setTradePsw();
                    break;
                default:
                    throw new RuntimeException("SetTradePswActivity 没找到对应资源Id");
            }
        }
    };

    //设置交易密码
    private void setTradePsw() {
        String msgCode = etMsgCodeActivitySetTradePsw.getText().toString().trim();
        String tradePsw = etSetTradePswActivitySetTradePsw.getText().toString().trim();
        String confirmTradePsw = etConfirmTradePswActivitySetTradePsw.getText().toString().trim();

        if (TextUtils.isEmpty(msgCode)) {
            JUtils.Toast("请输入验证码");
            return;
        }
        if (TextUtils.isEmpty(tradePsw)) {
            JUtils.Toast("请输入交易密码");
            return;
        }
        if (TextUtils.isEmpty(confirmTradePsw)) {
            JUtils.Toast("请输入确认密码");
            return;
        }
        if (!tradePsw.equals(confirmTradePsw)){
            JUtils.Toast("两次密码不一致");
            return;
        }
        if (MathUtil.pswFilter(tradePsw)){
            JUtils.Toast("密码为6-15位字母、标点符号、数字至少包含2种");
            return;
        }

//        setSetTradePswPresenter.setTradePsw();

    }

    //获取短信验证码
    private void obtainMsgCode() {

    }

    @Override
    public void onObtainMsgCodeSuccess() {
        timeCountUtil.start();

    }

    @Override
    public void onObtainMsgCodeFail() {

    }

    @Override
    public void onNetError() {

    }

    @Override
    public void onTradePswSuccess() {
//设置完交易密码，提示“恭喜您，交易密码设置成功！”，页面跳转到安全中心，安全中心的安全等级进度条增加1/7
        //安全中心 隐藏未设置、设置按钮，显示修改、找回按钮  重置按钮

    }

    @Override
    public void onTradePswFail() {

    }
}
