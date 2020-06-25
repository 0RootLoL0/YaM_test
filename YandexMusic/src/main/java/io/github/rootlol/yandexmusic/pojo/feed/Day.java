
package io.github.rootlol.yandexmusic.pojo.feed;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Day {

    @SerializedName("day")
    private String mDay;
    @SerializedName("events")
    private List<Event> mEvents;
    @SerializedName("tracksToPlay")
    private List<TracksToPlay> mTracksToPlay;
    @SerializedName("tracksToPlayWithAds")
    private List<TracksToPlayWithAd> mTracksToPlayWithAds;

    public String getDay() {
        return mDay;
    }

    public void setDay(String day) {
        mDay = day;
    }

    public List<Event> getEvents() {
        return mEvents;
    }

    public void setEvents(List<Event> events) {
        mEvents = events;
    }

    public List<TracksToPlay> getTracksToPlay() {
        return mTracksToPlay;
    }

    public void setTracksToPlay(List<TracksToPlay> tracksToPlay) {
        mTracksToPlay = tracksToPlay;
    }

    public List<TracksToPlayWithAd> getTracksToPlayWithAds() {
        return mTracksToPlayWithAds;
    }

    public void setTracksToPlayWithAds(List<TracksToPlayWithAd> tracksToPlayWithAds) {
        mTracksToPlayWithAds = tracksToPlayWithAds;
    }

}
