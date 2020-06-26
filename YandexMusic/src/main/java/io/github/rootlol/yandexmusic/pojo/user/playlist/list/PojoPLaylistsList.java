
package io.github.rootlol.yandexmusic.pojo.user.playlist.list;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

import io.github.rootlol.yandexmusic.pojo.InvocationInfo;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class PojoPLaylistsList {

    @SerializedName("invocationInfo")
    private InvocationInfo mInvocationInfo;
    @SerializedName("result")
    private List<Result> mResult;

    public InvocationInfo getInvocationInfo() {
        return mInvocationInfo;
    }

    public void setInvocationInfo(InvocationInfo invocationInfo) {
        mInvocationInfo = invocationInfo;
    }

    public List<Result> getResult() {
        return mResult;
    }

    public void setResult(List<Result> result) {
        mResult = result;
    }

}
