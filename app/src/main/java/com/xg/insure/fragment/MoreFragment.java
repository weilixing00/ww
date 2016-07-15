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
import com.xg.insure.mvp.account.emailapprove.EmailApproveActivity;
import com.xg.insure.activity.InviteManageActivity;
import com.xg.insure.mvp.account.login.LoginActivity;
import com.xg.insure.activity.ResetEmailApproveStep1Activity;
import com.xg.insure.mvp.account.modifyphoneapprove.ResetPhoneCeritification1Activity;
import com.xg.insure.activity.ResetTradePswActivity;
import com.xg.insure.activity.SecurityCenterActivity;
import com.xg.insure.activity.SetTradePswActivity;
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
    @BindView(R.id.tv_phone_fragment_tab4_bottom)
    TextView tvPhoneFragmentTab4Bottom;
    @BindView(R.id.ll_phone_fragment_tab4_bottom)
    LinearLayout llPhoneFragmentTab4Bottom;
    @BindView(R.id.tv_email_fragment_tab4_bottom)
    TextView tvEmailFragmentTab4Bottom;
    @BindView(R.id.ll_email_fragment_tab4_bottom)
    LinearLayout llEmailFragmentTab4Bottom;
    @BindView(R.id.tv_person_fragment_tab4_bottom)
    TextView tvPersonFragmentTab4Bottom;
    @BindView(R.id.ll_person_fragment_tab4_bottom)
    LinearLayout llPersonFragmentTab4Bottom;
    @BindView(R.id.tv_lock_fragment_tab4_bottom)
    TextView tvLockFragmentTab4Bottom;
    @BindView(R.id.ll_lock_fragment_tab4_bottom)
    LinearLayout llLockFragmentTab4Bottom;
    @BindView(R.id.ll_login_show_fragment_tab4_bottom)
    LinearLayout llLoginShowFragmentTab4Bottom;
    @BindView(R.id.tv_login_fragment_tab4_bottom)
    TextView tvLoginFragmentTab4Bottom;
    @BindView(R.id.ll_unlogin_show_fragment_tab4_bottom)
    LinearLayout llUnloginShowFragmentTab4Bottom;
    private MoreFragmentPresenter moreFragmentPresenter;
    //是否手机认证
    private boolean isPhoneAuthentication;
    //是否邮箱认证
    private boolean isEmailAuthencation;
    //是否实名认证
    private boolean isRealNameAuthencation;
    //是否设置交易密码
    private boolean isSetTradePsw;
    //是否登录
    private boolean isLogin;

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
        //已经登录
        if (isLogin) {
            llUnloginShowFragmentTab4Bottom.setVisibility(View.GONE);
            llLoginShowFragmentTab4Bottom.setVisibility(View.VISIBLE);

            llBankcardFragmentTab4Bottom.setOnClickListener(noDoubleClick);
            llInviteManageFragmentTab4Bottom.setOnClickListener(noDoubleClick);
            llBankcardFragmentTab4Bottom.setOnClickListener(noDoubleClick);
            llSettingFragmentTab4Bottom.setOnClickListener(noDoubleClick);
            llSecurityCenterFragmentTab4Bottom.setOnClickListener(noDoubleClick);

            moreFragmentPresenter.loadData();
        }
        //没有登录
        else {
            llUnloginShowFragmentTab4Bottom.setVisibility(View.VISIBLE);
            llLoginShowFragmentTab4Bottom.setVisibility(View.GONE);
            tvLoginFragmentTab4Bottom.setOnClickListener(noDoubleClick);
        }
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

        //  已手机认证
        if (isPhoneAuthentication) {
            llPhoneFragmentTab4Bottom.setOnClickListener(authencationClickListener);
        }
        //未手机认证
        else {
            llPhoneFragmentTab4Bottom.setOnClickListener(unAuthencationClickListener);
        }
        //已邮箱认证
        if (isEmailAuthencation) {
            llEmailFragmentTab4Bottom.setOnClickListener(authencationClickListener);
        }
        //未邮箱认证
        else {
            llEmailFragmentTab4Bottom.setOnClickListener(unAuthencationClickListener);
        }
        //已实名认证
        if (isRealNameAuthencation) {
            llPersonFragmentTab4Bottom.setOnClickListener(authencationClickListener);
        }
        //未实名认证
        else {
            llPersonFragmentTab4Bottom.setOnClickListener(unAuthencationClickListener);
        }
        //已设置交易密码
        if (isSetTradePsw) {
            llLockFragmentTab4Bottom.setOnClickListener(authencationClickListener);

        } else {
            llLockFragmentTab4Bottom.setOnClickListener(unAuthencationClickListener);
        }

    }

    @Override
    public void showError() {
        // TODO: 2016/7/11 显示联网失败的界面

    }

    //已认证时候的点击事件
    View.OnClickListener authencationClickListener =new NoDoubleClickListener() {
        @Override
        public void onNoDoubleClick(View v) {
            Intent intent=null;
            switch (v.getId()){
                //手机认证
                case R.id.ll_phone_fragment_tab4_bottom:
                    intent=new Intent(getActivity(), ResetPhoneCeritification1Activity.class);
                    startActivity(intent);
                    break;
                //邮箱认证
                case R.id.ll_email_fragment_tab4_bottom:
                    intent=new Intent(getActivity(), ResetEmailApproveStep1Activity.class);
                    startActivity(intent);
                    break;
                //实名认证
                case R.id.ll_person_fragment_tab4_bottom:

                    break;
                //交易密码
                case R.id.ll_lock_fragment_tab4_bottom:
                    intent=new Intent(getActivity(), ResetTradePswActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };


    //未认证时候的点击事件
    View.OnClickListener unAuthencationClickListener=new NoDoubleClickListener() {
        @Override
        public void onNoDoubleClick(View v) {
            Intent intent=null;
            switch (v.getId()){
                //手机认证  一般情况都已经认证了
                case R.id.ll_phone_fragment_tab4_bottom:

                    break;
                //邮箱认证
                case R.id.ll_email_fragment_tab4_bottom:
                    intent=new Intent(getActivity(), EmailApproveActivity.class);
                    startActivity(intent);
                    break;
                //实名认证
                case R.id.ll_person_fragment_tab4_bottom:

                    break;
                //交易密码
                case R.id.ll_lock_fragment_tab4_bottom:
                    intent=new Intent(getActivity(), SetTradePswActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };


}
