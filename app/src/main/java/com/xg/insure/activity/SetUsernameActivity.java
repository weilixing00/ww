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
 * Created by server on 2016/6/28.
 */

public class SetUsernameActivity extends BaseActivity {


    @BindView(R.id.iv_back_header)
    ImageView ivBackHeader;
    @BindView(R.id.tv_title_header)
    TextView tvTitleHeader;
    @BindView(R.id.iv_icon_right_header)
    ImageView ivIconRightHeader;
    @BindView(R.id.tv_right_header)
    TextView tvRightHeader;
    @BindView(R.id.et_username_activity_set_username)
    EditText etUsernameActivitySetUsername;
    @BindView(R.id.bt_sure_activity_set_username)
    Button btSureActivitySetUsername;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_username);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        tvTitleHeader.setText("设置用户名");
        ivBackHeader.setOnClickListener(noDoubleClick);
    }
    View.OnClickListener noDoubleClick=new NoDoubleClickListener() {
        @Override
        public void onNoDoubleClick(View v) {
            switch (v.getId()){
                case R.id.iv_back_header:
                    // TODO: 2016/6/28 finish

                    break;
                case R.id.bt_sure_activity_set_username:
                    // TODO: 2016/6/28 确定

                    break;
                default:
                    throw new RuntimeException("SetUsernameActivity 找不到对应资源文件");

            }
        }
    };

}
