
package io.github.rootlol.yandexmusic.pojo.rotor.stations.dashboard;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

import io.github.rootlol.yandexmusic.pojo.InvocationInfo;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class PojoRotorStationsDashboard {

    @SerializedName("invocationInfo")
    private InvocationInfo mInvocationInfo;
    @SerializedName("result")
    private Result mResult;

    public InvocationInfo getInvocationInfo() {
        return mInvocationInfo;
    }

    public void setInvocationInfo(InvocationInfo invocationInfo) {
        mInvocationInfo = invocationInfo;
    }

    public Result getResult() {
        return mResult;
    }

    public void setResult(Result result) {
        mResult = result;
    }

}
