/*
 * Copyright © 2020 . Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yam.adapter;

import androidx.recyclerview.widget.RecyclerView;

public interface YamAdapterInterface {
    void                  onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position, Object ItemListener); //TODO: Object fix pleas
    int                   getType();
    int                   getPosition();
}
