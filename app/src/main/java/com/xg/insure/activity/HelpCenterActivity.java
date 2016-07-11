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
 * Created by server on 2016/7/1.
 */

public class HelpCenterActivity extends BaseActivity {

    @BindView(R.id.iv_back_header)
    ImageView ivBackHeader;
    @BindView(R.id.tv_title_header)
    TextView tvTitleHeader;
    @BindView(R.id.iv_icon_right_header)
    ImageView ivIconRightHeader;
    @BindView(R.id.tv_right_header)
    TextView tvRightHeader;
    @BindView(R.id.ll_regist_and_login_activity_help_center)
    LinearLayout llRegistAndLoginActivityHelpCenter;
    @BindView(R.id.ll_real_name_activity_help_center)
    LinearLayout llRealNameActivityHelpCenter;
    @BindView(R.id.ll_scribe_question_activity_help_center)
    LinearLayout llScribeQuestionActivityHelpCenter;
    @BindView(R.id.ll_safe_question_activity_help_center)
    LinearLayout llSafeQuestionActivityHelpCenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_center);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        tvTitleHeader.setText("帮助中心");
        ivBackHeader.setOnClickListener(noDoubleClick);
    }
    View.OnClickListener noDoubleClick=new NoDoubleClickListener() {
        @Override
        public void onNoDoubleClick(View v) {
            switch (v.getId()){
                case R.id.iv_back_header:
                    // TODO: 2016/7/1 finish

                    break;
                case R.id.ll_regist_and_login_activity_help_center:
                    // TODO: 2016/7/1 注册登录

                    break;
                case R.id.ll_real_name_activity_help_center:
                    // TODO: 2016/7/1  实名认证

                    break;
                case R.id.ll_scribe_question_activity_help_center:
                    // TODO: 2016/7/1 申购问题

                    break;
                case R.id.ll_safe_question_activity_help_center:
                    // TODO: 2016/7/1 安全问题

                    break;
                default:
                    throw new RuntimeException("HelpCenterActivity 找不到对应资源ID");
            }
        }
    };

}
