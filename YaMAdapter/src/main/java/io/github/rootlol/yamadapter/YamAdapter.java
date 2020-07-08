/*
 * Copyright © 2020 . Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yamadapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

public class YamAdapter extends PagedListAdapter<YamAdapterInterface, RecyclerView.ViewHolder> {
    private static DiffUtil.ItemCallback<YamAdapterInterface> DIFF_CALLBACK = new DiffUtil.ItemCallback<YamAdapterInterface>() {
        @Override
        public boolean areItemsTheSame(YamAdapterInterface oldItem, YamAdapterInterface newItem) {
            return oldItem.getPosition() == newItem.getPosition();
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(YamAdapterInterface oldItem, YamAdapterInterface newItem) {
            return oldItem.equals(newItem);
        }
    };
    private YamDataSourceFactory dataSourceFactory;
    private Context mContext;

    public YamAdapter(AppCompatActivity activity, YamDataSourceFactory dataSourceFactory, PagedList.Config config ) {
        super(DIFF_CALLBACK);
        this.dataSourceFactory = dataSourceFactory;
        mContext = activity.getApplicationContext();
        LiveData<PagedList<YamAdapterInterface>> pagedListLiveData = new LivePagedListBuilder<>(dataSourceFactory, config).build();
        pagedListLiveData.observe(activity, new Observer<PagedList<YamAdapterInterface>>() {
            @Override
            public void onChanged(@Nullable PagedList<YamAdapterInterface> playlistListInterfaces) {
                YamAdapter.this.submitList(playlistListInterfaces);
            }
        });
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return dataSourceFactory.getVHFactory().create(parent, viewType);
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        getItem(position).onBindViewHolder(holder, position, mContext, dataSourceFactory.getVHFactory().getOnClick(getItem(position).getType()));
    }

    @Nullable
    @Override
    protected YamAdapterInterface getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public int getItemViewType(int position) {
        return getItem(position).getType();
    }

}
