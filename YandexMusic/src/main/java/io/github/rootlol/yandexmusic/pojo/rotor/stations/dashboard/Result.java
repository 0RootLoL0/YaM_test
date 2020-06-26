
package io.github.rootlol.yandexmusic.pojo.rotor.stations.dashboard;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Result {

    @SerializedName("dashboardId")
    private String mDashboardId;
    @SerializedName("pumpkin")
    private Boolean mPumpkin;
    @SerializedName("stations")
    private List<Station> mStations;

    public String getDashboardId() {
        return mDashboardId;
    }

    public void setDashboardId(String dashboardId) {
        mDashboardId = dashboardId;
    }

    public Boolean getPumpkin() {
        return mPumpkin;
    }

    public void setPumpkin(Boolean pumpkin) {
        mPumpkin = pumpkin;
    }

    public List<Station> getStations() {
        return mStations;
    }

    public void setStations(List<Station> stations) {
        mStations = stations;
    }

}
