/*
 * Copyright © 2020 . Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yamadapter;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

public interface YamAdapterInterface {
    int PLAYLIST = 0;
    int STATION = 1;
    int TRACK = 3;

    void                  onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position, Context context, Object ItemListener);
    int                   getType();
    int                   getPosition();
}
