package com.xg.insure.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.xg.insure.fragment.BookingFragment;
import com.xg.insure.fragment.SubscribeFragment;

/**
 * Created by server on 2016/6/22.
 */
public class FinancingFragmentPageAdapter extends FragmentPagerAdapter {
    private FragmentManager childFragmentManager;
    Fragment[] fragments = {SubscribeFragment.newInstance(), BookingFragment.newInstance()};

    public FinancingFragmentPageAdapter(FragmentManager fm) {
        super(fm);
    }
//    public FinancingFragmentPageAdapter(FragmentManager childFragmentManager) {
//        this.childFragmentManager=childFragmentManager;
//    }

    @Override
    public Fragment getItem(int position) {

        return fragments[position];

    }

    @Override
    public int getCount() {
        return fragments.length;
    }


}
