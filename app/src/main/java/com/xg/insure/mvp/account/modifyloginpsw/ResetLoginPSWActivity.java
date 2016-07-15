package com.xg.insure.mvp.account.modifyloginpsw;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.xg.insure.R;
import com.xg.insure.base.BaseActivity;
import com.xg.insure.common.NoDoubleClickListener;
import com.xg.insure.util.JUtils;
import com.xg.insure.util.MathUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by server on 2016/7/5.
 * 修改登录密码
 */

public class ResetLoginPSWActivity extends BaseActivity implements ResetLoginPswContract.View {


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
    private ResetLoginPswPresenter resetLoginPswPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_login_psw);
        ButterKnife.bind(this);
        initView();
        resetLoginPswPresenter = new ResetLoginPswPresenter(this);
    }

    private void initView() {
        tvTitleHeader.setText("修改登录密码");
        ivBackHeader.setOnClickListener(noDoubleClick);
        btSureActivityResetLoginPsw.setOnClickListener(noDoubleClick);
    }

    android.view.View.OnClickListener noDoubleClick = new NoDoubleClickListener() {
        @Override
        public void onNoDoubleClick(android.view.View v) {
            switch (v.getId()) {
                case R.id.iv_back_header:
                    // TODO: 2016/7/5 finish

                    break;
                case R.id.bt_sure_activity_reset_login_psw:
                    // TODO: 2016/7/5 确定
                    performReset();

                    break;

            }
        }
    };

    private void performReset() {
        //原登录密码
        String oriPsw = etOriginalityLoginPswActivityResetLoginPsw.getText().toString();
        //新登录面
        String newPsw = etSetNewLoginPswActivityResetLoginPsw.getText().toString();
        //确认密码
        String confirmPsw = etComfirmNewPswActivityResetLoginPsw.getText().toString();
        if (TextUtils.isEmpty(oriPsw)) {
            JUtils.Toast("请输入原登录密码");
            return;
        }
        if (TextUtils.isEmpty(newPsw)) {
            JUtils.Toast("请输入新登录密码");
            return;
        }
        if (TextUtils.isEmpty(confirmPsw)) {
            JUtils.Toast("请输入确认密码");
            return;
        }
        if (!oriPsw.equals(newPsw)) {
            JUtils.Toast("两次密码不一致");
            return;
        }
        if (!MathUtil.pswFilter(newPsw)) {
            JUtils.Toast("密码为6-15位字母、标点符号、数字至少包含2种");
            return;
        }


        resetLoginPswPresenter.perform(oriPsw,newPsw);

    }

    @Override
    public void onResetSuccess() {

    }

    @Override
    public void onResetFail() {

    }

    @Override
    public void onNetError() {
        JUtils.Toast("网络链接错误");
    }
}
