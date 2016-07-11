package com.xg.insure.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.xg.insure.R;
import com.xg.insure.base.BaseActivity;
import com.xg.insure.common.NoDoubleClickListener;
import com.xg.insure.mvp.Presenter.SetSecurityProtectQuestionActiviyPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jeesoft.widget.pickerview.CharacterPickerView;
import cn.jeesoft.widget.pickerview.CharacterPickerWindow;


/**
 * Created by server on 2016/6/27.
 */

public class SetSecurityProtectQuestionActiviy extends BaseActivity {


    @BindView(R.id.iv_back_header)
    ImageView ivBackHeader;
    @BindView(R.id.tv_title_header)
    TextView tvTitleHeader;
    @BindView(R.id.iv_icon_right_header)
    ImageView ivIconRightHeader;
    @BindView(R.id.tv_right_header)
    TextView tvRightHeader;
    @BindView(R.id.tv_question_activity_set_security_protect_question)
    TextView tvQuestionActivitySetSecurityProtectQuestion;
    @BindView(R.id.iv_arrow_activity_set_security_protect_question)
    ImageView ivArrowActivitySetSecurityProtectQuestion;
    @BindView(R.id.ll_chose_question_activity_set_security_protect_question)
    LinearLayout llChoseQuestionActivitySetSecurityProtectQuestion;
    @BindView(R.id.et_answer_activity_set_security_protect_question)
    EditText etAnswerActivitySetSecurityProtectQuestion;
    @BindView(R.id.bt_sure_activity_set_security_protect_question)
    Button btSureActivitySetSecurityProtectQuestion;
    private SetSecurityProtectQuestionActiviyPresenter setSecurityProtectQuestionActiviyPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_security_protect_question);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        setSecurityProtectQuestionActiviyPresenter = new SetSecurityProtectQuestionActiviyPresenter(this);
        tvTitleHeader.setText("设置安全保护问题");
        ivBackHeader.setOnClickListener(noDoubleClick);
        btSureActivitySetSecurityProtectQuestion.setOnClickListener(noDoubleClick);
        llChoseQuestionActivitySetSecurityProtectQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //弹出安全保护问题popuwindow
                //初始化
                final CharacterPickerWindow window = setSecurityProtectQuestionActiviyPresenter.builder(SetSecurityProtectQuestionActiviy.this, new OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(String province) {
                        tvQuestionActivitySetSecurityProtectQuestion.setText(province);
                        Toast.makeText(SetSecurityProtectQuestionActiviy.this, "" + province, Toast.LENGTH_SHORT).show();
                    }
                });

                window.showAtLocation(v, Gravity.BOTTOM, 0, 0);
                //设置背景色半透明
                setSecurityProtectQuestionActiviyPresenter.backgroundAlpha(0.3f);

                window.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        setSecurityProtectQuestionActiviyPresenter.backgroundAlpha(1);
                    }
                });

            }
        });
    }




    public static interface OnOptionsSelectListener {
        public void onOptionsSelect(String province);
    }









    View.OnClickListener noDoubleClick = new NoDoubleClickListener() {
        @Override
        public void onNoDoubleClick(View v) {
            switch (v.getId()) {
                case R.id.iv_back_header:
                    // TODO: 2016/6/27 finish

                    break;
                case R.id.bt_sure_activity_set_security_protect_question:
                    // TODO: 2016/6/27 确定

                    break;
            }
        }
    };

}
