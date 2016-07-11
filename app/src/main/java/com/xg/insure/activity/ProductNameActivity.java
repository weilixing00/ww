package com.xg.insure.activity;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.xg.insure.R;
import com.xg.insure.base.BaseActivity;
import com.xg.insure.common.NoDoubleClickListener;
import com.xg.insure.fragment.FinancingCalculatorDialogFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.iwgang.countdownview.CountdownView;

/**
 * Created by server on 2016/6/22.
 */

public class ProductNameActivity extends BaseActivity {


    @BindView(R.id.iv_back_activity_product_name)
    ImageView ivBackActivityProductName;

    @BindView(R.id.tv_expect_year_rate_activity_product_name)
    TextView tvExpectYearRateActivityProductName;
    @BindView(R.id.tv_collect_money_activity_product_name)
    TextView tvCollectMoneyActivityProductName;
    @BindView(R.id.tv_deadtime_activity_product_name)
    TextView tvDeadtimeActivityProductName;
    @BindView(R.id.tv_collect_deadtime_activity_product_name)
    TextView tvCollectDeadtimeActivityProductName;
    @BindView(R.id.countview_activity_product_name)
    CountdownView countviewActivityProductName;
    @BindView(R.id.tv_start_interest_date_activity_product_name)
    TextView tvStartInterestDateActivityProductName;
    @BindView(R.id.tv_remind_money_activity_product_name)
    TextView tvRemindMoneyActivityProductName;
    @BindView(R.id.tv_expire_date_activity_product_name)
    TextView tvExpireDateActivityProductName;
    @BindView(R.id.tv_interest_type_activity_product_name)
    TextView tvInterestTypeActivityProductName;
    @BindView(R.id.tv_product_introduce_activity_product_name)
    TextView tvProductIntroduceActivityProductName;
    @BindView(R.id.tv_financing_introduce_activity_product_name)
    TextView tvFinancingIntroduceActivityProductName;
    @BindView(R.id.tv_issuing_agenecy_introduce_activity_product_name)
    TextView tvIssuingAgenecyIntroduceActivityProductName;
    @BindView(R.id.tv_add_credit_measure_activity_product_name)
    TextView tvAddCreditMeasureActivityProductName;
    @BindView(R.id.ll_risk_prompt_activity_product_name)
    LinearLayout llRiskPromptActivityProductName;
    @BindView(R.id.ll_disclaimer_announce_activity_product_name)
    LinearLayout llDisclaimerAnnounceActivityProductName;
    @BindView(R.id.ll_product_declare_activity_product_name)
    LinearLayout llProductDeclareActivityProductName;
    @BindView(R.id.iv_calculator_activity_product_name)
    ImageView ivCalculatorActivityProductName;
    @BindView(R.id.bt_subscribe_activity_product_name)
    Button btSubscribeActivityProductName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_name);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        //设置状态栏默认颜色
        initStatusBarColor();

        ivBackActivityProductName.setOnClickListener(noDoubleClick);
        ivCalculatorActivityProductName.setOnClickListener(noDoubleClick);
        llDisclaimerAnnounceActivityProductName.setOnClickListener(noDoubleClick);
        llProductDeclareActivityProductName.setOnClickListener(noDoubleClick);
        llRiskPromptActivityProductName.setOnClickListener(noDoubleClick);
        btSubscribeActivityProductName.setOnClickListener(noDoubleClick);

    }

    View.OnClickListener noDoubleClick = new NoDoubleClickListener() {
        @Override
        public void onNoDoubleClick(View v) {
            switch (v.getId()) {
                case R.id.iv_back_activity_product_name:
                    // TODO: 2016/6/30 finish

                    break;
                case R.id.iv_calculator_activity_product_name:
                    // TODO: 2016/6/30 计算器
                    FinancingCalculatorDialogFragment financingCalculatorDialogFragment = FinancingCalculatorDialogFragment.newInstance(null);
                    financingCalculatorDialogFragment.show(getSupportFragmentManager(), null);
                    break;
                case R.id.ll_risk_prompt_activity_product_name:
                    // TODO: 2016/6/30 风险提示

                    break;
                case R.id.ll_disclaimer_announce_activity_product_name:
                    // TODO: 2016/6/30 免责声明

                    break;
                case R.id.ll_product_declare_activity_product_name:
                    // TODO: 2016/6/30 产品说明书

                    break;
                case R.id.bt_subscribe_activity_product_name:
                    // TODO: 2016/6/30 立即申购

                    break;
                default:
                    throw new RuntimeException("ProductNameActivity 找不到对应资源Id");
            }
        }
    };


    private void initStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setTintColor(Color.parseColor("#E75255"));
        }
    }


    @TargetApi(19)
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }
}
