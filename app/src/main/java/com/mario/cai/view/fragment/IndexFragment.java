package com.mario.cai.view.fragment;

import android.os.Bundle;
import android.view.View;

import com.love_cookies.cookie_library.fragment.BaseFragment;
import com.love_cookies.cookie_library.utils.NetworkUtils;
import com.mario.cai.R;

import org.xutils.view.annotation.ContentView;

/**
 * Created by mario on 2018/02/05 0005.
 *
 * 开奖页
 */
@ContentView(R.layout.fragment_index)
public class IndexFragment extends BaseFragment {

    /**
     * 初始化控件
     * @param savedInstanceState
     */
    @Override
    public void initWidget(Bundle savedInstanceState) {

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
