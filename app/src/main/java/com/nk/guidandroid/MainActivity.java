package com.nk.guidandroid;

import android.net.http.SslError;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.nk.guidandroid.adapter.NewsAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    WebView mWebView;
    String[] urls = {"http://www.yidianzixun.com/article/0MBrp986", "http://www.yidianzixun.com/article/0MC9G9Kb",
            "http://www.yidianzixun.com/article/0MBe57Ss", "http://www.yidianzixun.com/article/0MBe2Mrz",
            "http://www.yidianzixun.com/article/0MC9Ax0k", "http://www.yidianzixun.com/article/0MBZdtUL",
            "http://www.yidianzixun.com/article/0MBQN6PI", "http://www.yidianzixun.com/article/0MB6SOCL",
            "http://www.yidianzixun.com/article/0MA8nDfU"};
    private List<NewsAdapter.Item> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        setWeb();
//        setmWebView();
    }

    private void setmWebView(){
//        mWebView = findViewById(R.id.m_web);
        mWebView.setWebViewClient(new WebViewClient(){
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                Log.e("onReceivedError", error.getDescription().toString());
            }

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
                super.onReceivedHttpError(view, request, errorResponse);
                Log.e("onReceivedHttpError", errorResponse.getStatusCode() + "");
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                super.onReceivedSslError(view, handler, error);
                Log.e("onReceivedSslError", error.getUrl());
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
                Log.e("onReceivedError", description);
            }
        });
        mWebView.loadUrl("");
    }

    private void initData(){
        for (String url: urls){
            NewsAdapter.Item item = new NewsAdapter.Item();
            item.url = url;
            items.add(item);
        }
    }

    private void setWeb(){
        mRecyclerView = findViewById(R.id.rv);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(mRecyclerView);
        NewsAdapter adapter = new NewsAdapter(items, this);
        mRecyclerView.setAdapter(adapter);
    }
}
