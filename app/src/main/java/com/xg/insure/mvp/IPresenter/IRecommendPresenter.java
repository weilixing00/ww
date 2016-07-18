package com.xg.insure.mvp.IPresenter;

import com.xg.insure.bean.RecommendResponse;
import com.xg.insure.mvp.model.UserStatusResponse;

/**
 * Created by server on 2016/7/12.
 */

public interface IRecommendPresenter {
    void onLoadSuccess(RecommendResponse recommendResponse);
    void onLoadFail();
}
