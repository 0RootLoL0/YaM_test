/*
 * Copyright © 2020 . Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yam.adapter.feed;

import android.annotation.SuppressLint;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import io.github.rootlol.yandexmusic.pojo.feed.GeneratedPlaylist;

public class FeedAdapter extends PagedListAdapter<FeedAdapterInterface, RecyclerView.ViewHolder> {
    private onClickFeed ItemListener;
    private static DiffUtil.ItemCallback<FeedAdapterInterface> DIFF_CALLBACK = new DiffUtil.ItemCallback<FeedAdapterInterface>() {
        @Override
        public boolean areItemsTheSame(FeedAdapterInterface oldItem, FeedAdapterInterface newItem) {
            return oldItem.getPosition() == newItem.getPosition();
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(FeedAdapterInterface oldItem, FeedAdapterInterface newItem) {
            return oldItem.equals(newItem);
        }
    };

    public FeedAdapter() {
        super(DIFF_CALLBACK);
        ItemListener = new onClickFeed();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return FeedVHFactory.create(parent, viewType);
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        getItem(position).onBindViewHolder(holder, position, ItemListener);
    }

    @Nullable
    @Override
    protected FeedAdapterInterface getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public int getItemViewType(int position) {
        return getItem(position).getType();
    }

    public onClickFeed getItemListener() {
        return ItemListener;
    }

    //заготовка
    public static class onClickFeed{

        public interface onClickListenerFeed {
            void onItemGeneratedPlaylistsClick(GeneratedPlaylist model, int position);
            void onItemSettingsGeneratedPlaylistsClick(GeneratedPlaylist model, int position);
        }


        onClickListenerFeed onclicklistenerplaylist;

        public onClickListenerFeed getOnclicklistenerGeneratedPlaylists() {
            return onclicklistenerplaylist;
        }

        public void setOnClickListenerGeneratedPlaylists(onClickListenerFeed onclicklistenerplaylist) {
            this.onclicklistenerplaylist = onclicklistenerplaylist;
        }
    }
}
