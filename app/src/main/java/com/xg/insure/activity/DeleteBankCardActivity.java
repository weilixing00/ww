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
 * Created by server on 2016/6/27.
 */
public class DeleteBankCardActivity extends BaseActivity {


    @BindView(R.id.iv_back_header)
    ImageView ivBackHeader;
    @BindView(R.id.tv_title_header)
    TextView tvTitleHeader;
    @BindView(R.id.iv_icon_right_header)
    ImageView ivIconRightHeader;
    @BindView(R.id.tv_right_header)
    TextView tvRightHeader;
    @BindView(R.id.et_identity_num_activity_delete_bankcard)
    EditText etIdentityNumActivityDeleteBankcard;
    @BindView(R.id.et_trade_psw_activity_delete_bankcard)
    EditText etTradePswActivityDeleteBankcard;
    @BindView(R.id.bt_sure_activity_delete_bankcard)
    Button btSureActivityDeleteBankcard;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_bank_card);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        tvTitleHeader.setText("删除银行卡");
        ivBackHeader.setOnClickListener(noDoubleClick);
        btSureActivityDeleteBankcard.setOnClickListener(noDoubleClick);

    }

    View.OnClickListener noDoubleClick = new NoDoubleClickListener() {
        @Override
        public void onNoDoubleClick(View v) {
            switch (v.getId()) {
                case R.id.iv_back_header:
                    // TODO: 2016/6/27 finish

                    break;
                case R.id.bt_sure_activity_delete_bankcard:
                    // TODO: 2016/6/27 确定

                    break;
                default:
                    throw new RuntimeException("DeleteBankCardActivity 找不到对应资源ID");
            }
        }
    };

}
