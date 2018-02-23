package com.mario.cai.presenter;

import com.love_cookies.cookie_library.interfaces.CallBack;
import com.mario.cai.mobile.bean.NewsListBean;
import com.mario.cai.mobile.biz.NewsBiz;
import com.mario.cai.view.interfaces.INews;

/**
 * Created by mario on 2018/2/23.
 *
 * 新闻资讯Presenter
 */

public class NewsPresenter {
    private NewsBiz newsBiz;
    private INews iNews;

    public NewsPresenter(INews iNews) {
        newsBiz = new NewsBiz();
        this.iNews = iNews;
    }

    /**
     * 获取新闻列表
     */
    public void getNewsList() {
        newsBiz.getNewsList(new CallBack() {
            @Override
            public void onSuccess(Object result) {
                iNews.setNewsList((NewsListBean) result);
            }

            @Override
            public void onFailed(Object msg) {
                iNews.requestFailed();
            }
        });
    }
}
