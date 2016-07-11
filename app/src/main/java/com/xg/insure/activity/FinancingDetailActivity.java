package com.xg.insure.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xg.insure.R;
import com.xg.insure.base.BaseActivity;
import com.xg.insure.common.NoDoubleClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by server on 2016/7/6.
 */

public class FinancingDetailActivity extends BaseActivity {

    @BindView(R.id.iv_back_header)
    ImageView ivBackHeader;
    @BindView(R.id.tv_title_header)
    TextView tvTitleHeader;
    @BindView(R.id.iv_icon_right_header)
    ImageView ivIconRightHeader;
    @BindView(R.id.tv_right_header)
    TextView tvRightHeader;
    @BindView(R.id.tv_product_name_activity_financing_detail)
    TextView tvProductNameActivityFinancingDetail;
    @BindView(R.id.tv_status_activity_financing_detail)
    TextView tvStatusActivityFinancingDetail;
    @BindView(R.id.tv_sucribe_capital_activity_financing_detail)
    TextView tvSucribeCapitalActivityFinancingDetail;
    @BindView(R.id.tv_callback_capital_interest_activity_financing_detail)
    TextView tvCallbackCapitalInterestActivityFinancingDetail;
    @BindView(R.id.tv_year_rate_activity_financing_detail)
    TextView tvYearRateActivityFinancingDetail;
    @BindView(R.id.tv_comput_type_activity_financing_detail)
    TextView tvComputTypeActivityFinancingDetail;
    @BindView(R.id.tv_start_interest_date_activity_financing_detail)
    TextView tvStartInterestDateActivityFinancingDetail;
    @BindView(R.id.tv_deadtime_activity_financing_detail)
    TextView tvDeadtimeActivityFinancingDetail;
    @BindView(R.id.rl_originablity_project_activity_financing_detail)
    RelativeLayout rlOriginablityProjectActivityFinancingDetail;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_financing_detail);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        tvTitleHeader.setText("理财详情");
        tvRightHeader.setVisibility(View.VISIBLE);
        tvRightHeader.setText("协议");
        tvRightHeader.setOnClickListener(noDoubleClick);
        ivBackHeader.setOnClickListener(noDoubleClick);
        rlOriginablityProjectActivityFinancingDetail.setOnClickListener(noDoubleClick);
    }
    View.OnClickListener noDoubleClick=new NoDoubleClickListener() {
        @Override
        public void onNoDoubleClick(View v) {
            switch (v.getId()){
                case R.id.iv_back_header:
                    // TODO: 2016/7/6 finish

                    break;
                case R.id.tv_right_header:
                    // TODO: 2016/7/6 协议

                    break;
                case R.id.rl_originablity_project_activity_financing_detail:
                    // TODO: 2016/7/6 查看原项目

                    break;

            }
        }
    };

}
