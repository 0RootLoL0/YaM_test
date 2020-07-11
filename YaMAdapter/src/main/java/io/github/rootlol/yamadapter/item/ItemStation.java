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
import io.github.rootlol.yamadapter.YamAdapterInterface;

public class ItemStation implements YamAdapterInterface {
    private int position;

    public static class StationsViewHolder extends RecyclerView.ViewHolder {

        public ImageView StationImage;
        public TextView rotorTitle;

        public TextView rotorLang;
        public TextView rotorMood;
        public TextView rotorEnergy;
        public TextView rotorDiversity;

        public CardView cardView;
        public CardView BGStationImage;

        public StationsViewHolder(ViewGroup parent, Context context) {
            super(LayoutInflater.from(context).inflate(R.layout.item_station, parent, false));
            StationImage = itemView.findViewById(R.id.StationImage);
            rotorTitle = itemView.findViewById(R.id.rotorTitle);

            rotorLang = itemView.findViewById(R.id.rotorLang);
            rotorMood= itemView.findViewById(R.id.rotorMood);
            rotorEnergy = itemView.findViewById(R.id.rotorEnergy);
            rotorDiversity = itemView.findViewById(R.id.rotorDiversity);

            cardView = itemView.findViewById(R.id.cv);
            BGStationImage= itemView.findViewById(R.id.BGStationImage);
        }
    }
    public interface StationOnClickListener{
        void StationOnItemClick(ItemStation model);
    }

    private Uri coverUrl;
    private int colorCover;
    private String title;
    private String lang;
    private long mood;
    private long energy;
    private String diversity;

    public ItemStation(Uri coverUrl, int colorCover, String title, String lang, long mood, long energy, String diversity) {
        this.coverUrl = coverUrl;
        this.colorCover = colorCover;
        this.title = title;
        this.lang = lang;
        this.mood = mood;
        this.energy = energy;
        this.diversity = diversity;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position, Context context, Object ItemListener) {
        this.position = position;
        StationsViewHolder VHolder = (StationsViewHolder) viewHolder;
        StationOnClickListener listener = (StationOnClickListener) ItemListener;

        Picasso.with(context)
                .load(coverUrl)
                .into(VHolder.StationImage);
        VHolder.rotorTitle.setText(title);
        VHolder.rotorLang.setText(lang);
        VHolder.rotorMood.setText(mood+"/4");
        VHolder.rotorEnergy.setText(energy+"/4");
        VHolder.rotorDiversity.setText(diversity);
        VHolder.BGStationImage.setCardBackgroundColor(colorCover);
        VHolder.cardView.setOnClickListener((v)-> {listener.StationOnItemClick(ItemStation.this);});
    }

    @Override
    public int getType() {
        return YamAdapterInterface.STATION;
    }

    @Override
    public int getPosition() {
        return position;
    }
}
