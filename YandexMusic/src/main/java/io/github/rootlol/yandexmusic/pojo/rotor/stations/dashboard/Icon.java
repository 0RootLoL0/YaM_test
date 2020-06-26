
package io.github.rootlol.yandexmusic.pojo.rotor.stations.dashboard;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Icon {

    @SerializedName("backgroundColor")
    private String mBackgroundColor;
    @SerializedName("imageUrl")
    private String mImageUrl;

    public String getBackgroundColor() {
        return mBackgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        mBackgroundColor = backgroundColor;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }

}
