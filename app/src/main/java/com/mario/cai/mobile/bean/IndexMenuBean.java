package com.mario.cai.mobile.bean;

/**
 * Created by mario 2018/2/7.
 *
 * 主页菜单实体类
 */

public class IndexMenuBean {
    private String imgUrl;
    private String mainLabel;
    private String subLabel;
    private String api;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getMainLabel() {
        return mainLabel;
    }

    public void setMainLabel(String mainLabel) {
        this.mainLabel = mainLabel;
    }

    public String getSubLabel() {
        return subLabel;
    }

    public void setSubLabel(String subLabel) {
        this.subLabel = subLabel;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }
}
