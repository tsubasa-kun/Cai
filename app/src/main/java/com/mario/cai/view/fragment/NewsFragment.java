package com.mario.cai.view.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.love_cookies.cookie_library.adapter.CommonAdapter;
import com.love_cookies.cookie_library.adapter.CommonViewHolder;
import com.love_cookies.cookie_library.fragment.BaseFragment;
import com.love_cookies.cookie_library.utils.NetworkUtils;
import com.love_cookies.cookie_library.utils.ToastUtils;
import com.love_cookies.cookie_library.widget.CookieTitleBar;
import com.mario.cai.R;
import com.mario.cai.mobile.bean.NewsListBean;
import com.mario.cai.presenter.NewsPresenter;
import com.mario.cai.view.activity.NewsDetailActivity;
import com.mario.cai.view.interfaces.INews;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

/**
 * Created by mario on 2018/02/05 0005.
 *
 * 资讯页
 */
@ContentView(R.layout.fragment_news)
public class NewsFragment extends BaseFragment implements INews {

    @ViewInject(R.id.title_bar)
    private CookieTitleBar titleBar;
    @ViewInject(R.id.list_view)
    private ListView listView;

    private NewsPresenter newsPresenter = new NewsPresenter(this);

    private CommonAdapter<NewsListBean.NewsBean> adapter;

    /**
     * 初始化控件
     * @param savedInstanceState
     */
    @Override
    public void initWidget(Bundle savedInstanceState) {
        titleBar.setTitle(R.string.main_tab_news);
        getNewsList();
    }

    /**
     * 控件点击事件
     * @param view
     */
    @Override
    public void widgetClick(View view) {

    }

    /**
     * 网络连接了
     * @param type
     */
    @Override
    public void netConnected(NetworkUtils.NetworkType type) {

    }

    /**
     * 网络断开了
     */
    @Override
    public void netDisConnected() {

    }

    /**
     * 获取新闻列表
     */
    @Override
    public void getNewsList() {
        newsPresenter.getNewsList();
    }

    /**
     * 设置新闻列表
     * @param newsListBean
     */
    @Override
    public void setNewsList(final NewsListBean newsListBean) {
        adapter = new CommonAdapter<NewsListBean.NewsBean>(getContext(), R.layout.item_news_list, newsListBean.getNews()) {
            @Override
            public void convert(CommonViewHolder holder, NewsListBean.NewsBean newsBean) {
                holder.setImage(R.id.img, newsBean.getImgUrl());
                holder.setText(R.id.title, newsBean.getTitle());
                holder.setText(R.id.content, newsBean.getContent());
                holder.setText(R.id.time, newsBean.getTime());
            }
        };
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("news", newsListBean.getNews().get(i));
                turn(NewsDetailActivity.class, bundle);
            }
        });
    }

    /**
     * 请求失败
     */
    @Override
    public void requestFailed() {
        ToastUtils.show(getContext(), R.string.request_failed);
    }
}
