package com.xg.insure.mvp.view;

import com.xg.insure.bean.RecommendResponse;

/**
 * Created by server on 2016/7/12.
 */

public interface IRecommendView {
    void showData(RecommendResponse recommendResponse);
    void showError();
}
