
package io.github.rootlol.yandexmusic.pojo.rotor.stations.dashboard;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Settings {

    @SerializedName("diversity")
    private String mDiversity;
    @SerializedName("energy")
    private Long mEnergy;
    @SerializedName("language")
    private String mLanguage;
    @SerializedName("mood")
    private Long mMood;

    public String getDiversity() {
        return mDiversity;
    }

    public void setDiversity(String diversity) {
        mDiversity = diversity;
    }

    public Long getEnergy() {
        return mEnergy;
    }

    public void setEnergy(Long energy) {
        mEnergy = energy;
    }

    public String getLanguage() {
        return mLanguage;
    }

    public void setLanguage(String language) {
        mLanguage = language;
    }

    public Long getMood() {
        return mMood;
    }

    public void setMood(Long mood) {
        mMood = mood;
    }

}
