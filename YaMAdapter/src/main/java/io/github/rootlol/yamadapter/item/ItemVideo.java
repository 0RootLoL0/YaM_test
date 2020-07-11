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

import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import io.github.rootlol.yamadapter.R;
import io.github.rootlol.yamadapter.RoundedTransformation;
import io.github.rootlol.yamadapter.YamAdapterInterface;

public class ItemVideo implements YamAdapterInterface {

    private int position;

    public static class VideoViewHolder extends RecyclerView.ViewHolder {

        public CardView video_card;
        public ImageView video_preview;
        public TextView video_title;
        public TextView video_info;


        public VideoViewHolder(ViewGroup parent, Context context) {
            super(LayoutInflater.from(context).inflate(R.layout.item_video, parent, false));
            video_card = itemView.findViewById(R.id.item_video_cv_item);
            video_preview= itemView.findViewById(R.id.item_video_iv_preview);
            video_title = itemView.findViewById(R.id.item_video_tv_title);
            video_info = itemView.findViewById(R.id.item_video_tv_info);
        }
    }
    public interface VideoOnClickListener{
        void VideoOnItemClick(ItemVideo model);
    }

    private Uri previewUrl;
    private String title;
    private String info;

    public ItemVideo(Uri previewUrl, String title, String info) {
        this.previewUrl = previewUrl;
        this.title = title;
        this.info = info;
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position, Context context, Object ItemListener) {
        this.position = position;
        VideoViewHolder VHolder = (VideoViewHolder) viewHolder;
        VideoOnClickListener listener = (VideoOnClickListener) ItemListener;
        Picasso.with(context)
                .load(previewUrl)
                .transform(new RoundedTransformation(16, 4))
                .into(VHolder.video_preview);
        VHolder.video_title.setText(title);
        VHolder.video_info.setText(info);
        VHolder.video_card.setOnClickListener((v) -> { listener.VideoOnItemClick(ItemVideo.this);});
    }
    @Override
    public int getType() {
        return YamAdapterInterface.VIDEO;
    }
    @Override
    public int getPosition() {
        return position;
    }
}
