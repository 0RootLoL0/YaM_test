
package io.github.rootlol.yandexmusic.pojo.feed;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Result {

    @SerializedName("canGetMoreEvents")
    private Boolean mCanGetMoreEvents;
    @SerializedName("days")
    private List<Day> mDays;
    @SerializedName("generatedPlaylists")
    private List<GeneratedPlaylist> mGeneratedPlaylists;
    @SerializedName("headlines")
    private List<Headline> mHeadlines;
    @SerializedName("isWizardPassed")
    private Boolean mIsWizardPassed;
    @SerializedName("nextRevision")
    private String mNextRevision;
    @SerializedName("pumpkin")
    private Boolean mPumpkin;
    @SerializedName("today")
    private String mToday;

    public Boolean getCanGetMoreEvents() {
        return mCanGetMoreEvents;
    }

    public void setCanGetMoreEvents(Boolean canGetMoreEvents) {
        mCanGetMoreEvents = canGetMoreEvents;
    }

    public List<Day> getDays() {
        return mDays;
    }

    public void setDays(List<Day> days) {
        mDays = days;
    }

    public List<GeneratedPlaylist> getGeneratedPlaylists() {
        return mGeneratedPlaylists;
    }

    public void setGeneratedPlaylists(List<GeneratedPlaylist> generatedPlaylists) {
        mGeneratedPlaylists = generatedPlaylists;
    }

    public List<Headline> getHeadlines() {
        return mHeadlines;
    }

    public void setHeadlines(List<Headline> headlines) {
        mHeadlines = headlines;
    }

    public Boolean getIsWizardPassed() {
        return mIsWizardPassed;
    }

    public void setIsWizardPassed(Boolean isWizardPassed) {
        mIsWizardPassed = isWizardPassed;
    }

    public String getNextRevision() {
        return mNextRevision;
    }

    public void setNextRevision(String nextRevision) {
        mNextRevision = nextRevision;
    }

    public Boolean getPumpkin() {
        return mPumpkin;
    }

    public void setPumpkin(Boolean pumpkin) {
        mPumpkin = pumpkin;
    }

    public String getToday() {
        return mToday;
    }

    public void setToday(String today) {
        mToday = today;
    }

}
