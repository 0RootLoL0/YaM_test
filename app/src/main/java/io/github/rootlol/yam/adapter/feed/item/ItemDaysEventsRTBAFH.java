/*
 * Copyright © 2020 . Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yam.adapter.feed.item;

/*
 * "type": "recommended-tracks-by-artist-from-history"
 */

import android.view.LayoutInflater;
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
import io.github.rootlol.yandexmusic.pojo.feed.Event;
import io.github.rootlol.yandexmusic.pojo.feed.Title;

public class ItemDaysEventsRTBAFH implements YamAdapterInterface {

    private int position;
    public Event info;

    public static class DaysEventsRTBAFHViewHolder extends RecyclerView.ViewHolder {

        public CardView rtbafh_card;
        public ImageView rtbafh_cover;
        public TextView rtbafh_type;
        public TextView rtbafh_title;
        public TextView rtbafh_info;


        public DaysEventsRTBAFHViewHolder(ViewGroup parent) {
            super(LayoutInflater.from(App.getInstance()).inflate(R.layout.adapter_feed_daysevents_rtbafh, parent, false));
            rtbafh_card = itemView.findViewById(R.id.ad_feed_dayseventsrtbafh_cv_card);
            rtbafh_cover= itemView.findViewById(R.id.ad_feed_dayseventsrtbafh_iv_cover);
            rtbafh_type = itemView.findViewById(R.id.ad_feed_dayseventsrtbafh_tv_type);
            rtbafh_title = itemView.findViewById(R.id.ad_feed_dayseventsrtbafh_tv_title);
            rtbafh_info = itemView.findViewById(R.id.ad_feed_dayseventsrtbafh_tv_info);
        }
    }

    public ItemDaysEventsRTBAFH(Event info) {
        this.info = info;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position, Object ItemListener) {
        this.position = position;
        ((DaysEventsRTBAFHViewHolder) viewHolder).rtbafh_title.setText("");
        Picasso.with(App.getInstance())
                .load("https://"+info.getmArtist().getCover().getUri().replace("%%", "200x200"))
                .transform(new RoundedTransformation(8, 2))
                .into( ((DaysEventsRTBAFHViewHolder) viewHolder).rtbafh_cover );
        for (Title titleI : info.getTitle()) {
            ((DaysEventsRTBAFHViewHolder) viewHolder).rtbafh_title.setText(((DaysEventsRTBAFHViewHolder) viewHolder).rtbafh_title.getText().toString()+titleI.getText());
        }
    }

    @Override
    public int getType() {
        return FeedVHFactory.DAYS_EVENTS_RTBAFH;
    }

    @Override
    public int getPosition() {
        return position;
    }
}
