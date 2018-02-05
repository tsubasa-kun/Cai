package com.mario.cai.app;

import android.widget.ImageView;

import com.love_cookies.cookie_library.application.BaseApplication;
import com.love_cookies.cookie_library.utils.SDCardUtils;
import com.love_cookies.cookie_library.utils.ScreenUtils;

import org.xutils.image.ImageOptions;

import java.io.File;

/**
 * Created by mario on 2016/12/20 0020.
 *
 * CaiApplication
 */
public class CaiApplication extends BaseApplication {

    //一般图片设置
    public static ImageOptions NormalImageOptions = null;
    //一般图片设置-淡入
    public static ImageOptions NormalFadeInImageOptions = null;
    //圆形图片设置
    public static ImageOptions RoundImageOptions = null;
    //方形圆角图片设置
    public static ImageOptions SquareRadiusImageOptions = null;

    //图片文件夹路径
    public static final String FILE_PATH = SDCardUtils.getSDCardPath() + "Cai/Images/";

    @Override
    public void onCreate() {
        super.onCreate();
        initImageOptions();
        initFolder();
    }

    /**
     * 初始化图片设置
     */
    public void initImageOptions() {
        NormalImageOptions = new ImageOptions.Builder()
                .setImageScaleType(ImageView.ScaleType.CENTER_CROP)
                .build();

        NormalFadeInImageOptions = new ImageOptions.Builder()
                .setImageScaleType(ImageView.ScaleType.CENTER_CROP)
                .setFadeIn(true)
                .build();

        RoundImageOptions = new ImageOptions.Builder()
                .setImageScaleType(ImageView.ScaleType.CENTER_CROP)
                .setCircular(true)
                .build();

        SquareRadiusImageOptions = new ImageOptions.Builder()
                .setImageScaleType(ImageView.ScaleType.CENTER_CROP)
                .setSquare(true)
                .setRadius(ScreenUtils.dp2px(this, 12))
                .build();
    }

    /**
     * 初始化文件夹
     */
    public void initFolder() {
        File dir = new File(FILE_PATH);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

}
