
/*
 * Copyright © 2020 . Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yandexmusic.pojo.user.likes.tracks;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

import io.github.rootlol.yandexmusic.pojo.InvocationInfo;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class PojoLikesTracks {

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
