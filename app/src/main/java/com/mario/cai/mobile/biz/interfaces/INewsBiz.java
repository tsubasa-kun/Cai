package com.mario.cai.mobile.biz.interfaces;

import com.love_cookies.cookie_library.interfaces.CallBack;

/**
 * Created by mario on 2018/2/23.
 *
 * 新闻逻辑接口
 */

public interface INewsBiz {
    /**
     * 获取彩票列表
     * @param callBack
     */
    void getNewsList(CallBack callBack);
}
