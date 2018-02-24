package com.mario.cai.presenter;

import com.love_cookies.cookie_library.interfaces.CallBack;
import com.mario.cai.mobile.biz.SplashBiz;
import com.mario.cai.view.interfaces.ISplahs;

/**
 * Created by mario on 2018/2/24.
 *
 * 启动页Presenter
 */

public class SplashPresenter {
    private SplashBiz splashBiz;
    private ISplahs iSplahs;

    public SplashPresenter(ISplahs iSplahs) {
        splashBiz = new SplashBiz();
        this.iSplahs = iSplahs;
    }

    /**
     * 获取启动图片
     */
    public void getSplashImg() {
        splashBiz.getSplashImg(new CallBack() {
            @Override
            public void onSuccess(Object result) {
                iSplahs.setSplashImg((String) result);
            }

            @Override
            public void onFailed(Object msg) {
                iSplahs.setSplashImg("");
            }
        });
    }

    /**
     * 检查混合应用
     */
    public void checkHybrid() {
        splashBiz.checkHybrid(new CallBack() {
            @Override
            public void onSuccess(Object result) {
                iSplahs.setHybrid((String) result);
            }

            @Override
            public void onFailed(Object msg) {
                iSplahs.setNative();
            }
        });
    }

}
