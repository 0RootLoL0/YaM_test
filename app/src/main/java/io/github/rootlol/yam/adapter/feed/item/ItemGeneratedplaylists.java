/*
 * Copyright © 2020 . Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yam.adapter.feed.item;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import io.github.rootlol.yam.App;
import io.github.rootlol.yam.R;

import io.github.rootlol.yam.adapter.feed.FeedVHFactory;
import io.github.rootlol.yam.tools.RoundedTransformation;
import io.github.rootlol.yamadapter.YamAdapterInterface;
import io.github.rootlol.yandexmusic.pojo.feed.GeneratedPlaylist;

public class ItemGeneratedplaylists implements YamAdapterInterface {
    public GeneratedPlaylist info;
    private int position;

    public static class GeneratedplaylistsViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView5;
        public TextView trackLable;
        public TextView trackType;
        public CardView itemTrack;

        public GeneratedplaylistsViewHolder(ViewGroup parent) {
            super(LayoutInflater.from(App.getInstance()).inflate(R.layout.adapter_feed_generatedplaylists, parent, false));
            imageView5 = itemView.findViewById(R.id.ad_feed_gplaylist_iv_cover);
            trackLable = itemView.findViewById(R.id.ad_feed_gplaylist_tv_lable);
            trackType = itemView.findViewById(R.id.ad_feed_gplaylist_tv_info);
            itemTrack = itemView.findViewById(R.id.ad_feed_gplaylist_mcv_card);
        }
    }

    public ItemGeneratedplaylists(GeneratedPlaylist info) {
        this.info = info;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position, Object ItemListener) {
        this.position = position;
        Picasso.with(App.getInstance())
                .load("https://"+info.getData().getOgImage().replace("%%", "200x200"))
                .transform(new RoundedTransformation(16, 4))
                .into( ((GeneratedplaylistsViewHolder) viewHolder).imageView5 );

        ((GeneratedplaylistsViewHolder) viewHolder).trackLable.setText(info.getData().getTitle());
        ((GeneratedplaylistsViewHolder) viewHolder).trackType.setText(info.getData().getDescription());

        ((GeneratedplaylistsViewHolder) viewHolder).itemTrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ItemListener.getOnclicklistenerGeneratedPlaylists().onItemGeneratedPlaylistsClick(info, position);
            }
        });
    }

    @Override
    public int getType() {
        return FeedVHFactory.GENERATEDPLAYLISTS;
    }

    @Override
    public int getPosition() {
        return position;
    }

}
