
/*
 * Copyright © 2020 . Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yandexmusic.pojo.user.likes.tracks;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Result {

    @SerializedName("library")
    private Library mLibrary;

    public Library getLibrary() {
        return mLibrary;
    }

    public void setLibrary(Library library) {
        mLibrary = library;
    }

}
