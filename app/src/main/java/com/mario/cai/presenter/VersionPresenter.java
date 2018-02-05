package com.mario.cai.presenter;

import android.content.Context;

import com.love_cookies.cookie_library.interfaces.CallBack;
import com.mario.cai.mobile.bean.ChangeLogBean;
import com.mario.cai.mobile.biz.ChangeLogBiz;
import com.mario.cai.view.interfaces.IVersion;

/**
 * Created by mario on 2016/12/20 0020.
 *
 * 版本信息Presenter
 */
public class VersionPresenter {

    private ChangeLogBiz changeLogBiz;
    private IVersion iVersion;

    public VersionPresenter(IVersion iVersion) {
        changeLogBiz = new ChangeLogBiz();
        this.iVersion = iVersion;
    }

    /**
     * 获取ChangeLog
     * @param context
     */
    public void getChangeLog(Context context) {
        changeLogBiz.getChangeLog(context, new CallBack() {
            @Override
            public void onSuccess(Object result) {
                iVersion.setChangeLog((ChangeLogBean)result);
            }

            @Override
            public void onFailed(Object msg) {
            }
        });
    }

}
