/*
 * Copyright © 2020 . Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yam.controller.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bluelinelabs.conductor.Controller;

import io.github.rootlol.yam.R;
import io.github.rootlol.yam.adapter.YamAdapter;
import io.github.rootlol.yam.adapter.factory.feed.FeedDSFactory;

public class FeedSubHome extends Controller implements SwipeRefreshLayout.OnRefreshListener{

    private static SwipeRefreshLayout SRL;
    private RecyclerView PRV;

    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        View view = inflater.inflate(R.layout.controller_home_feed, container, false);
        bind(view);
        setView();
        return view;
    }

    private void setView(){
        SRL.setRefreshing(true);
        YamAdapter adapter = new YamAdapter((AppCompatActivity) getActivity(), new FeedDSFactory(SRL, getApplicationContext()));
        PRV.setAdapter(adapter);
    }

    private void bind(View view){
        SRL = view.findViewById(R.id.c_home_feed_srl_refresh);
        SRL.setOnRefreshListener(this);
        PRV = view.findViewById(R.id.c_home_feed_rv_list);
        PRV.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        PRV.setHasFixedSize(true);
    }

    public static void setSRL(boolean www){
        if (SRL != null) SRL.setRefreshing(www);
    }

    //implement

    //SwipeRefreshLayout
    // - OnRefreshListener
    @Override
    public void onRefresh() {
        setView();
    }

    //FeedAdapter
    // - generatedPlaylists
}
