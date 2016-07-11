package com.xg.insure.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flyco.tablayout.SegmentTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.xg.insure.R;
import com.xg.insure.adapter.FinancingFragmentPageAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by admin on 2016/6/7.
 * 理财
 */
public class FinancingFragment extends Fragment {
    @BindView(R.id.tl_fragment_tab2_bottom)
    SegmentTabLayout tlFragmentTab2Bottom;
    @BindView(R.id.vp_fragment_tab2_bottom)
    ViewPager vpFragmentTab2Bottom;

    private String[] titles = {"申购", "预约"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab2_bottom, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        tlFragmentTab2Bottom.setTabData(titles);
        vpFragmentTab2Bottom.setAdapter(new FinancingFragmentPageAdapter(getChildFragmentManager()));
        tlFragmentTab2Bottom.setTabData(titles);

        tlFragmentTab2Bottom.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                vpFragmentTab2Bottom.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
        vpFragmentTab2Bottom.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tlFragmentTab2Bottom.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
