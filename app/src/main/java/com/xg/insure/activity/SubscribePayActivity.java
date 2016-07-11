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
 * Created by server on 2016/6/23.
 */

public class SubscribePayActivity extends BaseActivity {
    @BindView(R.id.iv_back_header)
    ImageView ivBackHeader;
    @BindView(R.id.tv_title_header)
    TextView tvTitleHeader;
    @BindView(R.id.iv_icon_right_header)
    ImageView ivIconRightHeader;
    @BindView(R.id.tv_right_header)
    TextView tvRightHeader;
    @BindView(R.id.tv_pay_amount_activity_pay)
    TextView tvPayAmountActivityPay;
    @BindView(R.id.tv_bank_card_activity_pay)
    TextView tvBankCardActivityPay;
    @BindView(R.id.tv_tail_number_activity_pay)
    TextView tvTailNumberActivityPay;
    @BindView(R.id.textView5)
    TextView textView5;
    @BindView(R.id.et_pay_psw_activity_pay)
    EditText etPayPswActivityPay;
    @BindView(R.id.bt_sure_activity_pay)
    Button btSureActivityPay;
    @BindView(R.id.tv_raminder_month_activity_pay)
    TextView tvRaminderMonthActivityPay;
    @BindView(R.id.tv_raminder_day_activity_pay)
    TextView tvRaminderDayActivityPay;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscribe_pay);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        tvTitleHeader.setText("支付");
        ivBackHeader.setOnClickListener(noDoubleClick);
        btSureActivityPay.setOnClickListener(noDoubleClick);
    }
    View.OnClickListener noDoubleClick=new NoDoubleClickListener() {
        @Override
        public void onNoDoubleClick(View v) {
            switch (v.getId()){
                case R.id.iv_back_header:
                    // TODO: 2016/6/23 finish
                    break;
                case R.id.bt_sure_activity_pay:
                    // TODO: 2016/6/23 确定按钮
                    break;

            }
        }
    };

}
