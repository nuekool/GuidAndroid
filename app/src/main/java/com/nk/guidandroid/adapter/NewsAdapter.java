package com.nk.guidandroid.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.just.agentweb.AgentWeb;
import com.just.agentweb.AgentWebView;
import com.just.agentweb.NestedScrollAgentWebView;
import com.nk.guidandroid.R;
import com.nk.guidandroid.view.BaseWebView;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder>{

    private List<Item> items;
    private Context activityContext;
    public NewsAdapter(List<Item> items, Context context){
        this.items = items;
        this.activityContext = context;
    }

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(activityContext).inflate(R.layout.news_layout, viewGroup, false);
        return new NewsHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsHolder newsHolder, int i) {
        Item item = items.get(newsHolder.getLayoutPosition());
        newsHolder.web.loadUrl(item.url);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class NewsHolder extends RecyclerView.ViewHolder{
        BaseWebView web;
        public NewsHolder(@NonNull View itemView) {
            super(itemView);
            web = itemView.findViewById(R.id.web);
        }
    }

    public static class Item{
        public String url;
    }
}
