package com.xg.insure.mvp.account.safeprotectquestion;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.xg.insure.R;
import com.xg.insure.base.BaseActivity;
import com.xg.insure.base.BaseApplication;
import com.xg.insure.common.NoDoubleClickListener;
import com.xg.insure.ui.TimeCountUtil;
import com.xg.insure.util.JUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jeesoft.widget.pickerview.CharacterPickerView;
import cn.jeesoft.widget.pickerview.CharacterPickerWindow;

/**
 * Created by server on 2016/7/5.
 * 修改安全保护问题
 */

public class ResetSafeProtectQuestionActivity extends BaseActivity implements ResetSafeQuestionContract.IResetSafeQuestionView{


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
    private ResetSafeQuestionPresenter presenter;
    private TimeCountUtil timeCountUtil;
    private boolean isPopOpen=false;
    private String question;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_safe_protect_question);
        ButterKnife.bind(this);
        initView();
        presenter = new ResetSafeQuestionPresenter(this);
        timeCountUtil = new TimeCountUtil(this,60000,1000,tvObtainMsgCodeActivityResetSafeProtectQuestion);
    }

    private void initView() {
        tvTitleHeader.setText("修改安全保护问题");
        ivBackHeader.setOnClickListener(noDoubleClick);
        tvObtainMsgCodeActivityResetSafeProtectQuestion.setOnClickListener(noDoubleClick);
        btSureActivityResetSafeProtectQuestion.setOnClickListener(noDoubleClick);
        llChoseQuestionActivityResetSafeProtectQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPopOpen){
                    isPopOpen=false;
                    return;
                }
                else {
                    isPopOpen = true;
                }
                //弹出安全保护问题popuwindow
                //初始化
                //选项选择器
                CharacterPickerWindow window = new CharacterPickerWindow(BaseApplication.context);
                //初始化选项数据
                setPickerData(window.getPickerView());
                window.setSelectOptions(0);
                //监听确定选择按钮
                window.setOnoptionsSelectListener(new CharacterPickerWindow.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1) {
                        question = options1Items.get(options1);
                    }
                });

                window.showAtLocation(v, Gravity.BOTTOM, 0, 0);
                //设置背景色半透明
                backgroundAlpha(0.3f);
                window.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        backgroundAlpha(1);
                    }
                });
            }
        });
    }


    private static List<String> options1Items = null;



    /**
     * 初始化选项数据
     */
    public static void setPickerData(CharacterPickerView view) {

        if (options1Items == null) {
            options1Items = new ArrayList();
            for (int i = 0; i < 30; i++) {

                options1Items.add("sadasdsdsad" + i);
            }

        }
        //设置数据源
        view.setPicker(options1Items);
    }

    /**
     * 设置添加屏幕的背景透明度
     * @param bgAlpha
     */
    public void backgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        getWindow().setAttributes(lp);
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
                    obtainMsgCode();

                    break;
                case R.id.ll_chose_question_activity_reset_safe_protect_question:
                    // TODO: 2016/7/5 选择问题

                    break;
                case R.id.bt_sure_activity_reset_safe_protect_question:
                    // TODO: 2016/7/5  确定
                    resetQuesion();

                    break;
            }
        }
    };

    /**
     * 修改安全保护问题 确定
     */
    private void resetQuesion() {
        String msgCode = etMsgCodeActivityResetSafeProtectQuestion.getText().toString().trim();
        String answer = etAnswerActivityResetSafeProtectQuestion.getText().toString().trim();
        if (TextUtils.isEmpty(msgCode)){
            JUtils.Toast("请输入验证码");
            return;
        }
        if (TextUtils.isEmpty(answer)){
            JUtils.Toast("请输入问题答案");
            return;
        }
        //注册获取手机验证码
//        presenter.resetQuestion();
    }

    /**
     * 获取验证码
     */
    private void obtainMsgCode() {

    }

    @Override
    public void onObtainMsgCodeSuccess() {
            timeCountUtil.start();
    }

    @Override
    public void onObtainMsgCodeFail() {

    }

    @Override
    public void onResetSuccess() {

    }

    @Override
    public void onResetFail() {

    }
}
