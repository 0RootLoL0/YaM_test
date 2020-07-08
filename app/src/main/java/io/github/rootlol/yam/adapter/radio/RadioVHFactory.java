/*
 * Copyright © 2020 . Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yam.adapter.radio;

import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import io.github.rootlol.yam.App;
import io.github.rootlol.yamadapter.ItemDataCache;
import io.github.rootlol.yamadapter.YamAdapterInterface;
import io.github.rootlol.yamadapter.YamVHFactory;
import io.github.rootlol.yamadapter.item.ItemStation;

public class RadioVHFactory implements YamVHFactory {
    @Override
    public RecyclerView.ViewHolder create(ViewGroup parent, int viewType) {
        return new ItemStation.StationsViewHolder(parent, App.getInstance());
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
