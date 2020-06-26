
package io.github.rootlol.yandexmusic.pojo.rotor.stations.dashboard;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Station {

    @SerializedName("adParams")
    private AdParams mAdParams;
    @SerializedName("explanation")
    private String mExplanation;
    @SerializedName("fullImageUrl")
    private String mFullImageUrl;
    @SerializedName("geocellIcon")
    private GeocellIcon mGeocellIcon;
    @SerializedName("icon")
    private Icon mIcon;
    @SerializedName("id")
    private Id mId;
    @SerializedName("idForFrom")
    private String mIdForFrom;
    @SerializedName("mtsIcon")
    private MtsIcon mMtsIcon;
    @SerializedName("name")
    private String mName;
    @SerializedName("restrictions")
    private Restrictions mRestrictions;
    @SerializedName("restrictions2")
    private Restrictions2 mRestrictions2;
    @SerializedName("settings")
    private Settings mSettings;
    @SerializedName("settings2")
    private Settings2 mSettings2;
    @SerializedName("station")
    private Station mStation;

    public AdParams getAdParams() {
        return mAdParams;
    }

    public void setAdParams(AdParams adParams) {
        mAdParams = adParams;
    }

    public String getExplanation() {
        return mExplanation;
    }

    public void setExplanation(String explanation) {
        mExplanation = explanation;
    }

    public String getFullImageUrl() {
        return mFullImageUrl;
    }

    public void setFullImageUrl(String fullImageUrl) {
        mFullImageUrl = fullImageUrl;
    }

    public GeocellIcon getGeocellIcon() {
        return mGeocellIcon;
    }

    public void setGeocellIcon(GeocellIcon geocellIcon) {
        mGeocellIcon = geocellIcon;
    }

    public Icon getIcon() {
        return mIcon;
    }

    public void setIcon(Icon icon) {
        mIcon = icon;
    }

    public Id getId() {
        return mId;
    }

    public void setId(Id id) {
        mId = id;
    }

    public String getIdForFrom() {
        return mIdForFrom;
    }

    public void setIdForFrom(String idForFrom) {
        mIdForFrom = idForFrom;
    }

    public MtsIcon getMtsIcon() {
        return mMtsIcon;
    }

    public void setMtsIcon(MtsIcon mtsIcon) {
        mMtsIcon = mtsIcon;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Restrictions getRestrictions() {
        return mRestrictions;
    }

    public void setRestrictions(Restrictions restrictions) {
        mRestrictions = restrictions;
    }

    public Restrictions2 getRestrictions2() {
        return mRestrictions2;
    }

    public void setRestrictions2(Restrictions2 restrictions2) {
        mRestrictions2 = restrictions2;
    }

    public Settings getSettings() {
        return mSettings;
    }

    public void setSettings(Settings settings) {
        mSettings = settings;
    }

    public Settings2 getSettings2() {
        return mSettings2;
    }

    public void setSettings2(Settings2 settings2) {
        mSettings2 = settings2;
    }

    public Station getStation() {
        return mStation;
    }

    public void setStation(Station station) {
        mStation = station;
    }

}
