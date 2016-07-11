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
import com.xg.insure.mvp.Presenter.BuyActivityPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by server on 2016/6/24.
 */

public class BuyActivity extends BaseActivity {
    @BindView(R.id.iv_back_header)
    ImageView ivBackHeader;
    @BindView(R.id.tv_title_header)
    TextView tvTitleHeader;
    @BindView(R.id.iv_icon_right_header)
    ImageView ivIconRightHeader;
    @BindView(R.id.tv_right_header)
    TextView tvRightHeader;
    @BindView(R.id.tv_expect_year_rate_activity_buy)
    TextView tvExpectYearRateActivityBuy;
    @BindView(R.id.tv_time_limit_activity_buy)
    TextView tvTimeLimitActivityBuy;
    @BindView(R.id.tv_remind_money_activity_buy)
    TextView tvRemindMoneyActivityBuy;
    @BindView(R.id.et_subscribe_money_activity_buy)
    EditText etSubscribeMoneyActivityBuy;
    @BindView(R.id.tv_expect_income_activity_buy)
    TextView tvExpectIncomeActivityBuy;
    @BindView(R.id.bt_sure_subscribe_activity_buy)
    Button btSureSubscribeActivityBuy;
    @BindView(R.id.iv_agree_activity_buy)
    ImageView ivAgreeActivityBuy;
    @BindView(R.id.tv_deal_activity_buy)
    TextView tvDealActivityBuy;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);
        ButterKnife.bind(this);
        BuyActivityPresenter buyActivityPresenter = new BuyActivityPresenter(this);
        initView();
    }

    private void initView() {
        tvTitleHeader.setText("购买");
        ivBackHeader.setOnClickListener(noDoubleClick);
        ivAgreeActivityBuy.setOnClickListener(noDoubleClick);
        tvDealActivityBuy.setOnClickListener(noDoubleClick);
        btSureSubscribeActivityBuy.setOnClickListener(noDoubleClick);

    }

    private boolean isAgreeDeal = false;
    View.OnClickListener noDoubleClick = new NoDoubleClickListener() {
        @Override
        public void onNoDoubleClick(View v) {
            switch (v.getId()) {
                case R.id.iv_back_header:
                    // TODO: 2016/6/24 finish

                    break;
                case R.id.iv_agree_activity_buy:
                    // 切换同意协议图标
                    if (isAgreeDeal) {
                        ivAgreeActivityBuy.setImageResource(R.mipmap.choose_btn2x);
                    } else {
                        ivAgreeActivityBuy.setImageResource(R.mipmap.choose_select_btn2x);
                    }
                    isAgreeDeal = !isAgreeDeal;

                    break;
                case R.id.tv_deal_activity_buy:
                    // TODO: 2016/6/24 协议

                    break;
                case R.id.bt_sure_subscribe_activity_buy:
                    // TODO: 2016/6/24 确认申购

                    break;


            }
        }
    };

}
