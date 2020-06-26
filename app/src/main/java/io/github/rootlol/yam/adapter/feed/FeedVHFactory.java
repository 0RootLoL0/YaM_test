/*
 * Copyright © 2020 . Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yam.adapter.feed;

import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import io.github.rootlol.yam.adapter.feed.item.ItemGeneratedplaylists;

public class FeedVHFactory {

    public static RecyclerView.ViewHolder create(ViewGroup parent, int viewType) {
        View toolbarTypeView;
        switch (viewType) {
            case FeedAdapterInterface.GENERATEDPLAYLISTS:
                return new ItemGeneratedplaylists.GeneratedplaylistsViewHolder(parent);
            default:
                return null;
        }
    }
}
