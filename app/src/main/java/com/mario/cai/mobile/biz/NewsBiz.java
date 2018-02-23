package com.mario.cai.mobile.biz;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.FindCallback;
import com.love_cookies.cookie_library.interfaces.CallBack;
import com.mario.cai.mobile.bean.NewsListBean;
import com.mario.cai.mobile.biz.interfaces.INewsBiz;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by mario on 2018/2/7.
 *
 * 彩票详情逻辑
 */

public class NewsBiz implements INewsBiz {

    /**
     * 获取新闻列表
     * @param callBack
     */
    @Override
    public void getNewsList(final CallBack callBack) {

        AVQuery<AVObject> avQuery = new AVQuery<>("News");
        // 按时间，降序排列
        avQuery.orderByDescending("createdAt");
        avQuery.findInBackground(new FindCallback<AVObject>() {
            @Override
            public void done(List<AVObject> list, AVException e) {
                NewsListBean newsListBean = new NewsListBean();
                List<NewsListBean.NewsBean> news = new ArrayList<>();
                for (AVObject newsItem : list) {
                    NewsListBean.NewsBean newsBean = new NewsListBean.NewsBean();
                    newsBean.setImgUrl(newsItem.getString("img"));
                    newsBean.setTitle(newsItem.getString("title"));
                    newsBean.setContent(newsItem.getString("content"));
                    Date update = newsItem.getUpdatedAt();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                    newsBean.setTime(sdf.format(update));
                    news.add(newsBean);
                }
                newsListBean.setNews(news);
                callBack.onSuccess(newsListBean);
            }
        });
    }
}
