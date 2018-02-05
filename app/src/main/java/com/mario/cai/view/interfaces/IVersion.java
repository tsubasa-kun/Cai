package com.mario.cai.view.interfaces;

import com.mario.cai.mobile.bean.ChangeLogBean;

/**
 * Created by mario on 2016/12/20 0020.
 *
 * 版本信息页 View接口
 */
public interface IVersion {

    /**
     * 获取版本
     * @return
     */
    String getVersion();

    /**
     * 获取ChangeLog
     */
    void getChangeLog();

    /**
     * 设置ChangeLog
     * @param changeLogBean
     */
    void setChangeLog(ChangeLogBean changeLogBean);

}
