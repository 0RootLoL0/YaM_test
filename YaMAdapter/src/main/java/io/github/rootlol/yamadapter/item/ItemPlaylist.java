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
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import io.github.rootlol.yamadapter.R;
import io.github.rootlol.yamadapter.RoundedTransformation;
import io.github.rootlol.yamadapter.YamAdapterInterface;

public class ItemPlaylist implements YamAdapterInterface {
    private int position;

    public static class PlaylistsViewHolder extends RecyclerView.ViewHolder {

        public CardView card;
        public ImageView cover;
        public TextView lable;
        public TextView info;

        public PlaylistsViewHolder(ViewGroup parent, Context context) {
            super(LayoutInflater.from(context).inflate(R.layout.item_playlist, parent, false));
            card  = itemView.findViewById(R.id.item_playlist_cv_card);
            cover = itemView.findViewById(R.id.item_playlist_iv_cover);
            lable = itemView.findViewById(R.id.item_playlist_tv_lable);
            info  = itemView.findViewById(R.id.item_playlist_tv_info);
        }
    }
    public interface PlaylistOnClickListener {
        void onItemPlaylist(ItemPlaylist model);
    }

    private Uri coverUrl;
    private String lable;
    private String info;

    public ItemPlaylist(Uri coverUrl, String lable, String info) {
        this.coverUrl = coverUrl;
        this.lable = lable;
        this.info = info;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position, Context context, Object ItemListener) {
        this.position = position;
        PlaylistsViewHolder VHolder = (PlaylistsViewHolder) viewHolder;
        final PlaylistOnClickListener listener = (PlaylistOnClickListener) ItemListener;

        Picasso.with(context)
                .load(coverUrl)
                .transform(new RoundedTransformation(16, 4))
                .into(VHolder.cover);
        VHolder.lable.setText(lable);
        VHolder.info.setText(info);
        VHolder.card.setOnClickListener((v) -> {listener.onItemPlaylist(ItemPlaylist.this);});
    }

    @Override
    public int getType() {
        return YamAdapterInterface.PLAYLIST;
    }

    @Override
    public int getPosition() {
        return position;
    }
}
