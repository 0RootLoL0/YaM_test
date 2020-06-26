
package io.github.rootlol.yandexmusic.pojo.rotor.stations.dashboard;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class AdParams {

    @SerializedName("adVolume")
    private Long mAdVolume;
    @SerializedName("categoryId")
    private String mCategoryId;
    @SerializedName("otherParams")
    private String mOtherParams;
    @SerializedName("pageRef")
    private String mPageRef;
    @SerializedName("partnerId")
    private String mPartnerId;
    @SerializedName("targetRef")
    private String mTargetRef;

    public Long getAdVolume() {
        return mAdVolume;
    }

    public void setAdVolume(Long adVolume) {
        mAdVolume = adVolume;
    }

    public String getCategoryId() {
        return mCategoryId;
    }

    public void setCategoryId(String categoryId) {
        mCategoryId = categoryId;
    }

    public String getOtherParams() {
        return mOtherParams;
    }

    public void setOtherParams(String otherParams) {
        mOtherParams = otherParams;
    }

    public String getPageRef() {
        return mPageRef;
    }

    public void setPageRef(String pageRef) {
        mPageRef = pageRef;
    }

    public String getPartnerId() {
        return mPartnerId;
    }

    public void setPartnerId(String partnerId) {
        mPartnerId = partnerId;
    }

    public String getTargetRef() {
        return mTargetRef;
    }

    public void setTargetRef(String targetRef) {
        mTargetRef = targetRef;
    }

}
