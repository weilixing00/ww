package com.xg.insure.mvp.view;

/**
 * Created by server on 2016/7/12.
 * 理财Fragment中的申购页面
 */

public interface ISubscribeView {
    void initAndRefreshData();
    void loadMoreData();
    void fail();
}
