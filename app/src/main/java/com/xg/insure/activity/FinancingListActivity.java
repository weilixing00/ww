package com.xg.insure.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.xg.insure.R;
import com.xg.insure.adapter.FinancingListActivityVPAdapter;
import com.xg.insure.base.BaseActivity;
import com.xg.insure.common.NoDoubleClickListener;
import com.xg.insure.constant.KeyConstant;
import com.xg.insure.mvp.home.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by server on 2016/6/23.
 * 理财列表
 */
public class FinancingListActivity extends BaseActivity {

    @BindView(R.id.iv_back_header)
    ImageView ivBackHeader;
    @BindView(R.id.tv_title_header)
    TextView tvTitleHeader;
    @BindView(R.id.iv_icon_right_header)
    ImageView ivIconRightHeader;
    @BindView(R.id.tv_right_header)
    TextView tvRightHeader;
    @BindView(R.id.tl_activity_financing_list)
    TabLayout tlActivityFinancingList;

    @BindView(R.id.vp_activity_financing_list)
    ViewPager vpActivityFinancingList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_financing_list);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        tvTitleHeader.setText("理财列表");
        ivBackHeader.setOnClickListener(noDoubleClick);

        vpActivityFinancingList.setAdapter(new FinancingListActivityVPAdapter(getSupportFragmentManager()));
        tlActivityFinancingList.setupWithViewPager(vpActivityFinancingList);
    }


    View.OnClickListener noDoubleClick = new NoDoubleClickListener() {
        @Override
        public void onNoDoubleClick(View v) {
            switch (v.getId()) {
                case R.id.iv_back_header:
                    Intent intent = new Intent(FinancingListActivity.this, MainActivity.class);
                    intent.putExtra(KeyConstant.IntentKeyConstant.MAINACTIIVTY_INDEX, 2);
                    startActivity(intent);
                    break;
            }
        }
    };

}
