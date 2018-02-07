package com.mario.cai.mobile.biz;

import com.google.gson.Gson;
import com.love_cookies.cookie_library.interfaces.CallBack;
import com.mario.cai.mobile.bean.CaiBean;
import com.mario.cai.mobile.biz.interfaces.ICaiDetailBiz;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by mario on 2018/2/7.
 *
 * 彩票详情逻辑
 */

public class CaiDetailBiz implements ICaiDetailBiz {

    /**
     * 获取彩票列表
     * @param api
     * @param callBack
     */
    @Override
    public void getCaiList(String api, final CallBack callBack) {
        RequestParams requestParams = new RequestParams(api);
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                CaiBean caiBean = gson.fromJson(result, CaiBean.class);
                callBack.onSuccess(caiBean);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                callBack.onFailed(null);
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
}
