package com.xg.insure.ui;

/**
 * Created by admin on 2015/12/19.
 */

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

import com.xg.insure.R;
import com.xg.insure.base.BaseApplication;


/**
 * ww  自定义圆环控件
 */
public class RoundProgressBar extends View {

    private int roundColor;

    private int max = 100;
    //todo 圆环进度条颜色
//    private int roundProgressColor=getResources().getColor(R.color.textColorRed);
    private int textColor;
    private float textSize;
    private float roundWidth;
    private Paint paint;

    private int progress=50;

    public RoundProgressBar(Context context) {
        this(context, null);
    }

    public RoundProgressBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RoundProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(context, attrs, defStyleAttr);
    }

    private void initAttrs(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray mTypedArray = context.obtainStyledAttributes(attrs, R.styleable.roundProgress);
        paint = new Paint();

        //圆环颜色
        roundColor = mTypedArray.getColor(R.styleable.roundProgress_roundColor,Color.parseColor("#e2e2e2"));
        //todo 圆环进度颜色
//        roundProgressColor = mTypedArray.getColor(R.styleable.roundProgress_roundProgressColor,getResources().getColor(R.color.textColorRed));
        //中间进度百分比文字字符串颜色
        textColor = mTypedArray.getColor(R.styleable.roundProgress_textColor, 0xffae00);
        //中间进度百分比的字符串字体大小
        textSize = mTypedArray.getDimension(R.styleable.roundProgress_textSize, BaseApplication.baseApplication.dp2px(17));
        //圆环宽度
        roundWidth = mTypedArray.getDimension(R.styleable.roundProgress_roundWidth,10);
        mTypedArray.recycle();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        paint.setColor(roundColor);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(roundWidth);
        paint.setAntiAlias(true);
        int center = getWidth() / 2;
        int radius = (int) (center - roundWidth / 2);
        canvas.drawCircle(center, center, radius, paint);

        //画中间的文本文字
        paint.setStrokeWidth(0);
        paint.setColor(textColor);
//        paint.setTextSize(textSize);
        //字体加粗
//        paint.setTypeface(Typeface.DEFAULT_BOLD);
        int percent = (int) (((float) progress / (float) max) * 100);
//        if (percent==0){
//            paint.setTextSize(textSize);
//            paint.setColor(Color.RED);
//            float textWidth = paint.measureText("抢");
//            canvas.drawText("抢", center - textWidth / 2, center + textSize / 2-1, paint);
//            paint.setColor(Color.RED);
//            UIUtil.sLog("抢");
//        }
         if (percent==100){
            paint.setTextSize(textSize);
            paint.setColor(Color.parseColor("#DEDEDE"));
            float textWidth = paint.measureText("满");
            canvas.drawText("满", center - textWidth / 2, center + textSize / 2-1, paint);
             paint.setColor(Color.parseColor("#DEDEDE"));
//             UIUtil.sLog("满");
        }
        else {
               paint.setTextSize(textSize);
             // TODO: 2016/6/13 ""抢""字颜色
//             paint.setColor(getResources().getColor(R.color.textColorRed));
             float textWidth = paint.measureText("抢");
             canvas.drawText("抢", center - textWidth / 2, center + textSize / 2 - 1, paint);
//             paint.setColor(getResources().getColor(R.color.textColorRed));
//             UIUtil.sLog("抢");
            //todo 画弧形进度圈
//            paint.setColor(roundProgressColor);
            paint.setStrokeWidth(roundWidth);
            paint.setStyle(Paint.Style.STROKE);
        }


        RectF oval = new RectF(center - radius, center - radius, center
                + radius, center + radius);
        /**
         * oval：绘制的弧形的范围轮廓
         * 0:开始的角度
         * 360 * progress / max：结束的角度
         * false：是否包含中心点
         * paint:绘制弧形圈的画笔
         */
        canvas.drawArc(oval, 0, 360 * progress / max, false, paint);
        super.onDraw(canvas);
    }

    public void setProgress(int progress){
        if(progress<=max){
            this.progress = progress;
            postInvalidate();
        }
    }
}
