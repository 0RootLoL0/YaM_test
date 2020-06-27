/*
 * Copyright © 2020 . Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yam.adapter.feed;

import androidx.recyclerview.widget.RecyclerView;

public interface FeedAdapterInterface {
    int GENERATEDPLAYLISTS = 0 ;
    int DAYS_EVENTS_RTBAFH = 1 ;

    void                  onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position, FeedAdapter.onClickFeed ItemListener);
    int                   getType();
    // для пагинации
    int                   getPosition();
}
