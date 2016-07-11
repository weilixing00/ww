package com.xg.insure.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xg.insure.R;
import com.xg.insure.base.BaseFragment;
import com.xg.insure.common.NoDoubleClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by server on 2016/6/27.
 */

public class EditBankCardDialogFragment extends BaseFragment {


    @BindView(R.id.tv_delete_dialogfragment_edit_bankcard)
    TextView tvDeleteDialogfragmentEditBankcard;
    @BindView(R.id.tv_replace_dialogfragment_edit_bankcard)
    TextView tvReplaceDialogfragmentEditBankcard;

    public static EditBankCardDialogFragment newInstance(Bundle bundle) {
        EditBankCardDialogFragment editBankCardDialogFragment = new EditBankCardDialogFragment();
        editBankCardDialogFragment.setArguments(bundle);
        return editBankCardDialogFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialogfragment_edit_bankcard, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;

    }

    private void initView() {
        Bundle arguments = getArguments();
        if (arguments!=null){
            // TODO: 2016/6/27 获取传递的参数值

        }
        tvDeleteDialogfragmentEditBankcard.setOnClickListener(noDoubleClick);
        tvReplaceDialogfragmentEditBankcard.setOnClickListener(noDoubleClick);
    }

    View.OnClickListener noDoubleClick = new NoDoubleClickListener() {
        @Override
        public void onNoDoubleClick(View v) {
            switch (v.getId()) {
                case R.id.tv_delete_dialogfragment_edit_bankcard:
                    // TODO: 2016/6/27 删除
                    Intent intent=new Intent(getActivity(),DeleteBankCardActivity.class);
                    startActivity(intent);
                    break;
                case R.id.tv_replace_dialogfragment_edit_bankcard:
                    // TODO: 2016/6/27 更换

                    break;
                default:
                    throw new RuntimeException("EditBankCardDialogFragment 没有找到对应资源ID");
            }
        }
    };

}
