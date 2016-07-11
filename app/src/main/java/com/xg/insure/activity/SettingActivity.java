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
import com.xg.insure.fragment.VersionUpdateDialogFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by server on 2016/6/26.
 * 设置
 */

public class SettingActivity extends BaseActivity {

    @BindView(R.id.iv_back_header)
    ImageView ivBackHeader;
    @BindView(R.id.tv_title_header)
    TextView tvTitleHeader;
    @BindView(R.id.iv_icon_right_header)
    ImageView ivIconRightHeader;
    @BindView(R.id.tv_right_header)
    TextView tvRightHeader;
    @BindView(R.id.imageView2)
    ImageView imageView2;
    @BindView(R.id.ll_about_us_activity_setting)
    LinearLayout llAboutUsActivitySetting;
    @BindView(R.id.ll_help_center_activity_setting)
    LinearLayout llHelpCenterActivitySetting;
    @BindView(R.id.iv_download_wifi_activity_setting)
    ImageView ivDownloadWifiActivitySetting;
    @BindView(R.id.textView3)
    TextView textView3;
    @BindView(R.id.tv_version_name_activity_setting)
    TextView tvVersionNameActivitySetting;
    @BindView(R.id.ll_current_version_activity_setting)
    LinearLayout llCurrentVersionActivitySetting;
    @BindView(R.id.tv_exit_activity_setting)
    TextView tvExitActivitySetting;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        tvTitleHeader.setText("设置");
        ivBackHeader.setOnClickListener(noDoubleClick);
        tvExitActivitySetting.setOnClickListener(noDoubleClick);
        llCurrentVersionActivitySetting.setOnClickListener(noDoubleClick);
        llAboutUsActivitySetting.setOnClickListener(noDoubleClick);
        llHelpCenterActivitySetting.setOnClickListener(noDoubleClick);
        ivDownloadWifiActivitySetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 2016/6/30  wifi下自动下载新版本
                if (isAutoDownLoadWifi){
                    ivDownloadWifiActivitySetting.setImageResource(R.mipmap.close_img);
                }
                else {
                    ivDownloadWifiActivitySetting.setImageResource(R.mipmap.open_img);
                }
                isAutoDownLoadWifi=!isAutoDownLoadWifi;

            }
        });
    }

    private boolean isAutoDownLoadWifi=false;
    View.OnClickListener noDoubleClick = new NoDoubleClickListener() {
        @Override
        public void onNoDoubleClick(View v) {
            switch (v.getId()) {
                case R.id.iv_back_header:
                    // TODO: 2016/6/26 finish

                    break;
                case R.id.ll_about_us_activity_setting:
                    // TODO: 2016/6/30 关于我们

                    break;
                case R.id.ll_help_center_activity_setting:
                    // TODO: 2016/6/30 帮助中心

                    break;

                case R.id.ll_current_version_activity_setting:
                    // TODO: 2016/6/30 当前版本 （检查新版本）
                    VersionUpdateDialogFragment versionUpdateDialogFragment = VersionUpdateDialogFragment.newInstance();
                    versionUpdateDialogFragment.show(getSupportFragmentManager(),null);

                    break;
                case R.id.tv_exit_activity_setting:
                    // TODO: 2016/6/30 安全退出

                    break;
                default:
                    throw new RuntimeException("SettingActivity 找不到对应资源ID");
            }
        }
    };

}
