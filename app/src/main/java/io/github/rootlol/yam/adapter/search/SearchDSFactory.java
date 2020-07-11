/*
 * Copyright © 2020 . Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yam.adapter.search;

import android.accounts.AccountManager;
import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.widget.Toast;

import androidx.annotation.NonNull;

import androidx.paging.DataSource;

import androidx.paging.PositionalDataSource;

import java.util.ArrayList;
import java.util.List;

import io.github.rootlol.yam.App;
import io.github.rootlol.yam.account.AccountUtils;
import io.github.rootlol.yam.controller.home.SearchSubHome;
import io.github.rootlol.yamadapter.YamAdapterInterface;
import io.github.rootlol.yamadapter.YamDataSourceFactory;
import io.github.rootlol.yamadapter.YamVHFactory;
import io.github.rootlol.yamadapter.item.ItemAlbum;
import io.github.rootlol.yamadapter.item.ItemArtist;
import io.github.rootlol.yamadapter.item.ItemPlaylist;
import io.github.rootlol.yamadapter.item.ItemTrack;
import io.github.rootlol.yamadapter.item.ItemVideo;
import io.github.rootlol.yandexmusic.ApiMusic;
import io.github.rootlol.yandexmusic.converter.response.Music;
import io.github.rootlol.yandexmusic.converter.response.SearchResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchDSFactory extends YamDataSourceFactory {
    private SearchVHFactory VHFactory;
    private Context context;
    private String searchRec;

    public SearchDSFactory(Context context, String searchRec) {
        this.context = context;
        this.searchRec = searchRec;
    }

    @Override
    public YamVHFactory getVHFactory() {
        if (VHFactory == null){
            VHFactory = new SearchVHFactory();
        }
        return VHFactory;
    }

    @Override
    public DataSource create() {
        return new SearchDataSourse();
    }
    public class SearchDataSourse extends PositionalDataSource<YamAdapterInterface> {
        List<YamAdapterInterface> temp = new ArrayList<>();

        @SuppressLint("WrongThread")
        @Override
        public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback<YamAdapterInterface> callback) {
            ApiMusic.getInstance().getSearch(AccountManager.get(context).peekAuthToken(App.getAccount(), AccountUtils.AUTH_TOKEN_TYPE), searchRec, "0", "all").enqueue(new Callback<SearchResponse>() {
                @Override
                public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {

                    SearchResponse res = response.body();
                    switch (res.best.type){
                        case Music.ALBUM:
                            temp.add(new ItemAlbum());
                            break;
                        case Music.ARTIST:
                            temp.add(new ItemArtist(
                                    Uri.parse(((Music.artist) res.best.result).cover),
                                    ((Music.artist) res.best.result).name,
                                    ((Music.artist) res.best.result).counts_tracks,
                                    ((Music.artist) res.best.result).counts_directAlbums,
                                    ((Music.artist) res.best.result).counts_alsoAlbums,
                                    ((Music.artist) res.best.result).counts_alsoTracks
                            ));
                            break;
                        case Music.PLAYLIST:
                            temp.add(new ItemPlaylist(
                                    Uri.parse(((Music.playlist) res.best.result).cover),
                                    ((Music.playlist) res.best.result).title,
                                    Integer.toString( ((Music.playlist) res.best.result).trackCount)
                            ));
                            break;
                        case Music.TRACK:
                            temp.add(new ItemTrack(
                                    Uri.parse(((Music.track) res.best.result).albums_coverUri),
                                    ((Music.track) res.best.result).title,
                                    ((Music.track) res.best.result).artists_name
                            ));
                            break;
                        case Music.VIDEO:
                            temp.add(new ItemVideo(
                                    Uri.parse(((Music.video) res.best.result).thumbnailUrl),
                                    ((Music.video) res.best.result).title,
                                    ((Music.video) res.best.result).youtubeUrl
                            ));
                    }

                    for (Music.artist artist: res.artists) {
                        temp.add(new ItemArtist(
                                Uri.parse(artist.cover),
                                artist.name,
                                artist.counts_tracks,
                                artist.counts_directAlbums,
                                artist.counts_alsoAlbums,
                                artist.counts_alsoTracks
                        ));
                    }
                    for (Music.album album: res.albums){
                        temp.add(new ItemAlbum());
                    }
                    for (Music.track track: res.tracks){
                        temp.add(new ItemTrack(
                                Uri.parse(track.albums_coverUri),
                                track.title,
                                track.artists_name
                        ));
                    }
                    for (Music.playlist playlist: res.playlists){
                        temp.add(new ItemPlaylist(
                                Uri.parse(playlist.cover),
                                playlist.title,
                                Integer.toString( playlist.trackCount)
                        ));
                    }
                    for (Music.video video: res.videos){
                        temp.add(new ItemVideo(
                                Uri.parse(video.thumbnailUrl),
                                video.title,
                                video.youtubeUrl
                        ));
                    }


                    SearchSubHome.visibilityNR(false);
                    int llz;
                    if (temp.size() >= params.pageSize) llz = params.pageSize;
                    else llz = temp.size();
                    callback.onResult(temp.subList(0, llz), 0);
                }

                @Override
                public void onFailure(Call<SearchResponse> call, Throwable t) {
                    Toast.makeText(context, "net error", Toast.LENGTH_LONG).show();
                }
            });
        }

        @Override
        public void loadRange(@NonNull LoadRangeParams params, @NonNull LoadRangeCallback<YamAdapterInterface> callback) {
            if (temp.size()-params.startPosition>=params.loadSize) callback.onResult(temp.subList(params.startPosition, params.startPosition + params.loadSize));
            else if (temp.size()-params.startPosition==0) callback.onResult(new ArrayList<>());
            else callback.onResult(temp.subList(params.startPosition, temp.size()));
        }
    }
}