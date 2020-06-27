
package io.github.rootlol.yandexmusic.pojo.feed;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Counts {

    @SerializedName("alsoAlbums")
    private Long mAlsoAlbums;
    @SerializedName("alsoTracks")
    private Long mAlsoTracks;
    @SerializedName("directAlbums")
    private Long mDirectAlbums;
    @SerializedName("tracks")
    private Long mTracks;

    public Long getAlsoAlbums() {
        return mAlsoAlbums;
    }

    public void setAlsoAlbums(Long alsoAlbums) {
        mAlsoAlbums = alsoAlbums;
    }

    public Long getAlsoTracks() {
        return mAlsoTracks;
    }

    public void setAlsoTracks(Long alsoTracks) {
        mAlsoTracks = alsoTracks;
    }

    public Long getDirectAlbums() {
        return mDirectAlbums;
    }

    public void setDirectAlbums(Long directAlbums) {
        mDirectAlbums = directAlbums;
    }

    public Long getTracks() {
        return mTracks;
    }

    public void setTracks(Long tracks) {
        mTracks = tracks;
    }

}
