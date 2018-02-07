package com.mario.cai.view.interfaces;

import com.mario.cai.mobile.bean.CaiBean;

/**
 * Created by mario on 2018/2/7.
 *
 * 彩票详情页 View接口
 */

public interface ICaiDetail {
    /**
     * 获取彩票列表
     * @param api
     */
    void getCaiList(String api);

    /**
     * 设置彩票列表
     * @param caiBean
     */
    void setCaiList(CaiBean caiBean);

    /**
     * 请求失败
     */
    void requestFailed();
}
