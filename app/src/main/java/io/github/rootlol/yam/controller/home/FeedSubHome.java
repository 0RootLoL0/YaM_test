/*
 * Copyright © 2020 . Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yam.controller.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.RouterTransaction;

import io.github.rootlol.yam.App;
import io.github.rootlol.yam.R;
import io.github.rootlol.yam.adapter.feed.FeedAdapter;
import io.github.rootlol.yam.adapter.feed.FeedAdapterInterface;
import io.github.rootlol.yam.adapter.feed.FeedDataSourseFactory;
import io.github.rootlol.yam.controller.HomeController;
import io.github.rootlol.yam.controller.TrackeController;
import io.github.rootlol.yam.tools.NetTool;
import io.github.rootlol.yandexmusic.pojo.feed.GeneratedPlaylist;

public class FeedSubHome extends Controller implements SwipeRefreshLayout.OnRefreshListener, FeedAdapter.onClickFeed.onClickListenerFeed{

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
        FeedAdapter adapter = new FeedAdapter();
        adapter.getItemListener().setOnClickListenerGeneratedPlaylists(this);
        LiveData<PagedList<FeedAdapterInterface>> pagedListLiveData = new LivePagedListBuilder<>(new FeedDataSourseFactory(NetTool.isOnline(getApplicationContext()), SRL, getApplicationContext()), App.getConfig()).build();
        pagedListLiveData.observe((AppCompatActivity) getActivity(), new Observer<PagedList<FeedAdapterInterface>>() {
            @Override
            public void onChanged(@Nullable PagedList<FeedAdapterInterface> playlistListInterfaces) {
                adapter.submitList(playlistListInterfaces);
            }
        });
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
    @Override
    public void onItemGeneratedPlaylistsClick(GeneratedPlaylist model, int position) {
        HomeController.getIntens().getRouter().pushController(RouterTransaction.with(new TrackeController(model)));
    }
    @Override
    public void onItemSettingsGeneratedPlaylistsClick(GeneratedPlaylist model, int position) {

    }
}
