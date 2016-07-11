package com.xg.insure.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

import com.xg.insure.fragment.FinancingListFragment;

import java.util.ArrayList;

/**
 * Created by server on 2016/6/23.
 */
public class FinancingListActivityVPAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> fragments=new ArrayList<>();
    String[] titles={"回款中","正在申购","筹集失败","已结清"};

    public FinancingListActivityVPAdapter(android.support.v4.app.FragmentManager fm) {
        super(fm);
        if (fragments.size()==0){
            fragments.add(FinancingListFragment.newInstance(0));
            fragments.add(FinancingListFragment.newInstance(1));
            fragments.add(FinancingListFragment.newInstance(2));
            fragments.add(FinancingListFragment.newInstance(3));
        }
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return titles[position];
    }
}
