package com.mario.cai.presenter;

import com.love_cookies.cookie_library.interfaces.CallBack;
import com.mario.cai.mobile.bean.CaiBean;
import com.mario.cai.mobile.biz.CaiDetailBiz;
import com.mario.cai.view.interfaces.ICaiDetail;

/**
 * Created by mario on 2018/2/7.
 *
 * 彩票详情Presenter
 */

public class CaiDetailPresenter {
    private CaiDetailBiz caiDetailBiz;
    private ICaiDetail iCaiDetail;

    public CaiDetailPresenter(ICaiDetail iCaiDetail) {
        caiDetailBiz = new CaiDetailBiz();
        this.iCaiDetail = iCaiDetail;
    }

    /**
     * 获取彩票列表
     * @param api
     */
    public void getCaiList(String api) {
        caiDetailBiz.getCaiList(api, new CallBack() {
            @Override
            public void onSuccess(Object result) {
                iCaiDetail.setCaiList((CaiBean) result);
            }

            @Override
            public void onFailed(Object msg) {
                iCaiDetail.requestFailed();
            }
        });
    }
}
