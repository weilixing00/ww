package com.xg.insure.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xg.insure.R;
import com.xg.insure.base.BaseFragment;
import com.xg.insure.constant.KeyConstant;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by server on 2016/6/23.
 * index:
 * 0: 回款中
 * 1: 正在申购
 * 2: 筹集失败
 * 3: 已结清
 */
public class FinancingListFragment extends BaseFragment {


    @BindView(R.id.tv_title1_fragment_financing_list)
    TextView tvTitle1FragmentFinancingList;
    @BindView(R.id.tv_wait_capital_fragment_financing_list)
    TextView tvWaitCapitalFragmentFinancingList;
    @BindView(R.id.tv_title2_fragment_financing_list)
    TextView tvTitle2FragmentFinancingList;
    @BindView(R.id.tv_wait_interest_fragment_financing_list)
    TextView tvWaitInterestFragmentFinancingList;

    public static FinancingListFragment newInstance(int index) {
        FinancingListFragment financingListFragment = new FinancingListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(KeyConstant.BundleKeyConstant.FANINCING_LIST_INDEX, index);
        financingListFragment.setArguments(bundle);
        return financingListFragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_paymenting, container, false);
        ButterKnife.bind(this, view);
        int index = getArguments().getInt(KeyConstant.BundleKeyConstant.FANINCING_LIST_INDEX, 0);
        initView(index);
        return view;
    }

    private void initView(int index) {
        switch (index) {
            case 0:
                // TODO: 2016/6/24 回款中
                tvTitle1FragmentFinancingList.setText("待收本金");
                tvTitle2FragmentFinancingList.setText("待收利息");

                break;
            case 1:
                // TODO: 2016/6/24 正在申购
                tvTitle1FragmentFinancingList.setText("申购本金");
                tvTitle2FragmentFinancingList.setText("应收利息");

                break;
            case 2:
                // TODO: 2016/6/24 筹集失败
                tvTitle1FragmentFinancingList.setText("已退款总额");
                tvTitle2FragmentFinancingList.setText("退款中的总额");

                break;
            case 3:
                // TODO: 2016/6/24 已结清
                tvTitle1FragmentFinancingList.setText("回收本金合计");
                tvTitle2FragmentFinancingList.setText("回收利息合计");

                break;
        }
    }
}
