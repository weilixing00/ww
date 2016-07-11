package com.xg.insure.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xg.insure.R;
import com.xg.insure.base.BaseActivity;
import com.xg.insure.common.NoDoubleClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by server on 2016/6/30.
 */

public class AboutUsActivity extends BaseActivity {


    @BindView(R.id.iv_back_header)
    ImageView ivBackHeader;
    @BindView(R.id.tv_title_header)
    TextView tvTitleHeader;
    @BindView(R.id.iv_icon_right_header)
    ImageView ivIconRightHeader;
    @BindView(R.id.tv_right_header)
    TextView tvRightHeader;
    @BindView(R.id.ll_introduce_activity_about_us)
    LinearLayout llIntroduceActivityAboutUs;
    @BindView(R.id.ll_safe_ensure_activity_about_us)
    LinearLayout llSafeEnsureActivityAboutUs;
    @BindView(R.id.ll_web_affiche_activity_about_us)
    LinearLayout llWebAfficheActivityAboutUs;
    @BindView(R.id.ll_media_activity_about_us)
    LinearLayout llMediaActivityAboutUs;
    @BindView(R.id.ll_cost_activity_about_us)
    LinearLayout llCostActivityAboutUs;
    @BindView(R.id.ll_about_us_activity_about_us)
    LinearLayout llAboutUsActivityAboutUs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        tvTitleHeader.setText("关于我们");
        ivBackHeader.setOnClickListener(noDoubleClick);
        llAboutUsActivityAboutUs.setOnClickListener(noDoubleClick);
        llCostActivityAboutUs.setOnClickListener(noDoubleClick);
        llIntroduceActivityAboutUs.setOnClickListener(noDoubleClick);
        llMediaActivityAboutUs.setOnClickListener(noDoubleClick);
        llSafeEnsureActivityAboutUs.setOnClickListener(noDoubleClick);
        llWebAfficheActivityAboutUs.setOnClickListener(noDoubleClick);
    }
    View.OnClickListener noDoubleClick=new NoDoubleClickListener() {
        @Override
        public void onNoDoubleClick(View v) {
            switch (v.getId()){
                case R.id.iv_back_header:
                    // TODO: 2016/6/30 finish

                    break;
                case R.id.ll_introduce_activity_about_us:
                    // TODO: 2016/6/30  平台介绍

                    break;
                case R.id.ll_safe_ensure_activity_about_us:
                    // TODO: 2016/6/30 安全保障

                    break;
                case R.id.ll_web_affiche_activity_about_us:
                    // TODO: 2016/6/30 网站公告

                    break;
                case R.id.ll_media_activity_about_us:
                    // TODO: 2016/6/30 媒体报道

                    break;
                case R.id.ll_cost_activity_about_us:
                    // TODO: 2016/6/30 资费说明

                    break;
                case R.id.ll_about_us_activity_about_us:
                    // TODO: 2016/6/30 关于我们

                    break;
                default:
                    throw new RuntimeException("AboutUsActivity 找不到对应资源文件");
            }
        }
    };

}
