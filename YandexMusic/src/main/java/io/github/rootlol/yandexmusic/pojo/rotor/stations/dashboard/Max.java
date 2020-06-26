
package io.github.rootlol.yandexmusic.pojo.rotor.stations.dashboard;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Max {

    @SerializedName("name")
    private String mName;
    @SerializedName("value")
    private Long mValue;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Long getValue() {
        return mValue;
    }

    public void setValue(Long value) {
        mValue = value;
    }

}
