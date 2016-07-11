package com.xg.insure.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.xg.insure.R;
import com.xg.insure.base.BaseActivity;
import com.xg.insure.common.NoDoubleClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by server on 2016/6/27.
 * 邀请管理
 */

public class InviteManageActivity extends BaseActivity {


    @BindView(R.id.iv_back_header)
    ImageView ivBackHeader;
    @BindView(R.id.tv_title_header)
    TextView tvTitleHeader;
    @BindView(R.id.iv_icon_right_header)
    ImageView ivIconRightHeader;
    @BindView(R.id.tv_right_header)
    TextView tvRightHeader;
    @BindView(R.id.tv_invite_code_activity_invite_manage)
    TextView tvInviteCodeActivityInviteManage;
    @BindView(R.id.tv_invite_friend_activity_invite_manage)
    TextView tvInviteFriendActivityInviteManage;
    @BindView(R.id.tv_award_amount_activity_invite_manage)
    TextView tvAwardAmountActivityInviteManage;
    @BindView(R.id.lv_activity_invite_manage)
    ListView lvActivityInviteManage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite_manage);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        tvTitleHeader.setText("邀请管理");
        ivBackHeader.setOnClickListener(noDoubleClick);
        tvInviteFriendActivityInviteManage.setOnClickListener(noDoubleClick);
    }


    View.OnClickListener noDoubleClick = new NoDoubleClickListener() {
        @Override
        public void onNoDoubleClick(View v) {
            switch (v.getId()) {
                case R.id.iv_back_header:
                    // TODO: 2016/6/27 finish

                    break;
                case R.id.tv_invite_friend_activity_invite_manage:
                    // TODO: 2016/6/27 邀请好友

                    break;
                default:
                    throw new RuntimeException("InviteManageActivity没有找到资源ID");
            }
        }
    };

}
