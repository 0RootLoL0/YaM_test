/*
 * Copyright © 2020 . Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yandexmusic;

import io.github.rootlol.yandexmusic.pojo.feed.PojoFeed;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Header;

public class ApiMusic {
    public interface Api {
        @GET("feed")
        Call<PojoFeed> getFeed(@Header("Authorization") String authorization);
    }

    private static String urlBase = "https://api.music.yandex.net/";
    private static Retrofit retrofit;
    private static Api api;

    public static Api getInstance(){
        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(urlBase)
                    .build();
        }
        api = retrofit.create(Api.class);
        return api;
    }
}
