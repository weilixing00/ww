package com.xg.insure.mvp.IPresenter;

import com.xg.insure.mvp.model.UserStatusResponse;

/**
 * Created by server on 2016/7/9.
 */

public interface IMorePresenter {
    void onLoadSuccess(UserStatusResponse userStatusResponse);
    void onLoadFail();
}
