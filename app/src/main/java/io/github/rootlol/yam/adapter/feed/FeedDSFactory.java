/*
 * Copyright © 2020 . Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yam.adapter.feed;

import android.accounts.AccountManager;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.paging.DataSource;
import androidx.paging.PositionalDataSource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.github.rootlol.yam.App;
import io.github.rootlol.yam.account.AccountUtils;
import io.github.rootlol.yam.adapter.feed.item.ItemDaysEventsRTBAFH;
import io.github.rootlol.yam.adapter.feed.item.ItemGeneratedplaylists;
import io.github.rootlol.yam.controller.home.FeedSubHome;
import io.github.rootlol.yam.tools.CacheTool;
import io.github.rootlol.yam.tools.NetTool;
import io.github.rootlol.yamadapter.YamAdapterInterface;
import io.github.rootlol.yamadapter.YamDataSourceFactory;
import io.github.rootlol.yamadapter.YamVHFactory;
import io.github.rootlol.yandexmusic.ApiMusic;
import io.github.rootlol.yandexmusic.pojo.feed.Event;
import io.github.rootlol.yandexmusic.pojo.feed.GeneratedPlaylist;
import io.github.rootlol.yandexmusic.pojo.feed.PojoFeed;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FeedDSFactory extends YamDataSourceFactory {
    private Context context;
    private boolean refresh;
    private FeedVHFactory feedVHFactory;

    public FeedDSFactory(Context context, boolean refresh) {
        this.context = context;
        this.refresh = refresh;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public DataSource create() {
        if (NetTool.isOnline(context) && refresh) {
            return new FeedDataSourseNet();
        }
        if (NetTool.isOnline(context) && CacheTool.getTimeCache("feed.json", 300000)) {
            return new FeedDataSourseNet();
        }
        return new FeedDataSourseCache();
    }

    @Override
    public YamVHFactory getVHFactory() {
        if (feedVHFactory == null){
            feedVHFactory = new FeedVHFactory();
        }
        return feedVHFactory;
    }

    public class FeedDataSourseNet extends PositionalDataSource<YamAdapterInterface> {

        @SuppressLint("WrongThread")
        @Override
        public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback<YamAdapterInterface> Acallback) {

            ApiMusic.getInstance().getFeed(AccountManager.get(context).peekAuthToken(App.getAccount(), AccountUtils.AUTH_TOKEN_TYPE)).enqueue(new Callback<PojoFeed>() {
                @Override
                public void onResponse(Call<PojoFeed> call, Response<PojoFeed> response) {
                    FeedSubHome.setSRL(false);
                    List<YamAdapterInterface> tempList = new ArrayList<>();

                    for (GeneratedPlaylist gplaylist: response.body().getResult().getGeneratedPlaylists()) {
                        tempList.add(new ItemGeneratedplaylists(gplaylist));
                    }
                    for (Event event: response.body().getResult().getDays().get(0).getEvents() ) {
                        if (event.getType().equals("recommended-tracks-by-artist-from-history"))
                        tempList.add(new ItemDaysEventsRTBAFH(event));
                    }

                    //App.setTempFeed(tempList);

                    try {
                        CacheTool.setCache("feed.json", tempList, getVHFactory());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    List<YamAdapterInterface> qqq = new ArrayList<>();
                    for (int i = 0; i < params.pageSize; i++) {
                        qqq.add(tempList.get(i));
                    }
                    Acallback.onResult(qqq, 0);


                }

                @Override
                public void onFailure(Call<PojoFeed> call, Throwable t) {
                    FeedSubHome.setSRL(false);
                    Toast.makeText(context, "no net", Toast.LENGTH_LONG).show();
                    Acallback.onResult(new ArrayList<>(), 0);
                }
            });
        }

        @Override
        public void loadRange(@NonNull LoadRangeParams params, @NonNull LoadRangeCallback<YamAdapterInterface> callback) {
            List<YamAdapterInterface> tempList = new ArrayList<>();
            try {
                List<YamAdapterInterface> temp = CacheTool.getCache("feed.json", getVHFactory());
                for (int i = params.startPosition; i < params.startPosition+params.loadSize && i<temp.size(); i++) {
                    tempList.add(temp.get(i));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            callback.onResult(tempList);
        }
    }

    public class FeedDataSourseCache extends PositionalDataSource<YamAdapterInterface> {

        @SuppressLint("WrongThread")
        @Override
        public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback<YamAdapterInterface> callback) {
            List<YamAdapterInterface> tempList = new ArrayList<>();
            try {
                List<YamAdapterInterface> temp = CacheTool.getCache("feed.json", getVHFactory());
                for (int i = 0; i < params.pageSize && i<temp.size(); i++) {
                    tempList.add(temp.get(i));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            FeedSubHome.setSRL(false);
            callback.onResult(tempList, 0);
        }

        @Override
        public void loadRange(@NonNull LoadRangeParams params, @NonNull LoadRangeCallback<YamAdapterInterface> callback) {
            List<YamAdapterInterface> tempList = new ArrayList<>();
            try {
                List<YamAdapterInterface> temp = CacheTool.getCache("feed.json", getVHFactory());
                for (int i = params.startPosition; i < params.startPosition+params.loadSize && i<temp.size(); i++) {
                    tempList.add(temp.get(i));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            FeedSubHome.setSRL(false);
            callback.onResult(tempList);
        }
    }
}
