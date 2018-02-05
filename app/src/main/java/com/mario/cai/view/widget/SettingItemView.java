package com.mario.cai.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.mario.cai.R;

/**
 * Created by mario on 2016/12/20 0020.
 *
 * 设置页的Item
 */
public class SettingItemView extends FrameLayout {

    ImageView itemIcon;
    TextView itemTitle;

    public SettingItemView(Context context) {
        super(context);
    }

    public SettingItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initLayout(context, attrs);
    }

    public SettingItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initLayout(context, attrs);
    }

    public SettingItemView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initLayout(context, attrs);
    }

    private void initLayout(Context context, AttributeSet attrs) {
        LayoutInflater factory = LayoutInflater.from(context);
        factory.inflate(R.layout.view_setting_item, this);

        itemIcon = (ImageView)findViewById(R.id.item_icon);
        itemTitle = (TextView)findViewById(R.id.item_title);

        TypedArray typedArray = context.obtainStyledAttributes(attrs,
                R.styleable.SettingItem);

//        Drawable icon = typedArray.getDrawable(R.styleable.HomeItem_Icon);
//        itemIcon.setImageDrawable(icon);

        CharSequence title = typedArray.getText(R.styleable.SettingItem_Title);
        itemTitle.setText(title);
    }

}
