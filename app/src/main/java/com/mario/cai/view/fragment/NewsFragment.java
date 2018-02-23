package com.mario.cai.view.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.FindCallback;
import com.love_cookies.cookie_library.fragment.BaseFragment;
import com.love_cookies.cookie_library.utils.NetworkUtils;
import com.love_cookies.cookie_library.widget.CookieTitleBar;
import com.mario.cai.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.List;

/**
 * Created by mario on 2018/02/05 0005.
 *
 * 资讯页
 */
@ContentView(R.layout.fragment_news)
public class NewsFragment extends BaseFragment {

    @ViewInject(R.id.title_bar)
    private CookieTitleBar titleBar;

    /**
     * 初始化控件
     * @param savedInstanceState
     */
    @Override
    public void initWidget(Bundle savedInstanceState) {
        titleBar.setTitle(R.string.main_tab_news);

        AVQuery<AVObject> avQuery = new AVQuery<>("News");
        avQuery.findInBackground(new FindCallback<AVObject>() {
            @Override
            public void done(List<AVObject> list, AVException e) {
                for (AVObject todo : list) {
                    Log.e("AAAAAAAAAA", todo.getString("title"));
                }
            }
        });
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
}
