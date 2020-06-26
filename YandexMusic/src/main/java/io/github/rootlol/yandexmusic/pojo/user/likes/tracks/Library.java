
/*
 * Copyright © 2020 . Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yandexmusic.pojo.user.likes.tracks;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Library {

    @SerializedName("revision")
    private Long mRevision;
    @SerializedName("tracks")
    private List<Track> mTracks;
    @SerializedName("uid")
    private Long mUid;

    public Long getRevision() {
        return mRevision;
    }

    public void setRevision(Long revision) {
        mRevision = revision;
    }

    public List<Track> getTracks() {
        return mTracks;
    }

    public void setTracks(List<Track> tracks) {
        mTracks = tracks;
    }

    public Long getUid() {
        return mUid;
    }

    public void setUid(Long uid) {
        mUid = uid;
    }

}
