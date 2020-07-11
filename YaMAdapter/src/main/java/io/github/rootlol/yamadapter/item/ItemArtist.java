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

public class ItemArtist implements YamAdapterInterface {

    private int position;

    public static class ArtistViewHolder extends RecyclerView.ViewHolder {

        public CardView artist_item;
        public ImageView artist_cover;

        public TextView artist_name;

        public TextView artist_tracks;
        public TextView artist_directAlbums;
        public TextView artist_alsoAlbums;
        public TextView artist_alsoTracks;


        public ArtistViewHolder(ViewGroup parent, Context context) {
            super(LayoutInflater.from(context).inflate(R.layout.item_artist, parent, false));
            artist_item = itemView.findViewById(R.id.item_artist_cv_item);
            artist_cover = itemView.findViewById(R.id.item_artist_iv_cover);

            artist_name = itemView.findViewById(R.id.item_artist_tv_name);

            artist_tracks = itemView.findViewById(R.id.item_artist_tv_tracks);
            artist_directAlbums = itemView.findViewById(R.id.item_artist_tv_directAlbums);
            artist_alsoAlbums = itemView.findViewById(R.id.item_artist_tv_alsoAlbums);
            artist_alsoTracks = itemView.findViewById(R.id.item_artist_tv_alsoTracks);
        }
    }
    public interface ArtistOnClickListener {
        void onItemArtist(ItemArtist model);
    }


    private Uri artist_cover;
    private String artist_name;
    private String artist_tracks;
    private String artist_directAlbums;
    private String artist_alsoAlbums;
    private String artist_alsoTracks;

    public ItemArtist(Uri artist_cover, String artist_name, int artist_tracks, int artist_directAlbums, int artist_alsoAlbums, int artist_alsoTracks) {
        this.artist_cover = artist_cover;
        this.artist_name = artist_name;

        this.artist_tracks = Integer.toString(artist_tracks);
        this.artist_directAlbums = Integer.toString(artist_directAlbums);
        this.artist_alsoAlbums = Integer.toString(artist_alsoAlbums);
        this.artist_alsoTracks = Integer.toString(artist_alsoTracks);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position, Context context, Object ItemListener) {
        this.position = position;
        ArtistViewHolder VHolder = (ArtistViewHolder) viewHolder;
        ArtistOnClickListener listener = (ArtistOnClickListener) ItemListener;

        Picasso.with(context)
                .load(artist_cover)
                .transform(new RoundedTransformation(16, 4))
                .into(VHolder.artist_cover);

        VHolder.artist_name.setText(artist_name);
        VHolder.artist_tracks.setText(artist_tracks);
        VHolder.artist_directAlbums.setText(artist_directAlbums);
        VHolder.artist_alsoAlbums.setText(artist_alsoAlbums);
        VHolder.artist_alsoTracks.setText(artist_alsoTracks);
        VHolder.artist_item.setOnClickListener((v) -> {listener.onItemArtist(ItemArtist.this);});
    }

    @Override
    public int getType() {
        return YamAdapterInterface.ARTIST;
    }
    @Override
    public int getPosition() {
        return position;
    }
}
