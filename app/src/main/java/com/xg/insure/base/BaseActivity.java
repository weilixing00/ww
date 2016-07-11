package com.xg.insure.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.xg.insure.R;

/**
 * Created by admin on 2016/5/23.
 */
public abstract  class BaseActivity extends FragmentActivity {
    private InputMethodManager imm;


//    //布局中Fragment的ID
//    protected abstract int getFragmentContentId();
//
//    //添加fragment
//    protected void addFragment(BaseFragment fragment) {
//        if (fragment != null) {
//            getSupportFragmentManager().beginTransaction()
//                    .replace(getFragmentContentId(), fragment, fragment.getClass().getSimpleName())
//                    .addToBackStack(fragment.getClass().getSimpleName())
//                    .commitAllowingStateLoss();
//        }
//    }
//
//    //移除fragment
//    protected void removeFragment() {
//        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
//            getSupportFragmentManager().popBackStack();
//        } else {
//            finish();
//        }
//    }

    //返回键返回事件 点击返回时候弹出Fragment
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (KeyEvent.KEYCODE_BACK == keyCode) {
            if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
                finish();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //设置状态栏默认颜色 如果子Activity需要不一样的颜色可以在自己的Activity里面修改
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
//            tintManager.setTintColor(Color.RED);
            tintManager.setStatusBarTintResource(R.color.btColorLikeRede93030);//通知栏所需颜色
        }

        //软键盘自动隐藏
        imm= (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
    }

    @TargetApi(19)
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

    //控制点击EditText其他地方软键盘消失  包含ScrollView的地方会失效
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (BaseActivity.this.getCurrentFocus() != null && BaseActivity.this.getCurrentFocus().getWindowToken() != null) {

                imm.hideSoftInputFromWindow(BaseActivity.this.getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);

            }
        }
        return super.onTouchEvent(event);
    }
}
