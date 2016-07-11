package com.xg.insure.activity;

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
 * Created by server on 2016/7/5.
 * 修改安全保护问题
 */

public class ResetSafeProtectQuestionActivity extends BaseActivity {


    @BindView(R.id.iv_back_header)
    ImageView ivBackHeader;
    @BindView(R.id.tv_title_header)
    TextView tvTitleHeader;
    @BindView(R.id.iv_icon_right_header)
    ImageView ivIconRightHeader;
    @BindView(R.id.tv_right_header)
    TextView tvRightHeader;
    @BindView(R.id.tv_phone_num_activity_reset_safe_protect_question)
    TextView tvPhoneNumActivityResetSafeProtectQuestion;
    @BindView(R.id.et_msg_code_activity_reset_safe_protect_question)
    EditText etMsgCodeActivityResetSafeProtectQuestion;
    @BindView(R.id.tv_obtain_msg_code_activity_reset_safe_protect_question)
    TextView tvObtainMsgCodeActivityResetSafeProtectQuestion;
    @BindView(R.id.tv_question_activity_reset_safe_protect_question)
    TextView tvQuestionActivityResetSafeProtectQuestion;
    @BindView(R.id.iv_arrow_activity_reset_safe_protect_question)
    ImageView ivArrowActivityResetSafeProtectQuestion;
    @BindView(R.id.ll_chose_question_activity_reset_safe_protect_question)
    LinearLayout llChoseQuestionActivityResetSafeProtectQuestion;
    @BindView(R.id.et_answer_activity_reset_safe_protect_question)
    EditText etAnswerActivityResetSafeProtectQuestion;
    @BindView(R.id.bt_sure_activity_reset_safe_protect_question)
    Button btSureActivityResetSafeProtectQuestion;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_safe_protect_question);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        tvTitleHeader.setText("修改安全保护问题");
        ivBackHeader.setOnClickListener(noDoubleClick);
        tvObtainMsgCodeActivityResetSafeProtectQuestion.setOnClickListener(noDoubleClick);
        btSureActivityResetSafeProtectQuestion.setOnClickListener(noDoubleClick);
        llChoseQuestionActivityResetSafeProtectQuestion.setOnClickListener(noDoubleClick);
    }
    View.OnClickListener noDoubleClick=new NoDoubleClickListener() {
        @Override
        public void onNoDoubleClick(View v) {
            switch (v.getId()){
                case R.id.iv_back_header:
                    // TODO: 2016/7/5 finish

                    break;
                case R.id.tv_obtain_msg_code_activity_reset_safe_protect_question:
                    // TODO: 2016/7/5 获取验证码

                    break;
                case R.id.ll_chose_question_activity_reset_safe_protect_question:
                    // TODO: 2016/7/5 选择问题

                    break;
                case R.id.bt_sure_activity_reset_safe_protect_question:
                    // TODO: 2016/7/5  确定

                    break;
            }
        }
    };

}
