package com.xg.insure.base;

import android.app.Application;
import android.content.Context;
import android.util.DisplayMetrics;

import com.facebook.stetho.Stetho;
import com.socks.library.KLog;

/**
 * Created by admin on 2016/5/23.
 * 参考库
 * 网络请求  retrofit+ok
 * 事件传递 eventbus
 *
 */
public class BaseApplication extends Application {
    private DisplayMetrics displayMetrics = null;
    public static BaseApplication baseApplication;
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化听诊器 调试用 后期可以删掉
        Stetho.initializeWithDefaults(this);
        if (baseApplication==null) {
            baseApplication = new BaseApplication();
        }
        context=getApplicationContext();


        KLog.init(true,"weilixing");
    }


    public float getScreenDensity() {
        if (this.displayMetrics == null) {
            setDisplayMetrics(getResources().getDisplayMetrics());
        }
        return this.displayMetrics.density;
    }

    /**
     * 获取屏幕高度 单位px
     * @return
     */
    public int getScreenHeight() {
        if (this.displayMetrics == null) {
            setDisplayMetrics(getResources().getDisplayMetrics());
        }
        return this.displayMetrics.heightPixels;
    }

    /**
     * 获取屏幕宽度 单位px
     * @return
     */
    public int getScreenWidth() {
        if (this.displayMetrics == null) {
            setDisplayMetrics(getResources().getDisplayMetrics());
        }
        return this.displayMetrics.widthPixels;
    }



    public void setDisplayMetrics(DisplayMetrics DisplayMetrics) {
        this.displayMetrics = DisplayMetrics;
    }

    /**
     * dp转px
     * @param f   dp
     * @return    px
     */
    public  int dp2px(float f) {
        return (int) (0.5F + f * getScreenDensity());
    }

    /**
     * px转dp
     * @param pxValue  px
     * @return         dp
     */
    public int px2dp(float pxValue) {
        return (int) (pxValue / getScreenDensity() + 0.5f);
    }

    /**
     * 获取应用的data/data/....File目录
     */
    public String getFilesDirPath() {
        return getFilesDir().getAbsolutePath();
    }

    /**
     * 获取应用的data/data/....Cache目录
     */

    public String getCacheDirPath() {
        return getCacheDir().getAbsolutePath();
    }


}
