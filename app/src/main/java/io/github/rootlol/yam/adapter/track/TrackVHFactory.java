/*
 * Copyright © 2020 . Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yam.adapter.track;

import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import io.github.rootlol.yamadapter.ItemDataCache;
import io.github.rootlol.yamadapter.YamAdapterInterface;
import io.github.rootlol.yamadapter.YamVHFactory;

public class TrackVHFactory implements YamVHFactory {

    @Override
    public RecyclerView.ViewHolder create(ViewGroup parent, int viewType) {
        return new ItemTrack.TrackViewHolder(parent);
    }

    @Override
    public List<ItemDataCache> toDataCache(List<YamAdapterInterface> Listitem) {
        return null;
    }

    @Override
    public List<YamAdapterInterface> toListData(List<ItemDataCache> Listitem) {
        return null;
    }

    @Override
    public Object getOnClick(int typeItem) {
        return null;
    }
}
