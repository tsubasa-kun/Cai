package com.mario.cai.mobile.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mario on 2018/2/23.
 *
 * 新闻资讯实体类
 */

public class NewsListBean implements Parcelable {

    private List<NewsBean> news;

    public List<NewsBean> getNews() {
        return news;
    }

    public void setNews(List<NewsBean> news) {
        this.news = news;
    }

    public static class NewsBean implements Parcelable {
        private String imgUrl;
        private String title;
        private String content;
        private String time;

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public NewsBean() {
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.imgUrl);
            dest.writeString(this.title);
            dest.writeString(this.content);
            dest.writeString(this.time);
        }

        protected NewsBean(Parcel in) {
            this.imgUrl = in.readString();
            this.title = in.readString();
            this.content = in.readString();
            this.time = in.readString();
        }

        public static final Creator<NewsBean> CREATOR = new Creator<NewsBean>() {
            @Override
            public NewsBean createFromParcel(Parcel source) {
                return new NewsBean(source);
            }

            @Override
            public NewsBean[] newArray(int size) {
                return new NewsBean[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.news);
    }

    public NewsListBean() {
    }

    protected NewsListBean(Parcel in) {
        this.news = new ArrayList<NewsBean>();
        in.readList(this.news, NewsBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<NewsListBean> CREATOR = new Parcelable.Creator<NewsListBean>() {
        @Override
        public NewsListBean createFromParcel(Parcel source) {
            return new NewsListBean(source);
        }

        @Override
        public NewsListBean[] newArray(int size) {
            return new NewsListBean[size];
        }
    };
}
