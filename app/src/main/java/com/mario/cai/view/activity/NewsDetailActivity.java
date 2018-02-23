package com.mario.cai.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.love_cookies.cookie_library.activity.BaseActivity;
import com.love_cookies.cookie_library.utils.NetworkUtils;
import com.love_cookies.cookie_library.widget.CookieTitleBar;
import com.mario.cai.R;
import com.mario.cai.mobile.bean.NewsListBean;

import org.xutils.image.ImageOptions;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_news_detail)
public class NewsDetailActivity extends BaseActivity {

    @ViewInject(R.id.title_bar)
    private CookieTitleBar titleBar;
    @ViewInject(R.id.title)
    private TextView title;
    @ViewInject(R.id.time)
    private TextView time;
    @ViewInject(R.id.img)
    private ImageView image;
    @ViewInject(R.id.content)
    private TextView content;

    /**
     * 初始化控件
     *
     * @param savedInstanceState
     */
    @Override
    public void initWidget(Bundle savedInstanceState) {
        titleBar.setTitle(getString(R.string.news_detail_title));
        titleBar.setLeftImageResource(R.drawable.ic_back);
        titleBar.setLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        NewsListBean.NewsBean newsBean = getIntent().getExtras().getParcelable("news");
        title.setText(newsBean.getTitle());
        time.setText(String.format(getString(R.string.news_update_time), newsBean.getTime()));
        ImageOptions imageOptions = new ImageOptions.Builder()
                .setImageScaleType(ImageView.ScaleType.FIT_CENTER)
                .setLoadingDrawableId(com.love_cookies.cookie_library.R.mipmap.default_img)
                .setPlaceholderScaleType(ImageView.ScaleType.CENTER_CROP)
                .setFailureDrawableId(com.love_cookies.cookie_library.R.mipmap.default_img)
                .build();
        x.image().bind(image, newsBean.getImgUrl(), imageOptions);
        content.setText(newsBean.getContent());
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
     *
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
