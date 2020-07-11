/*
 * Copyright © 2020 . Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yamadapter.item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import io.github.rootlol.yamadapter.R;
import io.github.rootlol.yamadapter.YamAdapterInterface;

public class ItemAlbum implements YamAdapterInterface {

    private int position;

    public static class AlbumViewHolder extends RecyclerView.ViewHolder {

        public LinearLayout track_card;
        public AppCompatImageView track_cover;
        public TextView track_lable;
        public TextView track_info;


        public AlbumViewHolder(ViewGroup parent, Context context) {
            super(LayoutInflater.from(context).inflate(R.layout.item_track, parent, false));
            track_card = itemView.findViewById(R.id.ad_track_mcv_card);
            track_cover= itemView.findViewById(R.id.ad_track_iv_cover);
            track_lable = itemView.findViewById(R.id.ad_track_tv_lable);
            track_info = itemView.findViewById(R.id.ad_track_tv_info);
        }
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position, Context context, Object ItemListener) {
        this.position = position;
    }

    @Override
    public int getType() {
        return YamAdapterInterface.ALBUM;
    }
    @Override
    public int getPosition() {
        return position;
    }
}
