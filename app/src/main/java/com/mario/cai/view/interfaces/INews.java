package com.mario.cai.view.interfaces;

import com.mario.cai.mobile.bean.NewsListBean;

/**
 * Created by mario on 2018/2/23.
 *
 * 新闻资讯 View接口
 */

public interface INews {
    /**
     * 获取新闻列表
     */
    void getNewsList();

    /**
     * 设置新闻列表
     * @param newsListBean
     */
    void setNewsList(NewsListBean newsListBean);

    /**
     * 请求失败
     */
    void requestFailed();
}
