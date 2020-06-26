
package io.github.rootlol.yandexmusic.pojo.tracks;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class TrackPosition {

    @SerializedName("index")
    private Long mIndex;
    @SerializedName("volume")
    private Long mVolume;

    public Long getIndex() {
        return mIndex;
    }

    public void setIndex(Long index) {
        mIndex = index;
    }

    public Long getVolume() {
        return mVolume;
    }

    public void setVolume(Long volume) {
        mVolume = volume;
    }

}
