package com.mario.cai.view.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;

import com.love_cookies.cookie_library.activity.BaseActivity;
import com.love_cookies.cookie_library.utils.NetworkUtils;
import com.mario.cai.R;
import com.mario.cai.presenter.SplashPresenter;
import com.mario.cai.view.interfaces.ISplahs;

import org.xutils.image.ImageOptions;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by mario on 2016/12/20 0020.
 *
 * 启动页
 */
@ContentView(R.layout.activity_splash)
public class SplashActivity extends BaseActivity implements ISplahs {

    @ViewInject(R.id.splash_img)
    private ImageView splashImg;

    private SplashPresenter splashPresenter = new SplashPresenter(this);
    private String webUrl = "";

    private final int SPLASH_DISPLAY_DURATION = 3000;//启动页显示时长
    private Looper looper = Looper.myLooper();
    private Handler handler = new Handler(looper);
    private Runnable toMain = new Runnable() {
        @Override
        public void run() {
            turnThenFinish(MainActivity.class);
        }
    };

    private Runnable toWeb = new Runnable() {
        @Override
        public void run() {
            Bundle bundle = new Bundle();
            bundle.putString("webUrl", webUrl);
            turnThenFinish(WebActivity.class, bundle);
        }
    };

    /**
     * 初始化控件
     * @param savedInstanceState
     */
    @Override
    public void initWidget(Bundle savedInstanceState) {
        getSplashImg();
        checkHybrid();
    }

    /**
     * 控件点击事件
     * @param v
     */
    @Override
    public void widgetClick(View v) {

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
     * 重写物理按键
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            handler.removeCallbacks(toMain);
            handler.removeCallbacks(toWeb);
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 获取启动图片
     */
    @Override
    public void getSplashImg() {
        splashPresenter.getSplashImg();
    }

    /**
     * 检查混合应用
     */
    @Override
    public void checkHybrid() {
        splashPresenter.checkHybrid();
    }

    /**
     * 设置启动图片
     * @param url
     */
    @Override
    public void setSplashImg(String url) {
        ImageOptions imageOptions = new ImageOptions.Builder()
                .setImageScaleType(ImageView.ScaleType.CENTER_CROP)
                .setLoadingDrawableId(R.mipmap.splash_bg)
                .setPlaceholderScaleType(ImageView.ScaleType.CENTER_CROP)
                .setFailureDrawableId(R.mipmap.splash_bg)
                .build();
        x.image().bind(splashImg, url, imageOptions);
    }

    /**
     * 设置混合应用
     * @param url
     */
    @Override
    public void setHybrid(String url) {
        webUrl = url;
        handler.postDelayed(toWeb, SPLASH_DISPLAY_DURATION);
    }

    /**
     * 设置原生应用
     */
    @Override
    public void setNative() {
        handler.postDelayed(toMain, SPLASH_DISPLAY_DURATION);
    }
}
