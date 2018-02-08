package com.mario.cai.view.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.love_cookies.cookie_library.adapter.CommonAdapter;
import com.love_cookies.cookie_library.adapter.CommonViewHolder;
import com.love_cookies.cookie_library.fragment.BaseFragment;
import com.love_cookies.cookie_library.utils.NetworkUtils;
import com.love_cookies.cookie_library.widget.CookieTitleBar;
import com.love_cookies.cookie_library.widget.MeasuredGridView;
import com.mario.cai.R;
import com.mario.cai.app.CaiApplication;
import com.mario.cai.config.AppConfig;
import com.mario.cai.mobile.bean.IndexMenuBean;
import com.mario.cai.view.activity.CaiDetailActivity;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

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
    @ViewInject(R.id.view_pager)
    private ViewPager viewPager;
    @ViewInject(R.id.dot_1)
    private ImageView dot1;
    @ViewInject(R.id.dot_2)
    private ImageView dot2;
    @ViewInject(R.id.dot_3)
    private ImageView dot3;
    @ViewInject(R.id.grid_view)
    private MeasuredGridView gridView;

    private Handler handler;
    private int item = -1;
    private int AD_DISPLAY_DURATION = 3 * 1000;//广告切换时间-毫秒
    private List<String> imageList = new ArrayList<>();
    private ViewPagerAdapter viewPagerAdapter;

    private List<IndexMenuBean> menus = new ArrayList<>();
    private CommonAdapter<IndexMenuBean> menuAdapter;

    /**
     * 初始化控件
     * @param savedInstanceState
     */
    @Override
    public void initWidget(Bundle savedInstanceState) {
        titleBar.setTitle(R.string.main_tab_index);
        initBannerData();
        viewPagerAdapter = new ViewPagerAdapter();
        viewPager.setAdapter(viewPagerAdapter);
        //广告自动轮播
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        viewPager.setCurrentItem((viewPager.getCurrentItem() + 1) % imageList.size());
                    }
                }, AD_DISPLAY_DURATION);
                dot1.setImageResource(R.mipmap.dot_off);
                dot2.setImageResource(R.mipmap.dot_off);
                dot3.setImageResource(R.mipmap.dot_off);
                switch (position) {
                    case 0:
                        dot1.setImageResource(R.mipmap.dot_on);
                        break;
                    case 1:
                        dot2.setImageResource(R.mipmap.dot_on);
                        break;
                    case 2:
                        dot3.setImageResource(R.mipmap.dot_on);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                switch (state) {
                    case ViewPager.SCROLL_STATE_DRAGGING:
                        handler.removeCallbacksAndMessages(null);
                        item = viewPager.getCurrentItem();
                        break;
                    case ViewPager.SCROLL_STATE_IDLE:
                        if (item == viewPager.getCurrentItem()) {
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    viewPager.setCurrentItem((viewPager.getCurrentItem() + 1) % imageList.size());
                                }
                            }, AD_DISPLAY_DURATION);
                        }
                        item = -1;
                        break;
                    case ViewPager.SCROLL_STATE_SETTLING:
                        break;
                }
            }
        });

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
                if (!menus.get(i).getApi().isEmpty()) {
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
     * 初始化轮播图数据
     */
    public void initBannerData() {
        imageList.add("assets://banner1.png");
        imageList.add("assets://banner2.png");
        imageList.add("assets://banner3.png");
    }

    /**
     * 初始化菜单数据
     */
    public void initMenuData() {
        IndexMenuBean dlt = new IndexMenuBean();
        dlt.setImgUrl("assets://banner3.png");
        dlt.setMainLabel("大乐透");
        dlt.setSubLabel("奖池超42亿");
        dlt.setApi(AppConfig.API.DLT);
        menus.add(dlt);

        IndexMenuBean ssq = new IndexMenuBean();
        ssq.setImgUrl("assets://banner3.png");
        ssq.setMainLabel("双色球");
        ssq.setSubLabel("大奖等你拿");
        ssq.setApi(AppConfig.API.SSQ);
        menus.add(ssq);

        IndexMenuBean fc3d = new IndexMenuBean();
        fc3d.setImgUrl("assets://banner3.png");
        fc3d.setMainLabel("福彩3D");
        fc3d.setSubLabel("简单赢千元");
        fc3d.setApi(AppConfig.API.FC3D);
        menus.add(fc3d);

        IndexMenuBean pl3 = new IndexMenuBean();
        pl3.setImgUrl("assets://banner3.png");
        pl3.setMainLabel("排列3");
        pl3.setSubLabel("加奖千万元");
        pl3.setApi(AppConfig.API.PL3);
        menus.add(pl3);

        IndexMenuBean pl5 = new IndexMenuBean();
        pl5.setImgUrl("assets://banner3.png");
        pl5.setMainLabel("排列5");
        pl5.setSubLabel("单注赢千元");
        pl5.setApi(AppConfig.API.PL5);
        menus.add(pl5);

        IndexMenuBean qlc = new IndexMenuBean();
        qlc.setImgUrl("assets://banner3.png");
        qlc.setMainLabel("七乐彩");
        qlc.setSubLabel("公益献爱心");
        qlc.setApi(AppConfig.API.QLC);
        menus.add(qlc);

        IndexMenuBean qxc = new IndexMenuBean();
        qxc.setImgUrl("assets://banner3.png");
        qxc.setMainLabel("七星彩");
        qxc.setSubLabel("定期开奖");
        qxc.setApi(AppConfig.API.QXC);
        menus.add(qxc);

        IndexMenuBean nul = new IndexMenuBean();
        nul.setImgUrl("assets://banner3.png");
        nul.setMainLabel("更多奖种");
        nul.setSubLabel("敬请期待");
        nul.setApi("");
        menus.add(nul);
    }

    /**
     * ViewPager适配器
     */
    public class ViewPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return imageList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView = new ImageView(getActivity());
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            x.image().bind(imageView, imageList.get(position), CaiApplication.NormalImageOptions);
            container.addView(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
            }
        }, AD_DISPLAY_DURATION);
    }

    @Override
    public void onPause() {
        super.onPause();
        handler.removeCallbacksAndMessages(null);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }
}
