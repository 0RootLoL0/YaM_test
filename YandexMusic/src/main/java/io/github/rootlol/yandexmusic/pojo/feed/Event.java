
package io.github.rootlol.yandexmusic.pojo.feed;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Event {

    @SerializedName("genre")
    private String mGenre;
    @SerializedName("id")
    private String mId;
    @SerializedName("title")
    private List<Title> mTitle;
    @SerializedName("tracks")
    private List<Track> mTracks;
    @SerializedName("type")
    private String mType;
    @SerializedName("typeForFrom")
    private String mTypeForFrom;
    @SerializedName("artist")
    private Artist mArtist;

    public String getGenre() {
        return mGenre;
    }

    public void setGenre(String genre) {
        mGenre = genre;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public List<Title> getTitle() {
        return mTitle;
    }

    public void setTitle(List<Title> title) {
        mTitle = title;
    }

    public List<Track> getTracks() {
        return mTracks;
    }

    public void setTracks(List<Track> tracks) {
        mTracks = tracks;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public String getTypeForFrom() {
        return mTypeForFrom;
    }

    public void setTypeForFrom(String typeForFrom) {
        mTypeForFrom = typeForFrom;
    }

    public Artist getmArtist() {
        return mArtist;
    }

    public void setmArtist(Artist mArtist) {
        this.mArtist = mArtist;
    }
}
