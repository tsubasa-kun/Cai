package com.mario.cai.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.love_cookies.cookie_library.activity.BaseActivity;
import com.love_cookies.cookie_library.utils.NetworkUtils;
import com.love_cookies.cookie_library.utils.ToastUtils;
import com.love_cookies.cookie_library.widget.CookieTitleBar;
import com.mario.cai.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

/**
 * Created by mario on 2018/2/7.
 *
 * 意见反馈页
 */
@ContentView(R.layout.activity_feedback)
public class FeedbackActivity extends BaseActivity {

    @ViewInject(R.id.title_bar)
    private CookieTitleBar titleBar;
    @ViewInject(R.id.feedback)
    private EditText feedbackEt;
    @ViewInject(R.id.contact)
    private EditText contactEt;
    @ViewInject(R.id.submit_btn)
    private Button submitBtn;

    private String feedback;
    private String contact;

    /**
     * 初始化控件
     * @param savedInstanceState
     */
    @Override
    public void initWidget(Bundle savedInstanceState) {
        titleBar.setTitle(R.string.feedback_title);
        titleBar.setLeftImageResource(R.drawable.ic_back);
        titleBar.setLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        submitBtn.setOnClickListener(this);
    }

    /**
     * 控件点击事件
     * @param view
     */
    @Override
    public void widgetClick(View view) {
        if (dataIsValid()) {
            //TODO 提交
        }
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
     * 校验数据合法性
     * @return
     */
    public boolean dataIsValid() {
        boolean valid = false;
        feedback = feedbackEt.getText().toString().trim();
        contact = contactEt.getText().toString().trim();
        if (feedback == null || feedback.length() <= 0) {
            ToastUtils.show(this, R.string.feedback_tip);
        } else if (contact == null || contact.length() <= 0) {
            ToastUtils.show(this, R.string.contact_tip);
        } else {
            valid = true;
        }
        return valid;
    }
}
