package com.xg.insure.mvp.account.safeprotectquestion;

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
import com.xg.insure.base.BaseApplication;
import com.xg.insure.common.NoDoubleClickListener;
import com.xg.insure.util.JUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jeesoft.widget.pickerview.CharacterPickerView;
import cn.jeesoft.widget.pickerview.CharacterPickerWindow;


/**
 * Created by server on 2016/6/27.
 * 设置安全保护问题
 * 因为内容比较简单 所以没用mvp  所有都写在activity里
 */

public class SetSafeProtectQuestionActiviy extends BaseActivity implements ResetSafeQuestionContract.IResetSafeQuestionView{


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

    private String question;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_security_protect_question);
        ButterKnife.bind(this);
        initView();
    }

    //设置标记位之后 防止点击问题弹窗被重复弹出
    private boolean isPopOpen=false;
    private void initView() {

        tvTitleHeader.setText("设置安全保护问题");
        ivBackHeader.setOnClickListener(noDoubleClick);
        btSureActivitySetSecurityProtectQuestion.setOnClickListener(noDoubleClick);
        llChoseQuestionActivitySetSecurityProtectQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPopOpen){
                    isPopOpen=false;
                    return;
                }
                isPopOpen=true;
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
                        JUtils.Toast(question);
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

    //无此功能 可以不实现
    @Override
    public void onObtainMsgCodeSuccess() {}

    //无此功能 可以不实现
    @Override
    public void onObtainMsgCodeFail() {}

    @Override
    public void onResetSuccess() {

    }

    @Override
    public void onResetFail() {

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
