package com.mario.cai.mobile.bean;

import java.util.List;

/**
 * Created by mario on 2018/2/7.
 *
 * 彩票实体类
 */

public class CaiBean {

    /**
     * rows : 20
     * code : dlt
     * info : 免费接口随机延迟3-6分钟，实时接口请访问www.opencai.net查询、购买或续费
     * data : [{"expect":"2018016","opencode":"01,02,12,13,23+09,12","opentime":"2018-02-05 20:33:20","opentimestamp":1517834000},{"expect":"2018015","opencode":"04,13,15,18,29+05,11","opentime":"2018-02-03 20:33:20","opentimestamp":1517661200},{"expect":"2018014","opencode":"14,16,18,24,31+01,08","opentime":"2018-01-31 20:33:20","opentimestamp":1517402000},{"expect":"2018013","opencode":"08,24,31,33,35+07,10","opentime":"2018-01-29 20:33:20","opentimestamp":1517229200},{"expect":"2018012","opencode":"03,22,24,29,34+07,11","opentime":"2018-01-27 20:33:20","opentimestamp":1517056400},{"expect":"2018011","opencode":"03,13,15,23,26+01,10","opentime":"2018-01-24 20:33:20","opentimestamp":1516797200},{"expect":"2018010","opencode":"24,25,26,28,29+04,12","opentime":"2018-01-22 20:33:20","opentimestamp":1516624400},{"expect":"2018009","opencode":"10,12,28,30,34+03,04","opentime":"2018-01-20 20:33:20","opentimestamp":1516451600},{"expect":"2018008","opencode":"09,15,17,20,22+10,11","opentime":"2018-01-17 20:33:20","opentimestamp":1516192400},{"expect":"2018007","opencode":"03,04,28,31,34+04,11","opentime":"2018-01-15 20:33:20","opentimestamp":1516019600},{"expect":"2018006","opencode":"19,20,30,32,33+03,05","opentime":"2018-01-13 20:33:20","opentimestamp":1515846800},{"expect":"2018005","opencode":"04,09,23,24,30+08,11","opentime":"2018-01-10 20:33:20","opentimestamp":1515587600},{"expect":"2018004","opencode":"04,09,22,28,30+01,10","opentime":"2018-01-08 20:33:20","opentimestamp":1515414800},{"expect":"2018003","opencode":"04,21,23,24,30+09,10","opentime":"2018-01-06 20:33:20","opentimestamp":1515242000},{"expect":"2018002","opencode":"12,20,23,27,34+01,06","opentime":"2018-01-03 20:33:20","opentimestamp":1514982800},{"expect":"2018001","opencode":"01,13,22,25,35+03,04","opentime":"2018-01-01 20:33:20","opentimestamp":1514810000},{"expect":"2017153","opencode":"01,09,24,26,34+09,12","opentime":"2017-12-30 20:33:20","opentimestamp":1514637200},{"expect":"2017152","opencode":"02,04,07,23,28+02,08","opentime":"2017-12-27 20:33:20","opentimestamp":1514378000},{"expect":"2017151","opencode":"05,06,23,28,32+04,05","opentime":"2017-12-25 20:33:20","opentimestamp":1514205200},{"expect":"2017150","opencode":"03,06,10,13,18+09,11","opentime":"2017-12-23 20:33:20","opentimestamp":1514032400}]
     */

    private int rows;
    private String code;
    private String info;
    private List<DataBean> data;

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * expect : 2018016
         * opencode : 01,02,12,13,23+09,12
         * opentime : 2018-02-05 20:33:20
         * opentimestamp : 1517834000
         */

        private String expect;
        private String opencode;
        private String opentime;
        private int opentimestamp;

        public String getExpect() {
            return expect;
        }

        public void setExpect(String expect) {
            this.expect = expect;
        }

        public String getOpencode() {
            return opencode;
        }

        public void setOpencode(String opencode) {
            this.opencode = opencode;
        }

        public String getOpentime() {
            return opentime;
        }

        public void setOpentime(String opentime) {
            this.opentime = opentime;
        }

        public int getOpentimestamp() {
            return opentimestamp;
        }

        public void setOpentimestamp(int opentimestamp) {
            this.opentimestamp = opentimestamp;
        }
    }
}
