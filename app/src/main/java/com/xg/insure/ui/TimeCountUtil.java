package com.xg.insure.ui;

/**
 * Created by admin on 2016/4/6.
 * 倒计时文字
 * 对应TextView  背景色不变
 */

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;


public class TimeCountUtil extends CountDownTimer {
    private Activity mActivity;
    private TextView tv;//按钮

    // 在这个构造方法里需要传入三个参数，一个是Activity，一个是总的时间millisInFuture，一个是countDownInterval，然后就是你在哪个按钮上做这个是，就把这个按钮传过来就可以了
    public TimeCountUtil(Activity mActivity, long millisInFuture, long countDownInterval, TextView tv) {
        super(millisInFuture, countDownInterval);
        this.mActivity = mActivity;
        this.tv = tv;
    }


    @SuppressLint("NewApi")
    @Override
    public void onTick(long millisUntilFinished) {
        tv.setClickable(false);//设置不能点击
        tv.setText(millisUntilFinished / 1000 + "秒后可重发");//设置倒计时时间
//        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
//        tv.setLayoutParams(params);
        tv.setTextSize(13);
        //设置按钮为灰色，这时是不能点击的
//        tv.setBackgroundColor(mActivity.getResources().getColor(R.color.textColorShallowGray));
        Spannable span = new SpannableString(tv.getText().toString());//获取按钮的文字
        span.setSpan(new ForegroundColorSpan(Color.RED), 0, 2, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);//将倒计时时间显示为红色
        tv.setText(span);

    }


    @SuppressLint("NewApi")
    @Override
    public void onFinish() {
        tv.setText("重新获取验证码");
        tv.setTextSize(10);
        tv.setClickable(true);//重新获得点击
        // TODO: 2016/6/22 更改为原来的字体颜色
//        tv.setBackgroundColor(mActivity.getResources().getColor(R.color.btVerificationCodeLikeRed));//还原背景色
    }


}
