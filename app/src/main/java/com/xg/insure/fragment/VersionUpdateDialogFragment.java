package com.xg.insure.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.xg.insure.R;
import com.xg.insure.common.NoDoubleClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by server on 2016/7/1.
 */

public class VersionUpdateDialogFragment extends DialogFragment {

    @BindView(R.id.tv_cancel_dialogfragment_version_update)
    TextView tvCancelDialogfragmentVersionUpdate;
    @BindView(R.id.tv_sure_dialogfragment_version_update)
    TextView tvSureDialogfragmentVersionUpdate;

    public static VersionUpdateDialogFragment newInstance(){
        VersionUpdateDialogFragment versionUpdateDialogFragment=new VersionUpdateDialogFragment();

        return versionUpdateDialogFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialogfragment_version_update, container, false);
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        tvCancelDialogfragmentVersionUpdate.setOnClickListener(noDoubleClick);
    }
    View.OnClickListener noDoubleClick=new NoDoubleClickListener() {
        @Override
        public void onNoDoubleClick(View v) {
            switch (v.getId()){
                case R.id.tv_cancel_dialogfragment_version_update:
                    //取消
                    dismiss();
                    break;
                case R.id.tv_sure_dialogfragment_version_update:
                    // TODO: 2016/7/1 确定

                    break;
                default:
                    throw new RuntimeException("VersionUpdateDialogFragment 找不到对应资源ID");
            }
        }
    };

}
