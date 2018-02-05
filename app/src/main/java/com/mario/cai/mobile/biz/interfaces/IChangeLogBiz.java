package com.mario.cai.mobile.biz.interfaces;

import android.content.Context;

import com.love_cookies.cookie_library.interfaces.CallBack;

/**
 * Created by mario on 2016/12/20 0020.
 *
 * 更改日志逻辑接口
 */
public interface IChangeLogBiz {

    /**
     * 获取ChangeLog
     * @param context
     * @param callBack
     */
    void getChangeLog(Context context, CallBack callBack);

}
