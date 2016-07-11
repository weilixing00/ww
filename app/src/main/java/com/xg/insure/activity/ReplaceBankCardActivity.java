package com.xg.insure.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xg.insure.R;
import com.xg.insure.base.BaseActivity;
import com.xg.insure.common.NoDoubleClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by server on 2016/6/27.
 */

public class ReplaceBankCardActivity extends BaseActivity {


    @BindView(R.id.iv_back_header)
    ImageView ivBackHeader;
    @BindView(R.id.tv_title_header)
    TextView tvTitleHeader;
    @BindView(R.id.iv_icon_right_header)
    ImageView ivIconRightHeader;
    @BindView(R.id.tv_right_header)
    TextView tvRightHeader;
    @BindView(R.id.tv_name_activity_replace_bankcard)
    TextView tvNameActivityReplaceBankcard;
    @BindView(R.id.tv_identifity_num_activity_replace_bankcard)
    TextView tvIdentifityNumActivityReplaceBankcard;
    @BindView(R.id.tv_bank_name_activity_replace_bankcard)
    TextView tvBankNameActivityReplaceBankcard;
    @BindView(R.id.ll_choose_bank_activity_replace_bankcard)
    LinearLayout llChooseBankActivityReplaceBankcard;
    @BindView(R.id.et_bank_num_activity_replace_bankcard)
    EditText etBankNumActivityReplaceBankcard;
    @BindView(R.id.bt_sure_activity_replace_bankcard)
    Button btSureActivityReplaceBankcard;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_replace_bankcard);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        tvTitleHeader.setText("更换银行卡");
        ivBackHeader.setOnClickListener(noDoubleClick);
        llChooseBankActivityReplaceBankcard.setOnClickListener(noDoubleClick);
        btSureActivityReplaceBankcard.setOnClickListener(noDoubleClick);
    }
    View.OnClickListener noDoubleClick=new NoDoubleClickListener() {
        @Override
        public void onNoDoubleClick(View v) {
            switch (v.getId()){
                case R.id.iv_back_header:
                    // TODO: 2016/6/27 finish

                    break;
                case R.id.bt_sure_activity_replace_bankcard:
                    // TODO: 2016/6/27 确定

                    break;
                case R.id.ll_choose_bank_activity_replace_bankcard:
                    //选择开户行
                    Intent intent=new Intent(ReplaceBankCardActivity.this,ChooseBankCardActivity.class);
                    startActivity(intent);
                    break;


                default:
                    throw new RuntimeException("ReplaceBankCardActivity没有找到对应资源ID");
            }
        }
    };

}
