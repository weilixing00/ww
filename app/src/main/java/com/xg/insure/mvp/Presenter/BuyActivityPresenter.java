package com.xg.insure.mvp.Presenter;

import com.xg.insure.activity.BuyActivity;

/**
 * Created by server on 2016/6/30.
 */
public class BuyActivityPresenter {
    private final BuyActivity buyActivity;

    private boolean isAgreeDeal;
    public BuyActivityPresenter(BuyActivity buyActivity) {
        this.buyActivity=buyActivity;
    }


    public void agreeDeal(){
        isAgreeDeal=true;
    }

    public void disAgreeDeal(){
        isAgreeDeal=false;
    }

}
