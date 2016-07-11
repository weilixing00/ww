package com.xg.insure.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by admin on 2016/6/7.
 */
public abstract class BaseFragment extends Fragment {

    private static final java.lang.String STATE_SAVE_IS_HIDDEN = "satate_save_is_hiden";
    protected BaseActivity mActivity;


    //获取宿主Activity
    protected BaseActivity getHoldingActivity() {
        return mActivity;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //解决Fragment重叠的问题
        if (savedInstanceState != null) {
            boolean isSupportHidden = savedInstanceState.getBoolean(STATE_SAVE_IS_HIDDEN);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            if (isSupportHidden) {
                ft.hide(this);
            } else {
                ft.show(this);
            }
            ft.commit();
        }
    }

    //解决Fragment重叠的问题
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(STATE_SAVE_IS_HIDDEN, isHidden());
    }

    //防止系统资源紧张的时候回收Activity造成 Fragment的getActivity为空
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
//        this.mActivity = (BaseActivity) activity;

    }

//    //添加fragment
//    protected void addFragment(BaseFragment fragment) {
//        if (null != fragment) {
//            getHoldingActivity().addFragment(fragment);
//        }
//    }
//
//
//    //移除fragment
//    protected void removeFragment() {
//        getHoldingActivity().removeFragment();
//    }


}
