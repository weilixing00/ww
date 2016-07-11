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
import com.xg.insure.activity.BankCardActivity;
import com.xg.insure.activity.InviteManageActivity;
import com.xg.insure.activity.LoginActivity;
import com.xg.insure.activity.SecurityCenterActivity;
import com.xg.insure.activity.SettingActivity;
import com.xg.insure.base.BaseFragment;
import com.xg.insure.common.NoDoubleClickListener;
import com.xg.insure.mvp.Presenter.MoreFragmentPresenter;
import com.xg.insure.mvp.model.UserStatusResponse;
import com.xg.insure.mvp.view.IMoreView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by admin on 2016/6/7.
 * 更多Fragment
 * 没有登录的时候显示登录的界面  隐藏显示个人信息
 * 登录之后 相反
 */
public class MoreFragment extends BaseFragment implements IMoreView {
    @BindView(R.id.tv_account_name_fragment_tab4_bottom)
    TextView tvAccountNameFragmentTab4Bottom;
    @BindView(R.id.tv_security_level_fragment_tab4_bottom)
    TextView tvSecurityLevelFragmentTab4Bottom;
    @BindView(R.id.iv_phone_fragment_tab4_bottom)
    ImageView ivPhoneFragmentTab4Bottom;
    @BindView(R.id.iv_email_fragment_tab4_bottom)
    ImageView ivEmailFragmentTab4Bottom;
    @BindView(R.id.iv_person_fragment_tab4_bottom)
    ImageView ivPersonFragmentTab4Bottom;
    @BindView(R.id.iv_lock_fragment_tab4_bottom)
    ImageView ivLockFragmentTab4Bottom;
    @BindView(R.id.ll_bankcard_fragment_tab4_bottom)
    LinearLayout llBankcardFragmentTab4Bottom;
    @BindView(R.id.ll_security_center_fragment_tab4_bottom)
    LinearLayout llSecurityCenterFragmentTab4Bottom;
    @BindView(R.id.ll_invite_manage_fragment_tab4_bottom)
    LinearLayout llInviteManageFragmentTab4Bottom;
    @BindView(R.id.ll_setting_fragment_tab4_bottom)
    LinearLayout llSettingFragmentTab4Bottom;
    private MoreFragmentPresenter moreFragmentPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab4_bottom, container, false);
        ButterKnife.bind(this, view);
        moreFragmentPresenter = new MoreFragmentPresenter(this);
        initView();
        return view;
    }

    private void initView() {
        llBankcardFragmentTab4Bottom.setOnClickListener(noDoubleClick);
        llInviteManageFragmentTab4Bottom.setOnClickListener(noDoubleClick);
        llBankcardFragmentTab4Bottom.setOnClickListener(noDoubleClick);
        llSettingFragmentTab4Bottom.setOnClickListener(noDoubleClick);
        llSecurityCenterFragmentTab4Bottom.setOnClickListener(noDoubleClick);

        moreFragmentPresenter.loadData();
    }

    View.OnClickListener noDoubleClick = new NoDoubleClickListener() {
        @Override
        public void onNoDoubleClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.ll_bankcard_fragment_tab4_bottom:
                    // TODO: 2016/6/27 银行卡
                    intent = new Intent(getActivity(), BankCardActivity.class);
                    startActivity(intent);
                    break;
                case R.id.ll_security_center_fragment_tab4_bottom:
                    // TODO: 2016/6/27 安全中心
                    intent = new Intent(getActivity(), SecurityCenterActivity.class);
                    startActivity(intent);
                    break;
                case R.id.ll_invite_manage_fragment_tab4_bottom:
                    // TODO: 2016/6/27 邀请管理
                    intent = new Intent(getActivity(), InviteManageActivity.class);
                    startActivity(intent);
                    break;
                case R.id.ll_setting_fragment_tab4_bottom:
                    // TODO: 2016/6/27 设置
                    intent = new Intent(getActivity(), SettingActivity.class);
                    startActivity(intent);
                    break;
                case R.id.tv_login_fragment_tab4_bottom:
                    // TODO: 2016/7/8 登录
                    intent = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);
                    break;
                default:
                    throw new RuntimeException("MoreFragment找不到对应资源ID");
            }
        }
    };

    @Override
    public void showData(UserStatusResponse userStatusResponse) {
        // TODO: 2016/7/9 根据网络请求的返回值显示界面不同的状态

    }
}
