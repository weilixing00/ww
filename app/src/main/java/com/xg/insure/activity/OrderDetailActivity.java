package com.xg.insure.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xg.insure.R;
import com.xg.insure.base.BaseActivity;
import com.xg.insure.common.NoDoubleClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by server on 2016/6/23.
 */

public class OrderDetailActivity extends BaseActivity {
    @BindView(R.id.iv_back_header)
    ImageView ivBackHeader;
    @BindView(R.id.tv_title_header)
    TextView tvTitleHeader;
    @BindView(R.id.iv_icon_right_header)
    ImageView ivIconRightHeader;
    @BindView(R.id.tv_right_header)
    TextView tvRightHeader;
    @BindView(R.id.tv_status_activity_order_detail)
    TextView tvStatusActivityOrderDetail;
    @BindView(R.id.tv_order_capital_activity_order_detail)
    TextView tvOrderCapitalActivityOrderDetail;
    @BindView(R.id.tv_interest_activity_order_detail)
    TextView tvInterestActivityOrderDetail;
    @BindView(R.id.tv_year_rate_activity_order_detail)
    TextView tvYearRateActivityOrderDetail;
    @BindView(R.id.tv_comput_type_activity_order_detail)
    TextView tvComputTypeActivityOrderDetail;
    @BindView(R.id.ll_watch_original_project_activity_order_detail)
    LinearLayout llWatchOriginalProjectActivityOrderDetail;
    @BindView(R.id.bt_pay_activity_order_detail)
    Button btPayActivityOrderDetail;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        tvTitleHeader.setText("订单详情");
        ivBackHeader.setOnClickListener(noDoubleClick);
        tvRightHeader.setVisibility(View.VISIBLE);
        tvRightHeader.setOnClickListener(noDoubleClick);
        llWatchOriginalProjectActivityOrderDetail.setOnClickListener(noDoubleClick);
        btPayActivityOrderDetail.setOnClickListener(noDoubleClick);
    }
    View.OnClickListener noDoubleClick=new NoDoubleClickListener() {
        @Override
        public void onNoDoubleClick(View v) {
            switch (v.getId()){
                case R.id.iv_back_header:
                    // TODO: 2016/6/23 返回箭头
                    break;
                case R.id.tv_right_header:
                    // TODO: 2016/6/23 协议
                    break;
                case R.id.ll_watch_original_project_activity_order_detail:
                    // TODO: 2016/6/23  查看原项目
                    break;
                case R.id.bt_pay_activity_order_detail:
                    // TODO: 2016/6/23 支付
                    break;
            }
        }
    };

}
