/*
 * Copyright © 2020 . Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yamadapter;

import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public interface YamVHFactory {
    RecyclerView.ViewHolder create(ViewGroup parent, int viewType) ;
    List<ItemDataCache> toDataCache(List<YamAdapterInterface> Listitem);
    List<YamAdapterInterface> toListData(List<ItemDataCache> Listitem);

}
