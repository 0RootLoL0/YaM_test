/*
 * Copyright © 2020 . Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yam.adapter.feed;

import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import io.github.rootlol.yam.adapter.feed.item.ItemDaysEventsRTBAFH;
import io.github.rootlol.yam.adapter.feed.item.ItemGeneratedplaylists;
import io.github.rootlol.yamadapter.ItemDataCache;
import io.github.rootlol.yamadapter.YamAdapterInterface;
import io.github.rootlol.yamadapter.YamVHFactory;
import io.github.rootlol.yandexmusic.pojo.feed.Event;
import io.github.rootlol.yandexmusic.pojo.feed.GeneratedPlaylist;

public class FeedVHFactory implements YamVHFactory {

    public static final int GENERATEDPLAYLISTS = 0;
    public static final int DAYS_EVENTS_RTBAFH = 1;

    public RecyclerView.ViewHolder create(ViewGroup parent, int viewType) {
        switch (viewType) {
            case GENERATEDPLAYLISTS:
                return new ItemGeneratedplaylists.GeneratedplaylistsViewHolder(parent);
            case DAYS_EVENTS_RTBAFH:
                return new ItemDaysEventsRTBAFH.DaysEventsRTBAFHViewHolder(parent);
            default:
                return null;
        }
    }

    @Override
    public List<ItemDataCache> toDataCache(List<YamAdapterInterface> Listitem) {
        List<ItemDataCache> temp = new ArrayList<>();
        for (YamAdapterInterface yai: Listitem) {
            ItemDataCache ww = new ItemDataCache();
            ww.setType(yai.getType());
            switch (yai.getType()){
                case GENERATEDPLAYLISTS:
                    ww.setInfo(((ItemGeneratedplaylists)yai).info);
                    break;
                case DAYS_EVENTS_RTBAFH:
                    ww.setInfo( ((ItemDaysEventsRTBAFH) yai).info );
                    break;
            }
            temp.add(ww);
        }
        return temp;
    }

    @Override
    public List<YamAdapterInterface> toListData(List<ItemDataCache> Listitem) {
        List<YamAdapterInterface> temp = new ArrayList<>();
        for (ItemDataCache idc: Listitem ) {
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            String string = gson.toJson(idc.getInfo());

            switch (idc.getType()){
                case GENERATEDPLAYLISTS:
                    temp.add(new ItemGeneratedplaylists( gson.fromJson(string, GeneratedPlaylist.class) ));
                    break;
                case DAYS_EVENTS_RTBAFH:
                    temp.add(new ItemDaysEventsRTBAFH( gson.fromJson(string, Event.class) ));
                    break;
            }
        }
        return temp;
    }
}
