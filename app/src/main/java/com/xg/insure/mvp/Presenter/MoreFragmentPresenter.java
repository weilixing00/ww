package com.xg.insure.mvp.Presenter;

import com.xg.insure.mvp.IPresenter.IMorePresenter;
import com.xg.insure.mvp.model.MoreModel;
import com.xg.insure.mvp.model.UserStatusResponse;
import com.xg.insure.mvp.view.IMoreView;

/**
 * Created by server on 2016/7/8.
 */

public class MoreFragmentPresenter {
    private IMoreView iMoreView;
    private final MoreModel moreModel;

    public MoreFragmentPresenter(IMoreView iMoreView) {
        this.iMoreView = iMoreView;
        moreModel = new MoreModel();
    }

    public void loadData() {
        moreModel.getUserStats(new IMorePresenter() {
            @Override
            public void onLoadSuccess(UserStatusResponse userStatusResponse) {
                iMoreView.showData(userStatusResponse);
            }

            @Override
            public void onLoadFail() {

            }
        });
    }


}
