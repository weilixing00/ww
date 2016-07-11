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
 * Created by server on 2016/7/5.
 * 修改登录密码
 */

public class ResetLoginPSWActivity extends BaseActivity {


    @BindView(R.id.iv_back_header)
    ImageView ivBackHeader;
    @BindView(R.id.tv_title_header)
    TextView tvTitleHeader;
    @BindView(R.id.iv_icon_right_header)
    ImageView ivIconRightHeader;
    @BindView(R.id.tv_right_header)
    TextView tvRightHeader;
    @BindView(R.id.et_originality_login_psw_activity_reset_login_psw)
    EditText etOriginalityLoginPswActivityResetLoginPsw;
    @BindView(R.id.et_set_new_login_psw_activity_reset_login_psw)
    EditText etSetNewLoginPswActivityResetLoginPsw;
    @BindView(R.id.et_comfirm_new_psw_activity_reset_login_psw)
    EditText etComfirmNewPswActivityResetLoginPsw;
    @BindView(R.id.bt_sure_activity_reset_login_psw)
    Button btSureActivityResetLoginPsw;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_login_psw);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        tvTitleHeader.setText("修改登录密码");
        ivBackHeader.setOnClickListener(noDoubleClick);
        btSureActivityResetLoginPsw.setOnClickListener(noDoubleClick);
    }

    View.OnClickListener noDoubleClick = new NoDoubleClickListener() {
        @Override
        public void onNoDoubleClick(View v) {
            switch (v.getId()) {
                case R.id.iv_back_header:
                    // TODO: 2016/7/5 finish

                    break;
                case R.id.bt_sure_activity_reset_login_psw:
                    // TODO: 2016/7/5 queding

                    break;

            }
        }
    };

}
