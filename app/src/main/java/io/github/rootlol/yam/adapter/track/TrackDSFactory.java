/*
 * Copyright © 2020 . Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yam.adapter.track;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;
import androidx.paging.DataSource;
import androidx.paging.PositionalDataSource;

import io.github.rootlol.yamadapter.YamAdapterInterface;
import io.github.rootlol.yamadapter.YamDataSourceFactory;
import io.github.rootlol.yamadapter.YamVHFactory;

public class TrackDSFactory extends YamDataSourceFactory {

    TrackVHFactory trackVHFactory;

    @Override
    public YamVHFactory getVHFactory() {
        if (trackVHFactory == null) {
            trackVHFactory = new TrackVHFactory();
        }
        return trackVHFactory;
    }

    @Override
    public DataSource create() {
        return new  TrackDataSourseNet();
    }

    public class TrackDataSourseNet extends PositionalDataSource<YamAdapterInterface> {

        @SuppressLint("WrongThread")
        @Override
        public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback<YamAdapterInterface> Acallback) {

        }

        @Override
        public void loadRange(@NonNull LoadRangeParams params, @NonNull LoadRangeCallback<YamAdapterInterface> callback) {

        }
    }
}
