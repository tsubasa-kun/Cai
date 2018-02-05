package com.mario.cai.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;

import com.love_cookies.cookie_library.activity.BaseActivity;
import com.love_cookies.cookie_library.application.ActivityCollections;
import com.love_cookies.cookie_library.utils.NetworkUtils;
import com.love_cookies.cookie_library.utils.ToastUtils;
import com.mario.cai.R;
import com.mario.cai.view.fragment.IndexFragment;
import com.mario.cai.view.fragment.MineFragment;
import com.mario.cai.view.fragment.NewsFragment;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

import eu.long1.spacetablayout.SpaceTabLayout;

/**
 * Created by mario on 2016/12/20 0020.
 *
 * 主页
 */
@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity {

    private long exitTime;

    @ViewInject(R.id.main_content)
    private ViewPager mainContent;
    @ViewInject(R.id.main_tab)
    private SpaceTabLayout mainTab;

    /**
     * 初始化控件
     * @param savedInstanceState
     */
    @Override
    public void initWidget(Bundle savedInstanceState) {
        //设置内容
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new IndexFragment());
        fragmentList.add(new NewsFragment());
        fragmentList.add(new MineFragment());
        //关联内容和tab
        mainTab.initialize(mainContent, getSupportFragmentManager(), fragmentList, savedInstanceState);
        mainContent.setOffscreenPageLimit(3);
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
     * 点两次返回退出程序
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {//点击两次退出逻辑
                ToastUtils.show(this, R.string.exit_tip);
                exitTime = System.currentTimeMillis();
            } else {
                ActivityCollections.getInstance().finishAllActivity();
                android.os.Process.killProcess(android.os.Process.myPid());
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
