
package io.github.rootlol.yandexmusic.pojo.feed;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class MadeFor {

    @SerializedName("caseForms")
    private CaseForms mCaseForms;
    @SerializedName("userInfo")
    private UserInfo mUserInfo;

    public CaseForms getCaseForms() {
        return mCaseForms;
    }

    public void setCaseForms(CaseForms caseForms) {
        mCaseForms = caseForms;
    }

    public UserInfo getUserInfo() {
        return mUserInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        mUserInfo = userInfo;
    }

}
