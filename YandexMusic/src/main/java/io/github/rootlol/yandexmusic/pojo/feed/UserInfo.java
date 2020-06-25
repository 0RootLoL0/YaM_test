
package io.github.rootlol.yandexmusic.pojo.feed;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class UserInfo {

    @SerializedName("login")
    private String mLogin;
    @SerializedName("name")
    private String mName;
    @SerializedName("sex")
    private String mSex;
    @SerializedName("uid")
    private Long mUid;
    @SerializedName("verified")
    private Boolean mVerified;

    public String getLogin() {
        return mLogin;
    }

    public void setLogin(String login) {
        mLogin = login;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getSex() {
        return mSex;
    }

    public void setSex(String sex) {
        mSex = sex;
    }

    public Long getUid() {
        return mUid;
    }

    public void setUid(Long uid) {
        mUid = uid;
    }

    public Boolean getVerified() {
        return mVerified;
    }

    public void setVerified(Boolean verified) {
        mVerified = verified;
    }

}
