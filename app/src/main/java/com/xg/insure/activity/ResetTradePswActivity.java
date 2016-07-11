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
 * Created by server on 2016/7/6.
 * 重置交易密码
 */

public class ResetTradePswActivity extends BaseActivity {
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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_trade_psw);
        ButterKnife.bind(this);
        initView();
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

                    break;
                case R.id.bt_sure_activity_reset_trade_psw:
                    // TODO: 2016/7/5 确认

                    break;
            }
        }
    };

}
