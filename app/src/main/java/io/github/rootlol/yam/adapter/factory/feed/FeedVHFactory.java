/*
 * Copyright © 2020 . Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yam.adapter.factory.feed;

import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import io.github.rootlol.yam.adapter.YamVHFactory;
import io.github.rootlol.yam.adapter.factory.feed.item.ItemDaysEventsRTBAFH;
import io.github.rootlol.yam.adapter.factory.feed.item.ItemGeneratedplaylists;

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
}
