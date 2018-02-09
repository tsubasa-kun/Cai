package com.mario.cai.view.fragment;

import android.os.Bundle;
import android.view.View;

import com.love_cookies.cookie_library.fragment.BaseFragment;
import com.love_cookies.cookie_library.utils.NetworkUtils;
import com.love_cookies.cookie_library.widget.CookieTitleBar;
import com.mario.cai.R;
import com.mario.cai.view.activity.AboutActivity;
import com.mario.cai.view.activity.FeedbackActivity;
import com.mario.cai.view.activity.VersionActivity;
import com.mario.cai.view.widget.SettingItemView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

/**
 * Created by mario on 2018/02/05 0005.
 *
 * 我的页
 */
@ContentView(R.layout.fragment_setting)
public class SettingFragment extends BaseFragment {

    @ViewInject(R.id.title_bar)
    private CookieTitleBar titleBar;
    @ViewInject(R.id.feedback)
    private SettingItemView feedback;
    @ViewInject(R.id.about)
    private SettingItemView about;
    @ViewInject(R.id.version)
    private SettingItemView version;

    /**
     * 初始化控件
     * @param savedInstanceState
     */
    @Override
    public void initWidget(Bundle savedInstanceState) {
        titleBar.setTitle(R.string.main_tab_setting);
        feedback.setOnClickListener(this);
        about.setOnClickListener(this);
        version.setOnClickListener(this);
    }

    /**
     * 控件点击事件
     * @param view
     */
    @Override
    public void widgetClick(View view) {
        switch (view.getId()) {
            case R.id.feedback:
                turn(FeedbackActivity.class);
                break;
            case R.id.about:
                turn(AboutActivity.class);
                break;
            case R.id.version:
                turn(VersionActivity.class);
                break;
        }
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
