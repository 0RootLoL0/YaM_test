/*
 * Copyright © 2020 . Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yamadapter;

import androidx.recyclerview.widget.RecyclerView;

public interface YamAdapterInterface {

    void                  onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position, Object ItemListener);
    int                   getType();
    int                   getPosition();
}
