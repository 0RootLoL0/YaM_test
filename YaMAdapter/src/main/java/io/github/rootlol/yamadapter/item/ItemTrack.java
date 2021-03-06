/*
 * Copyright © 2020 . Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yamadapter.item;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import io.github.rootlol.yamadapter.R;
import io.github.rootlol.yamadapter.RoundedTransformation;
import io.github.rootlol.yamadapter.YamAdapterInterface;

public class ItemTrack implements YamAdapterInterface {

    private int position;

    public static class TrackViewHolder extends RecyclerView.ViewHolder {

        public LinearLayout track_card;
        public ImageView track_cover;
        public TextView track_lable;
        public TextView track_info;


        public TrackViewHolder(ViewGroup parent, Context context) {
            super(LayoutInflater.from(context).inflate(R.layout.item_track, parent, false));
            track_card = itemView.findViewById(R.id.ad_track_mcv_card);
            track_cover= itemView.findViewById(R.id.ad_track_iv_cover);
            track_lable = itemView.findViewById(R.id.ad_track_tv_lable);
            track_info = itemView.findViewById(R.id.ad_track_tv_info);
        }
    }
    public interface TrackOnClickListener {
        void onItemTrack(ItemTrack model);
    }

    Uri cover;
    String lable;
    String info;
    public ItemTrack(Uri cover, String lable, String info) {
        this.cover = cover;
        this.lable = lable;
        this.info = info;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position, Context context, Object ItemListener) {
        this.position = position;
        TrackViewHolder VHolder = (TrackViewHolder) viewHolder;
        final TrackOnClickListener listener = (TrackOnClickListener) ItemListener;

        Picasso.with(context)
                .load(cover)
                .transform(new RoundedTransformation(16, 4))
                .into(VHolder.track_cover);
        VHolder.track_lable.setText(lable);
        VHolder.track_info.setText(info);
        VHolder.track_card.setOnClickListener((v) -> {listener.onItemTrack(ItemTrack.this);});
    }

    @Override
    public int getType() {
        return YamAdapterInterface.TRACK;
    }
    @Override
    public int getPosition() {
        return position;
    }
}
