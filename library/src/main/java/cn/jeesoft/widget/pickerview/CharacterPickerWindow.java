package cn.jeesoft.widget.pickerview;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import java.util.List;

/**
 * @version 0.1 king 2015-11
 */
public class CharacterPickerWindow extends PopupWindow implements View.OnClickListener {
    private final View rootView; // 总的布局
    private final View btnSubmit;
    private final CharacterPickerView pickerView;
    private OnOptionsSelectListener optionsSelectListener;

    public CharacterPickerWindow(Context context) {
        super(context);
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        this.setBackgroundDrawable(new BitmapDrawable());// 这样设置才能点击屏幕外dismiss窗口
        this.setOutsideTouchable(true);
        this.setAnimationStyle(R.style.j_timepopwindow_anim_style);

        LayoutInflater mLayoutInflater = LayoutInflater.from(context);
        rootView = mLayoutInflater.inflate(R.layout.j_picker_dialog, null);
        // -----确定和取消按钮
        btnSubmit = rootView.findViewById(R.id.j_btnSubmit);
        btnSubmit.setOnClickListener(this);
        // ----转轮
        pickerView = (CharacterPickerView) rootView.findViewById(R.id.j_optionspicker);
        setContentView(rootView);
    }

    public CharacterPickerView getPickerView() {
        return pickerView;
    }

    public void setPicker(List<String> optionsItems) {
        pickerView.setPicker(optionsItems, null, null);
    }


    /**
     * 设置选中的item位置
     *
     * @param option1
     */
    public void setSelectOptions(int option1) {
        pickerView.setCurrentItems(option1);
    }

    /**
     * 设置选中的item位置
     *
     * @param option1
     * @param option2
//     */
//    public void setSelectOptions(int option1, int option2) {
//        pickerView.setCurrentItems(option1, option2, 0);
//    }
//
//    /**
//     * 设置选中的item位置
//     *
//     * @param option1
//     * @param option2
//     * @param option3
//     */
//    public void setSelectOptions(int option1, int option2, int option3) {
//        pickerView.setCurrentItems(option1, option2, option3);
//    }

    /**
     * 设置是否循环滚动
     *
     * @param cyclic
     */
    public void setCyclic(boolean cyclic) {
        pickerView.setCyclic(cyclic);
    }

    //点击确定
    @Override
    public void onClick(View v) {
            if (optionsSelectListener != null) {
                int[] optionsCurrentItems = pickerView.getCurrentItems();
                optionsSelectListener.onOptionsSelect(optionsCurrentItems[0]);
            }
            dismiss();
            return;
    }

    public interface OnOptionsSelectListener {
        public void onOptionsSelect(int options1);
    }

    public void setOnoptionsSelectListener(
            OnOptionsSelectListener optionsSelectListener) {
        this.optionsSelectListener = optionsSelectListener;
    }
}
