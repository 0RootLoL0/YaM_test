/*
 * Copyright © 2020 . Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yam.adapter.feed;

import android.accounts.AccountManager;
import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.paging.DataSource;
import androidx.paging.PositionalDataSource;

import java.util.ArrayList;
import java.util.List;

import io.github.rootlol.yam.App;
import io.github.rootlol.yam.account.AccountUtils;
import io.github.rootlol.yam.adapter.feed.item.ItemDaysEventsRTBAFH;
import io.github.rootlol.yam.controller.home.FeedSubHome;
import io.github.rootlol.yamadapter.YamAdapterInterface;
import io.github.rootlol.yamadapter.YamDataSourceFactory;
import io.github.rootlol.yamadapter.YamVHFactory;
import io.github.rootlol.yamadapter.item.ItemPlaylist;
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

    @Override
    public DataSource create() {
        return new FeedDataSourseNet();
    }

    @Override
    public YamVHFactory getVHFactory() {
        if (feedVHFactory == null){
            feedVHFactory = new FeedVHFactory();
        }
        return feedVHFactory;
    }

    public class FeedDataSourseNet extends PositionalDataSource<YamAdapterInterface> {
        List<YamAdapterInterface> tempLists;
        @SuppressLint("WrongThread")
        @Override
        public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback<YamAdapterInterface> Acallback) {

            ApiMusic.getInstance().getFeed(AccountManager.get(context).peekAuthToken(App.getAccount(), AccountUtils.AUTH_TOKEN_TYPE)).enqueue(new Callback<PojoFeed>() {
                @Override
                public void onResponse(Call<PojoFeed> call, Response<PojoFeed> response) {
                    FeedSubHome.setSRL(false);
                    List<YamAdapterInterface> tempList = new ArrayList<>();

                    for (GeneratedPlaylist gplaylist: response.body().getResult().getGeneratedPlaylists()) {
                        tempList.add(new ItemPlaylist(
                                Uri.parse("https://"+gplaylist.getData().getOgImage().replace("%%", "200x200")),
                                gplaylist.getData().getTitle(),
                                gplaylist.getData().getDescription()
                        ));
                    }
                    for (Event event: response.body().getResult().getDays().get(0).getEvents() ) {
                        if (event.getType().equals("recommended-tracks-by-artist-from-history"))
                        tempList.add(new ItemDaysEventsRTBAFH(event));
                    }

                    tempLists = tempList;


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
            for (int i = params.startPosition; i < params.startPosition+params.loadSize && i<tempLists.size(); i++) {
                tempList.add(tempLists.get(i));
            }
            callback.onResult(tempList);
        }
    }
}
