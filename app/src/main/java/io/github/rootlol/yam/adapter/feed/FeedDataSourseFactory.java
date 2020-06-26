/*
 * Copyright © 2020 . Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yam.adapter.feed;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.paging.DataSource;
import androidx.paging.PositionalDataSource;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import io.github.rootlol.yam.App;
import io.github.rootlol.yam.account.AccountUtils;
import io.github.rootlol.yam.adapter.feed.item.ItemGeneratedplaylists;
import io.github.rootlol.yandexmusic.ApiMusic;
import io.github.rootlol.yandexmusic.pojo.feed.GeneratedPlaylist;
import io.github.rootlol.yandexmusic.pojo.feed.PojoFeed;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FeedDataSourseFactory extends DataSource.Factory {
    private static String filename = "feedcache.dump";
    private boolean isOnline;
    private SwipeRefreshLayout SRL;
    private Context context;

    public FeedDataSourseFactory(boolean isOnline, SwipeRefreshLayout SRL, Context context) {
        this.isOnline = isOnline;
        this.SRL = SRL;
        this.context = context;
    }

    @Override
    public DataSource create() {
        if (isOnline) {
            return new FeedDataSourseNet();
        }
        return new FeedDataSourseNet();
    }

    public class FeedDataSourseNet extends PositionalDataSource<FeedAdapterInterface> {
        @SuppressLint("WrongThread")
        @Override
        public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback<FeedAdapterInterface> Acallback) {

            ApiMusic.getInstance().getFeed(AccountManager.get(context).peekAuthToken(App.getAccount(), AccountUtils.AUTH_TOKEN_TYPE)).enqueue(new Callback<PojoFeed>() {
                @Override
                public void onResponse(Call<PojoFeed> call, Response<PojoFeed> response) {
                    SRL.setRefreshing(false);
                    List<FeedAdapterInterface> tempList = new ArrayList<>();

                    for (GeneratedPlaylist gplaylist: response.body().getResult().getGeneratedPlaylists()) {
                        tempList.add(new ItemGeneratedplaylists(gplaylist));
                    }


                    Acallback.onResult(tempList, 0);


                }

                @Override
                public void onFailure(Call<PojoFeed> call, Throwable t) {
                    Acallback.onResult(null, 0);
                }
            });
        }

        @Override
        public void loadRange(@NonNull LoadRangeParams params, @NonNull LoadRangeCallback<FeedAdapterInterface> callback) {
            List<FeedAdapterInterface> tempList = new ArrayList<>();
            callback.onResult(tempList);
        }
    }
}
