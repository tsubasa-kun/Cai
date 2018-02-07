package com.mario.cai.view.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.love_cookies.cookie_library.adapter.CommonAdapter;
import com.love_cookies.cookie_library.adapter.CommonViewHolder;
import com.love_cookies.cookie_library.fragment.BaseFragment;
import com.love_cookies.cookie_library.utils.NetworkUtils;
import com.love_cookies.cookie_library.widget.CookieTitleBar;
import com.mario.cai.R;
import com.mario.cai.config.AppConfig;
import com.mario.cai.mobile.bean.IndexMenuBean;
import com.mario.cai.view.activity.CaiDetailActivity;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mario on 2018/02/05 0005.
 *
 * 开奖页
 */
@ContentView(R.layout.fragment_index)
public class IndexFragment extends BaseFragment {

    @ViewInject(R.id.title_bar)
    private CookieTitleBar titleBar;
    @ViewInject(R.id.grid_view)
    private GridView gridView;

    private List<IndexMenuBean> menus = new ArrayList<>();
    private CommonAdapter<IndexMenuBean> menuAdapter;

    /**
     * 初始化控件
     * @param savedInstanceState
     */
    @Override
    public void initWidget(Bundle savedInstanceState) {
        titleBar.setTitle(R.string.main_tab_index);
        initMenuData();
        menuAdapter = new CommonAdapter<IndexMenuBean>(getActivity(), R.layout.item_grid_view, menus) {
            @Override
            public void convert(CommonViewHolder holder, IndexMenuBean indexMenuBean) {
                if (!indexMenuBean.getMainLabel().isEmpty()) {
                    holder.setRoundImage(R.id.icon, indexMenuBean.getImgUrl());
                    holder.setText(R.id.main_label, indexMenuBean.getMainLabel());
                    holder.setText(R.id.sub_label, indexMenuBean.getSubLabel());
                }
            }
        };
        gridView.setAdapter(menuAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (!menus.get(i).getMainLabel().isEmpty()) {
                    Bundle bundle = new Bundle();
                    bundle.putString("title", menus.get(i).getMainLabel());
                    bundle.putString("api", menus.get(i).getApi());
                    turn(CaiDetailActivity.class, bundle);
                }
            }
        });
    }

    /**
     * 控件点击事件
     * @param view
     */
    @Override
    public void widgetClick(View view) {

    }

    /**
     * 网络连接了
     * @param type
     */
    @Override
    public void netConnected(NetworkUtils.NetworkType type) {

    }

    /**
     * 网络断开了
     */
    @Override
    public void netDisConnected() {

    }

    /**
     * 初始化菜单数据
     */
    public void initMenuData() {
        IndexMenuBean dlt = new IndexMenuBean();
        dlt.setImgUrl("");
        dlt.setMainLabel("大乐透");
        dlt.setSubLabel("奖池超42亿");
        dlt.setApi(AppConfig.API.DLT);
        menus.add(dlt);

        IndexMenuBean ssq = new IndexMenuBean();
        ssq.setImgUrl("");
        ssq.setMainLabel("双色球");
        ssq.setSubLabel("大奖等你拿");
        ssq.setApi(AppConfig.API.SSQ);
        menus.add(ssq);

        IndexMenuBean fc3d = new IndexMenuBean();
        fc3d.setImgUrl("");
        fc3d.setMainLabel("福彩3D");
        fc3d.setSubLabel("简单赢千元");
        fc3d.setApi(AppConfig.API.FC3D);
        menus.add(fc3d);

        IndexMenuBean pl3 = new IndexMenuBean();
        pl3.setImgUrl("");
        pl3.setMainLabel("排列3");
        pl3.setSubLabel("加奖千万元");
        pl3.setApi(AppConfig.API.PL3);
        menus.add(pl3);

        IndexMenuBean pl5 = new IndexMenuBean();
        pl5.setImgUrl("");
        pl5.setMainLabel("排列5");
        pl5.setSubLabel("单注赢千元");
        pl5.setApi(AppConfig.API.PL5);
        menus.add(pl5);

        IndexMenuBean qlc = new IndexMenuBean();
        qlc.setImgUrl("");
        qlc.setMainLabel("七乐彩");
        qlc.setSubLabel("公益献爱心");
        qlc.setApi(AppConfig.API.QLC);
        menus.add(qlc);

        IndexMenuBean qxc = new IndexMenuBean();
        qxc.setImgUrl("");
        qxc.setMainLabel("七星彩");
        qxc.setSubLabel("定期开奖");
        qxc.setApi(AppConfig.API.QXC);
        menus.add(qxc);

        IndexMenuBean nul = new IndexMenuBean();
        nul.setImgUrl("");
        nul.setMainLabel("");
        nul.setSubLabel("");
        nul.setApi("");
        menus.add(nul);
    }
}
