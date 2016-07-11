package com.xg.insure.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.xg.insure.R;
import com.xg.insure.base.BaseActivity;
import com.xg.insure.common.NoDoubleClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by server on 2016/6/27.
 * 银行卡
 * 如果没有银行卡  llAddBankcardActivityBankcard 显示   elvActivityBankcard 不显示
 * 如果有银行卡   llAddBankcardActivityBankcard 不显示  elvActivityBankcard 显示
 */

public class BankCardActivity extends BaseActivity {
    @BindView(R.id.iv_back_header)
    ImageView ivBackHeader;
    @BindView(R.id.tv_title_header)
    TextView tvTitleHeader;
    @BindView(R.id.iv_icon_right_header)
    ImageView ivIconRightHeader;
    @BindView(R.id.tv_right_header)
    TextView tvRightHeader;
    @BindView(R.id.ll_add_bankcard_activity_bankcard)
    LinearLayout llAddBankcardActivityBankcard;
    @BindView(R.id.elv_activity_bankcard)
    EasyRecyclerView elvActivityBankcard;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bankcard);
        ButterKnife.bind(this);
        initView();

    }

    private void initView() {
        tvTitleHeader.setText("银行卡");
        ivBackHeader.setOnClickListener(noDoubleClick);
    }
    View.OnClickListener noDoubleClick=new NoDoubleClickListener() {
        @Override
        public void onNoDoubleClick(View v) {
            switch (v.getId()){
                case R.id.iv_back_header:
                    // TODO: 2016/6/27 finish

                    break;
                case R.id.ll_add_bankcard_activity_bankcard:
                    // TODO: 2016/6/27 添加银行卡

                    break;


                default:
                    throw new RuntimeException("BankCardActivity找不到对应资源ID");
            }
        }
    };

}
