package com.mario.cai.mobile.biz.interfaces;

import com.love_cookies.cookie_library.interfaces.CallBack;

/**
 * Created by mario on 2018/2/24.
 *
 * 启动页逻辑接口
 */

public interface ISplashBiz {
    /**
     * 获取启动图片
     * @param callBack
     */
    void getSplashImg(CallBack callBack);

    /**
     * 检查混合应用
     * @param callBack
     */
    void checkHybrid(CallBack callBack);
}
