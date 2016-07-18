package com.xg.insure.mvp.Presenter;

import com.xg.insure.bean.RecommendResponse;
import com.xg.insure.mvp.IPresenter.IRecommendPresenter;
import com.xg.insure.mvp.model.RecommendModel;
import com.xg.insure.mvp.view.IRecommendView;

/**
 * Created by server on 2016/7/12.
 * 推荐Fragment的P层
 */

public class RecommendPresenter implements IRecommendPresenter {
    private IRecommendView iRecommendView;
    private RecommendModel recommendModel;

    public RecommendPresenter(IRecommendView iRecommendView) {
        this.iRecommendView = iRecommendView;
        this.recommendModel = new RecommendModel(this);
    }

    public void loadData() {
        recommendModel.fetchRecommendResponse();
    }


    @Override
    public void onLoadSuccess(RecommendResponse recommendResponse) {
        iRecommendView.showData(recommendResponse);
    }

    @Override
    public void onLoadFail() {
        iRecommendView.showError();
    }
}
