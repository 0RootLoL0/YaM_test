
package io.github.rootlol.yandexmusic.pojo.rotor.stations.dashboard;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Mood {

    @SerializedName("max")
    private Max mMax;
    @SerializedName("min")
    private Min mMin;
    @SerializedName("name")
    private String mName;
    @SerializedName("type")
    private String mType;

    public Max getMax() {
        return mMax;
    }

    public void setMax(Max max) {
        mMax = max;
    }

    public Min getMin() {
        return mMin;
    }

    public void setMin(Min min) {
        mMin = min;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

}
