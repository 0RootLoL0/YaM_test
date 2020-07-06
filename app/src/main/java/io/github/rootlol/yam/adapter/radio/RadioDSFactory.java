/*
 * Copyright © 2020 . Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yam.adapter.radio;

import android.accounts.AccountManager;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.paging.DataSource;
import androidx.paging.PositionalDataSource;

import java.util.ArrayList;
import java.util.List;

import io.github.rootlol.yam.App;
import io.github.rootlol.yam.account.AccountUtils;
import io.github.rootlol.yam.controller.home.RadioSubHome;
import io.github.rootlol.yamadapter.YamAdapterInterface;
import io.github.rootlol.yamadapter.YamDataSourceFactory;
import io.github.rootlol.yamadapter.YamVHFactory;
import io.github.rootlol.yandexmusic.ApiMusic;
import io.github.rootlol.yandexmusic.pojo.rotor.stations.dashboard.PojoRotorStationsDashboard;
import io.github.rootlol.yandexmusic.pojo.rotor.stations.dashboard.Station;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RadioDSFactory extends YamDataSourceFactory {
    private RadioVHFactory radioVHFactory;
    private Context context;

    public RadioDSFactory(Context context) {
        this.context = context;
    }

    @Override
    public YamVHFactory getVHFactory() {
        if (radioVHFactory == null){
            radioVHFactory = new RadioVHFactory();
        }
        return radioVHFactory;
    }

    @Override
    public DataSource create() {
        return new RadioDataSourseNet();
    }

    public class RadioDataSourseNet extends PositionalDataSource<YamAdapterInterface> {

        List<YamAdapterInterface> data;

        @SuppressLint("WrongThread")
        @Override
        public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback<YamAdapterInterface> Acallback) {
            ApiMusic.getInstance().getRotorStationsDashboard(AccountManager.get(context).peekAuthToken(App.getAccount(), AccountUtils.AUTH_TOKEN_TYPE)).enqueue(new Callback<PojoRotorStationsDashboard>() {
                @Override
                public void onResponse(Call<PojoRotorStationsDashboard> call, Response<PojoRotorStationsDashboard> response) {
                    List<YamAdapterInterface> temp = new ArrayList<>();

                    for (Station w: response.body().getResult().getStations()) {
                        temp.add(new ItemStation(w));
                    }
                    data = temp;
                    List<YamAdapterInterface> tempList = new ArrayList<>();

                    for (int i = 0; i < params.pageSize && i < data.size(); i++) {
                        tempList.add(data.get(i));
                    }

                    Acallback.onResult(tempList, 0);
                    RadioSubHome.setSRL(false);
                }

                @Override
                public void onFailure(Call<PojoRotorStationsDashboard> call, Throwable t) {
                    Toast.makeText(context, "error radio download", Toast.LENGTH_LONG).show();
                }
            });
        }

        @Override
        public void loadRange(@NonNull LoadRangeParams params, @NonNull LoadRangeCallback<YamAdapterInterface> callback) {
            List<YamAdapterInterface> tempList = new ArrayList<>();

            for (int i = params.startPosition; i <= params.loadSize + params.startPosition && i <= data.size() - 1; i++) {
                tempList.add(data.get(i));
            }

            callback.onResult(tempList);
        }
    }
}
