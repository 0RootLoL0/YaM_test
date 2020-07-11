/*
 * Copyright © 2020 . Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yam.adapter.feed;

import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import io.github.rootlol.yam.App;
import io.github.rootlol.yam.adapter.feed.item.ItemDaysEventsRTBAFH;
import io.github.rootlol.yamadapter.ItemDataCache;
import io.github.rootlol.yamadapter.YamAdapterInterface;
import io.github.rootlol.yamadapter.YamVHFactory;
import io.github.rootlol.yamadapter.item.ItemPlaylist;

public class FeedVHFactory implements YamVHFactory {

    public static final int DAYS_EVENTS_RTBAFH = 1;

    ItemPlaylist.PlaylistOnClickListener generatedplaylistOnClickListener;
    ItemDaysEventsRTBAFH.DaysEventsRTBAFHOnClickListener daysEventsRTBAFHOnClickListener;


    public RecyclerView.ViewHolder create(ViewGroup parent, int viewType) {
        switch (viewType) {
            case YamAdapterInterface.PLAYLIST:
                return new ItemPlaylist.PlaylistViewHolder(parent, App.getInstance());
            case DAYS_EVENTS_RTBAFH:
                return new ItemDaysEventsRTBAFH.DaysEventsRTBAFHViewHolder(parent);
            default:
                return null;
        }
    }

    @Override
    public List<ItemDataCache> toDataCache(List<YamAdapterInterface> Listitem) {
        List<ItemDataCache> temp = new ArrayList<>();
        return temp;
    }
    @Override
    public List<YamAdapterInterface> toListData(List<ItemDataCache> Listitem) {
        List<YamAdapterInterface> temp = new ArrayList<>();
        return temp;
    }

    @Override
    public Object getOnClick(int typeItem) {
        switch (typeItem){
            case YamAdapterInterface.PLAYLIST:
                return generatedplaylistOnClickListener;
            case DAYS_EVENTS_RTBAFH:
                return daysEventsRTBAFHOnClickListener;
        }
        return null;
    }

    public void setGeneratedplaylistOnClickListener(ItemPlaylist.PlaylistOnClickListener generatedplaylistOnClickListener) {
        this.generatedplaylistOnClickListener = generatedplaylistOnClickListener;
    }

    public void setDaysEventsRTBAFHOnClickListener(ItemDaysEventsRTBAFH.DaysEventsRTBAFHOnClickListener daysEventsRTBAFHOnClickListener) {
        this.daysEventsRTBAFHOnClickListener = daysEventsRTBAFHOnClickListener;
    }
}
