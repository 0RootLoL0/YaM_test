/*
 * Copyright © 2020 Popov Vasily.
 * Licensed under the Apache License, Version 2.0
 */

package io.github.rootlol.yam.adapter.radio;

import android.graphics.Color;
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
import io.github.rootlol.yam.adapter.feed.item.ItemGeneratedplaylists;
import io.github.rootlol.yam.tools.RoundedTransformation;
import io.github.rootlol.yamadapter.YamAdapterInterface;
import io.github.rootlol.yandexmusic.pojo.rotor.stations.dashboard.PossibleValue;
import io.github.rootlol.yandexmusic.pojo.rotor.stations.dashboard.Station;


public class ItemStation implements YamAdapterInterface {

    private Station info;
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

        public StationsViewHolder(ViewGroup parent) {
            super(LayoutInflater.from(App.getInstance()).inflate(R.layout.adapter_radio_station, parent, false));
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
    public static interface StationOnClickListener{
        void StationOnItemClick(ItemStation model, int position);
    }

    public ItemStation(Station info) {
        this.info = info;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position, Object ItemListener) {
        StationsViewHolder stationsViewHolder = (StationsViewHolder) viewHolder;
        ItemStation.StationOnClickListener listener = (ItemStation.StationOnClickListener) ItemListener;

        Picasso.with(App.getInstance())
                .load("https://" +info.getStation().getIcon().getImageUrl().replace("%%", "100x100"))
                .into( stationsViewHolder.StationImage );

        stationsViewHolder.rotorTitle.setText(info.getStation().getName());
        for (PossibleValue nn :info.getStation().getRestrictions().getLanguage().getPossibleValues())
            if (nn.getValue().equals(info.getSettings().getLanguage())) stationsViewHolder.rotorLang.setText(nn.getName());

        stationsViewHolder.rotorMood.setText(info.getSettings().getMood()+"/4");
        stationsViewHolder.rotorEnergy.setText(info.getSettings().getEnergy()+"/4");

        for(PossibleValue qq:info.getStation().getRestrictions().getDiversity().getPossibleValues())
            if (qq.getValue().equals(info.getSettings().getDiversity()))stationsViewHolder.rotorDiversity.setText(qq.getName());

        stationsViewHolder.BGStationImage.setCardBackgroundColor(Color.parseColor(info.getStation().getIcon().getBackgroundColor()));
        if (ItemListener != null) {
            stationsViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.StationOnItemClick(ItemStation.this, position);
                }
            });
        }



    }

    @Override
    public int getType() {
        return RadioVHFactory.STATION;
    }

    @Override
    public int getPosition() {
        return position;
    }
}
