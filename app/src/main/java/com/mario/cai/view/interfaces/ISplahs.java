package com.mario.cai.view.interfaces;

/**
 * Created by mario on 2018/2/24.
 *
 * 启动页 View接口
 */

public interface ISplahs {
    /**
     * 获取启动图片
     */
    void getSplashImg();

    /**
     * 检查混合应用
     */
    void checkHybrid();

    /**
     * 设置启动图片
     * @param url
     */
    void setSplashImg(String url);

    /**
     * 设置混合应用
     * @param url
     */
    void setHybrid(String url);

    /**
     * 设置原生应用
     */
    void setNative();
}
