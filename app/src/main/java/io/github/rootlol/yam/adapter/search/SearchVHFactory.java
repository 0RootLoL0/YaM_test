/*
 * Copyright © 2020 . Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yam.adapter.search;

import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import io.github.rootlol.yam.App;
import io.github.rootlol.yamadapter.ItemDataCache;
import io.github.rootlol.yamadapter.YamAdapterInterface;
import io.github.rootlol.yamadapter.YamVHFactory;
import io.github.rootlol.yamadapter.item.ItemAlbum;
import io.github.rootlol.yamadapter.item.ItemArtist;
import io.github.rootlol.yamadapter.item.ItemPlaylist;
import io.github.rootlol.yamadapter.item.ItemTrack;
import io.github.rootlol.yamadapter.item.ItemVideo;

public class SearchVHFactory implements YamVHFactory {
    @Override
    public RecyclerView.ViewHolder create(ViewGroup parent, int viewType) {
        switch (viewType){
            case YamAdapterInterface.ALBUM:
                return new ItemAlbum.AlbumViewHolder(parent, App.getInstance());
            case YamAdapterInterface.ARTIST:
                return new ItemArtist.ArtistViewHolder(parent, App.getInstance());
            case YamAdapterInterface.PLAYLIST:
                return new ItemPlaylist.PlaylistViewHolder(parent, App.getInstance());
            case YamAdapterInterface.TRACK:
                return new ItemTrack.TrackViewHolder(parent, App.getInstance());
            case YamAdapterInterface.VIDEO:
                return new ItemVideo.VideoViewHolder(parent, App.getInstance());
            default:
                return null;
        }
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
