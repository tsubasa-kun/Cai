package com.mario.cai.mobile.biz.interfaces;

import com.love_cookies.cookie_library.interfaces.CallBack;

/**
 * Created by mario on 2018/2/7.
 *
 * 彩票详情逻辑接口
 */

public interface ICaiDetailBiz {
    /**
     * 获取彩票列表
     * @param api
     * @param callBack
     */
    void getCaiList(String api, CallBack callBack);
}
