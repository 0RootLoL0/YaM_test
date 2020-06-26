
package io.github.rootlol.yandexmusic.pojo.tracks;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Normalization {

    @SerializedName("gain")
    private Double mGain;
    @SerializedName("peak")
    private Long mPeak;

    public Double getGain() {
        return mGain;
    }

    public void setGain(Double gain) {
        mGain = gain;
    }

    public Long getPeak() {
        return mPeak;
    }

    public void setPeak(Long peak) {
        mPeak = peak;
    }

}
