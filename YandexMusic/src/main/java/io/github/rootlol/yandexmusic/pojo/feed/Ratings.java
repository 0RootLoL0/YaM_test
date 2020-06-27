
package io.github.rootlol.yandexmusic.pojo.feed;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Ratings {

    @SerializedName("day")
    private Long mDay;
    @SerializedName("month")
    private Long mMonth;
    @SerializedName("week")
    private Long mWeek;

    public Long getDay() {
        return mDay;
    }

    public void setDay(Long day) {
        mDay = day;
    }

    public Long getMonth() {
        return mMonth;
    }

    public void setMonth(Long month) {
        mMonth = month;
    }

    public Long getWeek() {
        return mWeek;
    }

    public void setWeek(Long week) {
        mWeek = week;
    }

}
