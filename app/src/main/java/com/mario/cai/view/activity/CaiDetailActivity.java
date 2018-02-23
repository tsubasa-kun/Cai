package com.mario.cai.view.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.love_cookies.cookie_library.activity.BaseActivity;
import com.love_cookies.cookie_library.adapter.CommonAdapter;
import com.love_cookies.cookie_library.adapter.CommonViewHolder;
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
    @ViewInject(R.id.empty_view)
    private TextView emptyView;
    @ViewInject(R.id.list_view)
    private ListView listView;

    private CaiDetailPresenter caiDetailPresenter = new CaiDetailPresenter(this);

    private CommonAdapter<CaiBean.DataBean> adapter;

    /**
     * 初始化控件
     * @param savedInstanceState
     */
    @Override
    public void initWidget(Bundle savedInstanceState) {
        String title = getIntent().getExtras().getString("title", "");
        String api = getIntent().getExtras().getString("api", "");
        titleBar.setTitle(title);
        titleBar.setLeftImageResource(R.drawable.ic_back);
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
        if (caiBean.getData() != null && caiBean.getData().size() > 0) {
            emptyView.setVisibility(View.GONE);
            listView.setVisibility(View.VISIBLE);
            adapter = new CommonAdapter<CaiBean.DataBean>(this, R.layout.item_cai_list, caiBean.getData()) {
                @Override
                public void convert(CommonViewHolder holder, CaiBean.DataBean dataBean) {
                    holder.setTextWithTemplate(R.id.expect, dataBean.getExpect(), getString(R.string.expect_label));
                    holder.setTextWithTemplate(R.id.time, dataBean.getOpentime(), getString(R.string.open_time_label));
                    LinearLayout numContent = holder.getView(R.id.num_content);
                    numContent.removeAllViews();
                    String[] nums = dataBean.getOpencode().split("\\+");
                    String[] red = nums[0].split(",");
                    LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    lp.setMargins(0, 0, 12, 0);
                    for (int i = 0; i < red.length; i++) {
                        TextView textView = new TextView(CaiDetailActivity.this);
                        textView.setLayoutParams(lp);
                        textView.setBackgroundResource(R.drawable.round_red_bg);
                        textView.setTextColor(Color.WHITE);
                        textView.setTextSize(14);
                        textView.setText(red[i]);
                        textView.setGravity(Gravity.CENTER);
                        numContent.addView(textView);
                    }
                    if (nums.length > 1) {
                        String[] blue = nums[1].split(",");
                        for (int i = 0; i < blue.length; i++) {
                            TextView textView = new TextView(CaiDetailActivity.this);
                            textView.setLayoutParams(lp);
                            textView.setBackgroundResource(R.drawable.round_blue_bg);
                            textView.setTextColor(Color.WHITE);
                            textView.setTextSize(14);
                            textView.setText(blue[i]);
                            textView.setGravity(Gravity.CENTER);
                            numContent.addView(textView);
                        }
                    }
                }
            };
            listView.setAdapter(adapter);
        } else {
            emptyView.setVisibility(View.VISIBLE);
            listView.setVisibility(View.GONE);
        }
    }

    /**
     * 请求失败
     */
    @Override
    public void requestFailed() {
        ToastUtils.show(this, R.string.request_failed);
    }
}
