
package io.github.rootlol.yandexmusic.pojo.rotor.stations.dashboard;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Restrictions {

    @SerializedName("diversity")
    private Diversity mDiversity;
    @SerializedName("energy")
    private Energy mEnergy;
    @SerializedName("language")
    private Language mLanguage;
    @SerializedName("mood")
    private Mood mMood;

    public Diversity getDiversity() {
        return mDiversity;
    }

    public void setDiversity(Diversity diversity) {
        mDiversity = diversity;
    }

    public Energy getEnergy() {
        return mEnergy;
    }

    public void setEnergy(Energy energy) {
        mEnergy = energy;
    }

    public Language getLanguage() {
        return mLanguage;
    }

    public void setLanguage(Language language) {
        mLanguage = language;
    }

    public Mood getMood() {
        return mMood;
    }

    public void setMood(Mood mood) {
        mMood = mood;
    }

}
