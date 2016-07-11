package com.xg.insure.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xg.insure.R;
import com.xg.insure.activity.FinancingListActivity;
import com.xg.insure.base.BaseFragment;
import com.xg.insure.common.NoDoubleClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by admin on 2016/6/7.
 * 财富
 */
public class RichesFragment extends BaseFragment {
    @BindView(R.id.iv_back_header)
    ImageView ivBackHeader;
    @BindView(R.id.tv_title_header)
    TextView tvTitleHeader;
    @BindView(R.id.iv_icon_right_header)
    ImageView ivIconRightHeader;
    @BindView(R.id.tv_right_header)
    TextView tvRightHeader;
    @BindView(R.id.ll_financing_list_fragment_tab3_bottom)
    LinearLayout llFinancingListFragmentTab3Bottom;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab3_bottom, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        tvTitleHeader.setText("财富");
        ivBackHeader.setVisibility(View.GONE);
        tvRightHeader.setVisibility(View.VISIBLE);
        tvRightHeader.setText("明细");
        ivIconRightHeader.setVisibility(View.VISIBLE);
        // TODO: 2016/6/23 设置图标
//        ivIconRightHeader.setImageResource();
        llFinancingListFragmentTab3Bottom.setOnClickListener(noDoubleClick);
    }

    View.OnClickListener noDoubleClick=new NoDoubleClickListener() {
        @Override
        public void onNoDoubleClick(View v) {
            switch (v.getId()){
                case R.id.ll_financing_list_fragment_tab3_bottom:
                    // TODO: 2016/6/23 跳转到理财列表
                    startActivity(new Intent(getActivity(),FinancingListActivity.class));
            }
        }
    };

}
