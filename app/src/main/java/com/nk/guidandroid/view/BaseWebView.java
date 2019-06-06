package com.nk.guidandroid.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.just.agentweb.AgentWebView;
import com.just.agentweb.DefaultWebClient;

public class BaseWebView extends AgentWebView {

    private boolean isEnd = false;
    private boolean isStart = true;
    private boolean isUp = false;
    private float y = 0;

    public BaseWebView(Context context) {
        super(context);
    }

    public BaseWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    {
        setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }
        });
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        // webview的高度
        float webcontent = getContentHeight() * getScale();
        // 当前webview的高度
        float webnow = getHeight() + getScrollY();
        if (Math.abs(webcontent - webnow) < 1) {
            //处于底端
            isEnd = true;
            isStart = false;
        } else if (getScrollY() == 0) {
            //处于顶端
            isEnd = false;
            isStart = true;
        }else {
            isEnd = false;
            isStart = false;
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        boolean b = super.dispatchTouchEvent(ev);
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                requestDisallowInterceptTouchEvent(true);
                b = true;
                break;
            case MotionEvent.ACTION_MOVE:
                if (isUp){//向上滑动
                    if (isEnd) {
                        requestDisallowInterceptTouchEvent(false);
                        b = super.dispatchTouchEvent(ev);
                    }
                }else {//向下滑动
                    if (isStart) {
                        requestDisallowInterceptTouchEvent(false);
                        b = super.dispatchTouchEvent(ev);
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                requestDisallowInterceptTouchEvent(false);
                b = super.dispatchTouchEvent(ev);
                break;
        }
        return b;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                y = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                float cy = event.getY();
                isUp = !(cy >= y + 10);
                break;
        }
        return super.onTouchEvent(event);
    }
}
