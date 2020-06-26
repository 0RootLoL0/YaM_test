
package io.github.rootlol.yandexmusic.pojo.rotor.stations.dashboard;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class MoodEnergy {

    @SerializedName("name")
    private String mName;
    @SerializedName("possibleValues")
    private List<PossibleValue> mPossibleValues;
    @SerializedName("type")
    private String mType;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public List<PossibleValue> getPossibleValues() {
        return mPossibleValues;
    }

    public void setPossibleValues(List<PossibleValue> possibleValues) {
        mPossibleValues = possibleValues;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

}
