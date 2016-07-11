package com.xg.insure.mvp.Presenter;

import android.app.Activity;
import android.view.WindowManager;

import com.xg.insure.activity.SetSecurityProtectQuestionActiviy;

import java.util.ArrayList;
import java.util.List;

import cn.jeesoft.widget.pickerview.CharacterPickerView;
import cn.jeesoft.widget.pickerview.CharacterPickerWindow;

/**
 * Created by server on 2016/7/7.
 */

public class SetSecurityProtectQuestionActiviyPresenter {
    private SetSecurityProtectQuestionActiviy setSecurityProtectQuestionActiviy;

    public SetSecurityProtectQuestionActiviyPresenter(SetSecurityProtectQuestionActiviy setSecurityProtectQuestionActiviy) {
        this.setSecurityProtectQuestionActiviy = setSecurityProtectQuestionActiviy;
    }

    private static List<String> options1Items = null;

    public  CharacterPickerWindow builder(SetSecurityProtectQuestionActiviy setSecurityProtectQuestionActiviy, final SetSecurityProtectQuestionActiviy.OnOptionsSelectListener listener) {
        //选项选择器
        CharacterPickerWindow mOptions = new CharacterPickerWindow(setSecurityProtectQuestionActiviy);
        //初始化选项数据
        setPickerData(mOptions.getPickerView());
        mOptions.setSelectOptions(0);
        //监听确定选择按钮
        mOptions.setOnoptionsSelectListener(new CharacterPickerWindow.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1) {
                if (listener != null) {
                    String province = options1Items.get(options1);
                    listener.onOptionsSelect(province);
                }
            }
        });
        return mOptions;
    }


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
        WindowManager.LayoutParams lp = setSecurityProtectQuestionActiviy.getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        setSecurityProtectQuestionActiviy.getWindow().setAttributes(lp);
    }
}
