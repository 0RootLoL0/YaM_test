/*
 * Copyright © 2020 . Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yam.adapter.track;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import io.github.rootlol.yam.App;
import io.github.rootlol.yam.R;
import io.github.rootlol.yamadapter.YamAdapterInterface;

public class ItemTrack implements YamAdapterInterface {

    private int position;

    public static class TrackViewHolder extends RecyclerView.ViewHolder {

        public CardView track_card;
        public ImageView track_cover;
        public TextView track_lable;
        public TextView track_info;


        public TrackViewHolder(ViewGroup parent) {
            super(LayoutInflater.from(App.getInstance()).inflate(R.layout.adapter_feed_daysevents_rtbafh, parent, false));
            track_card = itemView.findViewById(R.id.ad_track_mcv_card);
            track_cover= itemView.findViewById(R.id.ad_track_iv_cover);
            track_lable = itemView.findViewById(R.id.ad_track_tv_lable);
            track_info = itemView.findViewById(R.id.ad_track_tv_info);
        }
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position, Object ItemListener) {
        this.position = position;
    }

    @Override
    public int getType() {
        return 0;
    }
    @Override
    public int getPosition() {
        return position;
    }
}
