package com.mario.cai.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.love_cookies.cookie_library.activity.BaseActivity;
import com.love_cookies.cookie_library.utils.NetworkUtils;
import com.love_cookies.cookie_library.utils.PackageUtils;
import com.love_cookies.cookie_library.widget.CookieTitleBar;
import com.mario.cai.R;
import com.mario.cai.mobile.bean.ChangeLogBean;
import com.mario.cai.presenter.VersionPresenter;
import com.mario.cai.view.adapter.ChangeLogAdapter;
import com.mario.cai.view.interfaces.IVersion;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by mario on 2016/12/20 0020.
 *
 * 版本信息页
 */
@ContentView(R.layout.activity_version)
public class VersionActivity extends BaseActivity implements IVersion {

    @ViewInject(R.id.title_bar)
    private CookieTitleBar titleBar;
    @ViewInject(R.id.version_tv)
    private TextView versionText;
    @ViewInject(R.id.change_log_list)
    private ListView changeLogList;

    private ChangeLogAdapter changeLogAdapter;
    private List<ChangeLogBean.ChangeLogEntity> changeLogDatas = new ArrayList<>();

    private VersionPresenter versionPresenter = new VersionPresenter(this);

    /**
     * 初始化控件
     *
     * @param savedInstanceState
     */
    @Override
    public void initWidget(Bundle savedInstanceState) {
        titleBar.setTitle(R.string.version_title);
        titleBar.setLeftImageResource(R.drawable.ic_back);
        titleBar.setLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        versionText.setText(getVersion());
        changeLogAdapter = new ChangeLogAdapter(this, changeLogDatas);
        changeLogList.setAdapter(changeLogAdapter);
        getChangeLog();
    }

    /**
     * 控件点击事件
     *
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
     * 获取版本
     *
     * @return
     */
    @Override
    public String getVersion() {
        return " V " + PackageUtils.getAppVersion(this);
    }

    /**
     * 获取ChangeLog
     */
    @Override
    public void getChangeLog() {
        versionPresenter.getChangeLog(this);
    }

    /**
     * 设置ChangeLog
     *
     * @param changeLogBean
     */
    @Override
    public void setChangeLog(ChangeLogBean changeLogBean) {
        changeLogDatas.clear();
        changeLogDatas.addAll(changeLogBean.getChange_log());
        changeLogAdapter.notifyDataSetChanged();
    }

}
