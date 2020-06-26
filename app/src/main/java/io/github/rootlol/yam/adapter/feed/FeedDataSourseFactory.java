/*
 * Copyright © 2020 . Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yam.adapter.feed;

import androidx.annotation.NonNull;
import androidx.paging.DataSource;
import androidx.paging.PositionalDataSource;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import io.github.rootlol.yam.adapter.feed.item.ItemGeneratedplaylists;

public class FeedDataSourseFactory extends DataSource.Factory {
    private boolean isOnline;
    private SwipeRefreshLayout SRL;

    public FeedDataSourseFactory(boolean isOnline, SwipeRefreshLayout SRL) {
        this.isOnline = isOnline;
        this.SRL = SRL;
    }

    @Override
    public DataSource create() {
        if (isOnline) {
            return new FeedDataSourseNet();
        }
        return new FeedDataSourseNet();
    }

    public class FeedDataSourseNet extends PositionalDataSource<FeedAdapterInterface> {
        @Override
        public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback<FeedAdapterInterface> callback) {
            SRL.setRefreshing(false);
            List<FeedAdapterInterface> tempList = new ArrayList<>();
            for (int i = 0; i < params.pageSize; i++) {
                tempList.add(new ItemGeneratedplaylists());
            }
            callback.onResult(tempList, 0);
        }

        @Override
        public void loadRange(@NonNull LoadRangeParams params, @NonNull LoadRangeCallback<FeedAdapterInterface> callback) {
            List<FeedAdapterInterface> tempList = new ArrayList<>();
            for (int i = params.startPosition; i < params.loadSize+params.startPosition; i++) {
                tempList.add(new ItemGeneratedplaylists());
            }
            callback.onResult(tempList);
        }
    }
}
