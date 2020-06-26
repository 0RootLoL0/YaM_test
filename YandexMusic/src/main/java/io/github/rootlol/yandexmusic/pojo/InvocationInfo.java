
/*
 * Copyright © 2020 . Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yandexmusic.pojo;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class InvocationInfo {

    @SerializedName("exec-duration-millis")
    private String mExecDurationMillis;
    @SerializedName("hostname")
    private String mHostname;
    @SerializedName("req-id")
    private String mReqId;

    public String getExecDurationMillis() {
        return mExecDurationMillis;
    }

    public void setExecDurationMillis(String execDurationMillis) {
        mExecDurationMillis = execDurationMillis;
    }

    public String getHostname() {
        return mHostname;
    }

    public void setHostname(String hostname) {
        mHostname = hostname;
    }

    public String getReqId() {
        return mReqId;
    }

    public void setReqId(String reqId) {
        mReqId = reqId;
    }

}
