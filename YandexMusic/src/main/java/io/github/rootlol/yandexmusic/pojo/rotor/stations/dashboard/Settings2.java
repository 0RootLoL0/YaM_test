
package io.github.rootlol.yandexmusic.pojo.rotor.stations.dashboard;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Settings2 {

    @SerializedName("diversity")
    private String mDiversity;
    @SerializedName("language")
    private String mLanguage;
    @SerializedName("moodEnergy")
    private String mMoodEnergy;

    public String getDiversity() {
        return mDiversity;
    }

    public void setDiversity(String diversity) {
        mDiversity = diversity;
    }

    public String getLanguage() {
        return mLanguage;
    }

    public void setLanguage(String language) {
        mLanguage = language;
    }

    public String getMoodEnergy() {
        return mMoodEnergy;
    }

    public void setMoodEnergy(String moodEnergy) {
        mMoodEnergy = moodEnergy;
    }

}
