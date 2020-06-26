/*
 * Copyright © 2020 . Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yam.adapter.feed.item;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import io.github.rootlol.yam.App;
import io.github.rootlol.yam.R;
import io.github.rootlol.yam.adapter.feed.FeedAdapter;
import io.github.rootlol.yam.adapter.feed.FeedAdapterInterface;

public class ItemGeneratedplaylists implements FeedAdapterInterface {
    public Object info;
    public int position;

    public static class GeneratedplaylistsViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView5;
        public TextView trackLable;
        public TextView trackType;
        public ImageButton buttonSettings;
        public CardView itemTrack;

        public GeneratedplaylistsViewHolder(ViewGroup parent) {
            super(LayoutInflater.from(App.getInstance()).inflate(R.layout.adapter_feed_generatedplaylists, parent, false));
            imageView5 = itemView.findViewById(R.id.StationImage);
            trackLable = itemView.findViewById(R.id.lable);
            trackType = itemView.findViewById(R.id.colTime);
            buttonSettings = itemView.findViewById(R.id.buttonSettings);
            itemTrack = itemView.findViewById(R.id.cv);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position, FeedAdapter.onClickFeed ItemListener) {
        this.position = position;
        /*Glide.with(App.getInstance())
                .load("https://"+info.getOgImage().replace("%%", "200x200"))
                .error(Glide.with(App.getInstance()).load(R.drawable.launch_screen))
                .into(((GeneratedplaylistsViewHolder) viewHolder).imageView5);*/

        //((GeneratedplaylistsViewHolder) viewHolder).trackLable.setText(info.getTitle());
        //((GeneratedplaylistsViewHolder) viewHolder).trackType.setText(info.getCreated());



    }

    @Override
    public int getType() {
        return FeedAdapterInterface.GENERATEDPLAYLISTS;
    }

    @Override
    public int getPosition() {
        return position;
    }

}
