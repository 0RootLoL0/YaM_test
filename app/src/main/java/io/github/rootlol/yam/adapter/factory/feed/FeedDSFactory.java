/*
 * Copyright © 2020 . Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yam.adapter.factory.feed;

import android.accounts.AccountManager;
import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.paging.DataSource;
import androidx.paging.PositionalDataSource;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import io.github.rootlol.yam.App;
import io.github.rootlol.yam.account.AccountUtils;
import io.github.rootlol.yam.adapter.YamAdapterInterface;
import io.github.rootlol.yam.adapter.YamDataSourceFactory;
import io.github.rootlol.yam.adapter.YamVHFactory;
import io.github.rootlol.yam.adapter.factory.feed.item.ItemDaysEventsRTBAFH;
import io.github.rootlol.yam.adapter.factory.feed.item.ItemGeneratedplaylists;
import io.github.rootlol.yam.controller.home.FeedSubHome;
import io.github.rootlol.yam.tools.NetTool;
import io.github.rootlol.yandexmusic.ApiMusic;
import io.github.rootlol.yandexmusic.pojo.feed.Event;
import io.github.rootlol.yandexmusic.pojo.feed.GeneratedPlaylist;
import io.github.rootlol.yandexmusic.pojo.feed.PojoFeed;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FeedDSFactory extends YamDataSourceFactory {
    private SwipeRefreshLayout SRL;
    private Context context;

    public FeedDSFactory(SwipeRefreshLayout SRL, Context context) {
        this.SRL = SRL;
        this.context = context;
    }

    @Override
    public DataSource create() {
        if (NetTool.isOnline(context)) { //TODO: add cashe cek
            return new FeedDataSourseNet();
        }
        FeedSubHome.setSRL(false);
        return new FeedDataSourseCache();
    }

    @Override
    public YamVHFactory getVHFactory() {
        return new FeedVHFactory();
    }

    @Override
    public Object getOnClick() {
        return null;
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
           /* for (int i = params.startPosition; i < params.startPosition+params.loadSize&&i<App.getTempFeed().size(); i++) {
                tempList.add(App.getTempFeed().get(i));
            }*/
            callback.onResult(tempList);
        }
    }

    public class FeedDataSourseCache extends PositionalDataSource<YamAdapterInterface> {

        @SuppressLint("WrongThread")
        @Override
        public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback<YamAdapterInterface> callback) {
            List<YamAdapterInterface> tempList = new ArrayList<>();
            /*if (App.getTempFeed()!=null) {
                for (int i = 0; i < params.pageSize; i++) {
                    tempList.add(App.getTempFeed().get(i));
                }
            }*/
            callback.onResult(tempList, 0);
        }

        @Override
        public void loadRange(@NonNull LoadRangeParams params, @NonNull LoadRangeCallback<YamAdapterInterface> callback) {
            //Log.i(App.APP_ID, "loadRange: "+App.getTempFeed().size());
            List<YamAdapterInterface> tempList = new ArrayList<>();
/*            for (int i = params.startPosition; i < params.startPosition+params.loadSize&&i<App.getTempFeed().size(); i++) {
                tempList.add(App.getTempFeed().get(i));
            }*/
            callback.onResult(tempList);
        }
    }
}
