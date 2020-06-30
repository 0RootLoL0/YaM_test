/*
 * Copyright © 2020 . Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yam.adapter;

import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

public interface YamVHFactory {
    RecyclerView.ViewHolder create(ViewGroup parent, int viewType) ;
}
