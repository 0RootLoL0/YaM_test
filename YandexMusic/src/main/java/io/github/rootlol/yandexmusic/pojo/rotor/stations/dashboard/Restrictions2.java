
package io.github.rootlol.yandexmusic.pojo.rotor.stations.dashboard;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Restrictions2 {

    @SerializedName("diversity")
    private Diversity mDiversity;
    @SerializedName("language")
    private Language mLanguage;
    @SerializedName("moodEnergy")
    private MoodEnergy mMoodEnergy;

    public Diversity getDiversity() {
        return mDiversity;
    }

    public void setDiversity(Diversity diversity) {
        mDiversity = diversity;
    }

    public Language getLanguage() {
        return mLanguage;
    }

    public void setLanguage(Language language) {
        mLanguage = language;
    }

    public MoodEnergy getMoodEnergy() {
        return mMoodEnergy;
    }

    public void setMoodEnergy(MoodEnergy moodEnergy) {
        mMoodEnergy = moodEnergy;
    }

}
