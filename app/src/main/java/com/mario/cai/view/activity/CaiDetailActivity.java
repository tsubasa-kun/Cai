package com.mario.cai.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.love_cookies.cookie_library.activity.BaseActivity;
import com.love_cookies.cookie_library.utils.NetworkUtils;
import com.love_cookies.cookie_library.utils.ToastUtils;
import com.love_cookies.cookie_library.widget.CookieTitleBar;
import com.mario.cai.R;
import com.mario.cai.mobile.bean.CaiBean;
import com.mario.cai.presenter.CaiDetailPresenter;
import com.mario.cai.view.interfaces.ICaiDetail;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

/**
 * Created by mario on 2018/2/7.
 *
 * 彩票详情页
 */
@ContentView(R.layout.activity_cai_detail)
public class CaiDetailActivity extends BaseActivity implements ICaiDetail {

    @ViewInject(R.id.title_bar)
    private CookieTitleBar titleBar;
    @ViewInject(R.id.list_view)
    private ListView listView;

    private CaiDetailPresenter caiDetailPresenter = new CaiDetailPresenter(this);

    /**
     * 初始化控件
     * @param savedInstanceState
     */
    @Override
    public void initWidget(Bundle savedInstanceState) {
        String title = getIntent().getExtras().getString("title", "");
        String api = getIntent().getExtras().getString("api", "");
        titleBar.setTitle(title);
        titleBar.setLeftImageResource(R.drawable.title_btn_back);
        titleBar.setLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        getCaiList(api);
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
        ToastUtils.show(this, R.string.net_error);
    }

    /**
     * 获取彩票列表
     * @param api
     */
    @Override
    public void getCaiList(String api) {
        caiDetailPresenter.getCaiList(api);
    }

    /**
     * 设置彩票列表
     * @param caiBean
     */
    @Override
    public void setCaiList(CaiBean caiBean) {
    }

    /**
     * 请求失败
     */
    @Override
    public void requestFailed() {
        ToastUtils.show(this, R.string.request_failed);
    }
}
