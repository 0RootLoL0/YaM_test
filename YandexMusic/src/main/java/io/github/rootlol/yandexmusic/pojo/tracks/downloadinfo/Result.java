
package io.github.rootlol.yandexmusic.pojo.tracks.downloadinfo;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Result {

    @SerializedName("bitrateInKbps")
    private Long mBitrateInKbps;
    @SerializedName("codec")
    private String mCodec;
    @SerializedName("direct")
    private Boolean mDirect;
    @SerializedName("downloadInfoUrl")
    private String mDownloadInfoUrl;
    @SerializedName("gain")
    private Boolean mGain;
    @SerializedName("preview")
    private Boolean mPreview;

    public Long getBitrateInKbps() {
        return mBitrateInKbps;
    }

    public void setBitrateInKbps(Long bitrateInKbps) {
        mBitrateInKbps = bitrateInKbps;
    }

    public String getCodec() {
        return mCodec;
    }

    public void setCodec(String codec) {
        mCodec = codec;
    }

    public Boolean getDirect() {
        return mDirect;
    }

    public void setDirect(Boolean direct) {
        mDirect = direct;
    }

    public String getDownloadInfoUrl() {
        return mDownloadInfoUrl;
    }

    public void setDownloadInfoUrl(String downloadInfoUrl) {
        mDownloadInfoUrl = downloadInfoUrl;
    }

    public Boolean getGain() {
        return mGain;
    }

    public void setGain(Boolean gain) {
        mGain = gain;
    }

    public Boolean getPreview() {
        return mPreview;
    }

    public void setPreview(Boolean preview) {
        mPreview = preview;
    }

}
