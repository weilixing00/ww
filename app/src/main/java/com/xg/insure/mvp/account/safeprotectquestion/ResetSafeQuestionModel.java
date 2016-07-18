package com.xg.insure.mvp.account.safeprotectquestion;

/**
 * Created by server on 2016/7/18.
 */

public class ResetSafeQuestionModel  {

    private ResetSafeQuestionPresenter presenter;

    public ResetSafeQuestionModel(ResetSafeQuestionPresenter presenter) {
        this.presenter = presenter;
    }

    /**
     * 获取验证码
     * @param phoneNum
     */
    public void obtainMsgCode(String phoneNum){

    }

    /**
     * 修改安全保护问题
     * @param msgCode 短信验证码
     * @param question  安全保护问题
     * @param answer    安全保护问题的答案
     */
    public void resetQuestion(String msgCode,String question,String answer){

    }
}
