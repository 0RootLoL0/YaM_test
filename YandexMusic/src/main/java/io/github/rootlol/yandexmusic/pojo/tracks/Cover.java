
package io.github.rootlol.yandexmusic.pojo.tracks;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Cover {

    @SerializedName("prefix")
    private String mPrefix;
    @SerializedName("type")
    private String mType;
    @SerializedName("uri")
    private String mUri;

    public String getPrefix() {
        return mPrefix;
    }

    public void setPrefix(String prefix) {
        mPrefix = prefix;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public String getUri() {
        return mUri;
    }

    public void setUri(String uri) {
        mUri = uri;
    }

}
