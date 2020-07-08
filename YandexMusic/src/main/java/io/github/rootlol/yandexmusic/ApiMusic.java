/*
 * Copyright © 2020 . Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yandexmusic;

import com.google.gson.JsonObject;

import org.json.simple.JSONObject;

import java.util.Map;

import io.github.rootlol.jsonsimpleconverter.JsonSimpleConverterFactory;
import io.github.rootlol.yandexmusic.pojo.feed.PojoFeed;
import io.github.rootlol.yandexmusic.pojo.rotor.stations.dashboard.PojoRotorStationsDashboard;
import io.github.rootlol.yandexmusic.pojo.tracks.PojoTracks;
import io.github.rootlol.yandexmusic.pojo.tracks.downloadinfo.PojoTracksDownloadInfo;
import io.github.rootlol.yandexmusic.pojo.user.likes.tracks.PojoLikesTracks;
import io.github.rootlol.yandexmusic.pojo.user.playlist.PojoPlaylists;
import io.github.rootlol.yandexmusic.pojo.user.playlist.list.PojoPLaylistsList;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public class ApiMusic {
    public interface Api {
        @GET("feed")
        Call<PojoFeed> getFeed(@Header("Authorization") String authorization);

        @FormUrlEncoded
        @POST("users/{id}/playlists")
        Call<PojoPlaylists> getTrackList(@Path("id") int UserId, @Header("Authorization") String authorization, @FieldMap Map<String, String> body);

        @GET("users/{id}/playlists/list")
        Call<PojoPLaylistsList> getPlaylists(@Path("id") int UserId, @Header("Authorization") String authorization);

        @GET("users/{id}/likes/tracks")
        Call<PojoLikesTracks> getGetLikes(@Path("id") int UserId, @Header("Authorization") String authorization);

        @GET("tracks/{id}")
        Call<PojoTracks> getTrackInfo(@Path("id") int TrackId);

        @GET("tracks/{id}/download-info")
        Call<PojoTracksDownloadInfo> getDownloadInfoUrl(@Path("id") int TrackId, @Header("Authorization") String authorization);

        @GET("rotor/stations/dashboard")
        Call<PojoRotorStationsDashboard> getRotorStationsDashboard(@Header("Authorization") String authorization);

        @GET("/search/suggest")
        Call<JSONObject> getSearchSuggest(@Header("Authorization") String authorization, @Query("part") String part);

        @GET
        Call<String> downloadUrl(@Url String url);

        @GET
        @Streaming
        Call<ResponseBody> getCover(@Url String filepath);
    }

    private static String urlBase = "https://api.music.yandex.net/";
    private static Retrofit retrofit;
    private static Api api;

    public static Api getInstance(){
        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(JsonSimpleConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(urlBase)
                    .build();
        }
        api = retrofit.create(Api.class);
        return api;
    }
}
