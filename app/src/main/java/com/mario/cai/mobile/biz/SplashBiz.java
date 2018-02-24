package com.mario.cai.mobile.biz;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.FindCallback;
import com.love_cookies.cookie_library.interfaces.CallBack;
import com.mario.cai.mobile.biz.interfaces.ISplashBiz;

import java.util.List;

/**
 * Created by mario on 2018/2/24.
 *
 * 启动页逻辑
 */

public class SplashBiz implements ISplashBiz {

    /**
     * 获取启动图片
     * @param callBack
     */
    @Override
    public void getSplashImg(final CallBack callBack) {
        AVQuery<AVObject> avQuery = new AVQuery<>("Splash");
        avQuery.findInBackground(new FindCallback<AVObject>() {
            @Override
            public void done(List<AVObject> list, AVException e) {
                if (list != null && list.size() >0) {
                    String url = list.get(0).getString("url");
                    callBack.onSuccess(url);
                } else {
                    callBack.onSuccess(null);
                }
            }
        });
    }

    /**
     * 检查混合应用
     * @param callBack
     */
    @Override
    public void checkHybrid(final CallBack callBack) {
        AVQuery<AVObject> avQuery = new AVQuery<>("Hybrid");
        avQuery.findInBackground(new FindCallback<AVObject>() {
            @Override
            public void done(List<AVObject> list, AVException e) {
                if (list != null && list.size() >0) {
                    Boolean enable = list.get(0).getBoolean("enable");
                    String url = list.get(0).getString("url");
                    if (enable) {
                        callBack.onSuccess(url);
                    } else {
                        callBack.onFailed(null);
                    }
                } else {
                    callBack.onFailed(null);
                }
            }
        });
    }
}
