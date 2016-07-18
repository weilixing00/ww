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
 * Created by server on 2016/7/6.
 * 重置交易密码
 */

public class ResetTradePswActivity extends BaseActivity  implements TradePswContract.ITradePswView{
    @BindView(R.id.iv_back_header)
    ImageView ivBackHeader;
    @BindView(R.id.tv_title_header)
    TextView tvTitleHeader;
    @BindView(R.id.iv_icon_right_header)
    ImageView ivIconRightHeader;
    @BindView(R.id.tv_right_header)
    TextView tvRightHeader;
    @BindView(R.id.tv_phone_num_activity_reset_trade_psw)
    TextView tvPhoneNumActivityResetTradePsw;
    @BindView(R.id.et_msg_code_activity_reset_trade_psw)
    EditText etMsgCodeActivityResetTradePsw;
    @BindView(R.id.tv_obtain_msg_code_activity_reset_trade_psw)
    TextView tvObtainMsgCodeActivityResetTradePsw;
    @BindView(R.id.et_set_trade_psw_activity_reset_trade_psw)
    EditText etSetTradePswActivityResetTradePsw;
    @BindView(R.id.et_confirm_trade_psw_activity_reset_trade_psw)
    EditText etConfirmTradePswActivityResetTradePsw;
    @BindView(R.id.bt_sure_activity_reset_trade_psw)
    Button btSureActivityResetTradePsw;
    private ResetTradePswPresenter presenter;
    private TimeCountUtil timeCountUtil;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_trade_psw);
        ButterKnife.bind(this);
        initView();
        presenter = new ResetTradePswPresenter(this);
        timeCountUtil = new TimeCountUtil(this,60000,1000,tvObtainMsgCodeActivityResetTradePsw);
    }

    private void initView() {
        tvTitleHeader.setText("重置交易密码");
        ivBackHeader.setOnClickListener(noDoubleClick);
        tvObtainMsgCodeActivityResetTradePsw.setOnClickListener(noDoubleClick);
        btSureActivityResetTradePsw.setOnClickListener(noDoubleClick);
    }
    View.OnClickListener noDoubleClick=new NoDoubleClickListener() {
        @Override
        public void onNoDoubleClick(View v) {
            switch (v.getId()){
                case R.id.iv_back_header:
                    // TODO: 2016/7/6 finish

                    break;
                case R.id.tv_obtain_msg_code_activity_reset_trade_psw:
                    // TODO: 2016/7/5 获取验证码
                    timeCountUtil.start();
                    obtainMsgCode();

                    break;
                case R.id.bt_sure_activity_reset_trade_psw:
                    // TODO: 2016/7/5 确认
                        resetTradePsw();
                    break;
            }
        }
    };

    //确定
    private void resetTradePsw() {
        String msgCode = etMsgCodeActivityResetTradePsw.getText().toString().trim();
        String tradePsw = etSetTradePswActivityResetTradePsw.getText().toString().trim();
        String confirmTradePsw = etConfirmTradePswActivityResetTradePsw.getText().toString().trim();

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

//        presenter.setTradePsw();
    }

    //获取验证码
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
//设置完交易密码，提示“恭喜您，交易密码重置成功！”，页面跳转到安全中心

    }

    @Override
    public void onTradePswFail() {

    }
}
