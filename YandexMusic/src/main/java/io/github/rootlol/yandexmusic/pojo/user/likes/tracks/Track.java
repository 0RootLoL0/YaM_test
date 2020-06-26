
/*
 * Copyright © 2020 . Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yandexmusic.pojo.user.likes.tracks;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Track {

    @SerializedName("albumId")
    private String mAlbumId;
    @SerializedName("id")
    private String mId;
    @SerializedName("timestamp")
    private String mTimestamp;

    public String getAlbumId() {
        return mAlbumId;
    }

    public void setAlbumId(String albumId) {
        mAlbumId = albumId;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getTimestamp() {
        return mTimestamp;
    }

    public void setTimestamp(String timestamp) {
        mTimestamp = timestamp;
    }

}
