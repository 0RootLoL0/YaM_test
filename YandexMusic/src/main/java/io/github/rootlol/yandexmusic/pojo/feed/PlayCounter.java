
package io.github.rootlol.yandexmusic.pojo.feed;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class PlayCounter {

    @SerializedName("description")
    private String mDescription;
    @SerializedName("updated")
    private Boolean mUpdated;
    @SerializedName("value")
    private Long mValue;

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public Boolean getUpdated() {
        return mUpdated;
    }

    public void setUpdated(Boolean updated) {
        mUpdated = updated;
    }

    public Long getValue() {
        return mValue;
    }

    public void setValue(Long value) {
        mValue = value;
    }

}
