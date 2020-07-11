/*
 * Copyright © 2020 . Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yandexmusic.converter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.github.rootlol.yandexmusic.converter.response.Music;
import io.github.rootlol.yandexmusic.converter.response.SearchResponse;
import okhttp3.ResponseBody;
import retrofit2.Converter;

public class SearchConverter implements Converter<ResponseBody, SearchResponse> {

    YamConverterFactory.CallbackConverter callbackJsonSimpleConverter;
    public SearchConverter(YamConverterFactory.CallbackConverter callbackJsonSimpleConverter) {
        this.callbackJsonSimpleConverter = callbackJsonSimpleConverter;
    }

    public SearchConverter() {
    }

    public SearchResponse convert(String value) {
        SearchResponse data = new SearchResponse();
        try {
            JSONObject result = ((JSONObject) ((JSONObject) JSONValue.parseWithException(value)).get("result"));
            data.text = (String) result.get("text");
            JSONObject best = (JSONObject) result.get("best");
            data.best.type = (String) best.get("type");
            JSONObject b_result_j = (JSONObject) best.get("result");
            switch (data.best.type){
                case Music.ARTIST:
                    Music.artist b_result_artist = new Music.artist();
                    b_result_artist.id = Integer.parseInt(Long.toString((Long) b_result_j.get("id")));
                    b_result_artist.name = (String)  b_result_j.get("name");
                    b_result_artist.cover = "https://" + ((String) ((JSONObject) b_result_j.get("cover")).get("uri")).replace("%%", "100x100");
                    JSONObject b_result_j_counts = (JSONObject) b_result_j.get("counts");
                    b_result_artist.counts_tracks = Integer.parseInt(Long.toString((Long) b_result_j_counts.get("tracks")));
                    b_result_artist.counts_directAlbums = Integer.parseInt(Long.toString((Long) b_result_j_counts.get("directAlbums")));
                    b_result_artist.counts_alsoAlbums = Integer.parseInt(Long.toString((Long) b_result_j_counts.get("alsoAlbums")));
                    b_result_artist.counts_alsoTracks = Integer.parseInt(Long.toString((Long) b_result_j_counts.get("alsoTracks")));
                    data.best.result = b_result_artist;
                    break;
                case Music.PLAYLIST:
                    Music.playlist b_result_playlist = new Music.playlist();
                    try {
                        b_result_playlist.cover = "https://" + ((String) ((JSONObject) b_result_j.get("cover")).get("uri")).replace("%%", "100x100");
                    } catch (Exception e){
                        try {
                            b_result_playlist.cover = "https://" + ((String) ((JSONArray) ((JSONObject) b_result_j.get("cover")).get("itemsUri")).get(0)).replace("%%", "100x100");
                        } catch (Exception ee){}
                    }
                    b_result_playlist.kind = Integer.parseInt(Long.toString((Long) b_result_j.get("kind")));
                    b_result_playlist.title = (String) b_result_j.get("title");
                    b_result_playlist.trackCount = Integer.parseInt(Long.toString((Long) b_result_j.get("trackCount")));
                    data.best.result = b_result_playlist;
                    break;
                case Music.VIDEO:
                    Music.video b_result_video = new Music.video();
                    b_result_video.title        = (String) b_result_j.get("title");
                    b_result_video.youtubeUrl   = (String) b_result_j.get("youtubeUrl");
                    b_result_video.thumbnailUrl = ((String) b_result_j.get("thumbnailUrl")).replace("%%x%%", "");
                    data.best.result = b_result_video;
                    break;
                case Music.TRACK:
                    Music.track b_result_track = new Music.track();
                    JSONObject albums = ((JSONObject) ((JSONArray) b_result_j.get("albums")).get(0));
                    b_result_track.albums_coverUri = "https://" + ((String) albums.get("coverUri")).replace("%%", "100x100");
                    b_result_track.id = Integer.parseInt(Long.toString((Long) b_result_j.get("id")));
                    b_result_track.title = (String) b_result_j.get("title");
                    b_result_track.artists_name = (String) ((JSONObject) ((JSONArray) b_result_j.get("albums")).get(0) ).get("name");
                    b_result_track.albums_title = (String) albums.get("title");
                    data.best.result = b_result_track;
                    break;
                case Music.ALBUM:
                    Music.album b_result_album = new Music.album();
                    b_result_album.id = Integer.parseInt(Long.toString((Long) b_result_j.get("id")));
                    b_result_album.year = Integer.parseInt(Long.toString((Long) b_result_j.get("year")));
                    b_result_album.type = (String) b_result_j.get("type");
                    b_result_album.coverUri = "https://" + ((String) b_result_j.get("coverUri")).replace("%%", "100x100");
                    b_result_album.title = (String) b_result_j.get("title");
                    b_result_album.artists_name = (String) ((JSONObject) ( (JSONArray) b_result_j.get("artists") ).get(0)).get("name");
                    data.best.result = b_result_album;
                    break;
            }

            try {
                List<Music.playlist> l_playlists = new ArrayList();
                JSONArray playlists = (JSONArray) ((JSONObject) result.get("playlists")).get("results");
                for (int i = 0; i < playlists.size(); i++) {
                    Music.playlist b_result_playlist = new Music.playlist();
                    JSONObject playlists_j = (JSONObject) playlists.get(i);
                    b_result_playlist.cover = "https://" + ((String) ((JSONObject) playlists_j.get("cover")).get("uri")).replace("%%", "100x100");
                    b_result_playlist.kind = Integer.parseInt(Long.toString((Long) playlists_j.get("kind")));
                    b_result_playlist.title = (String) playlists_j.get("title");
                    b_result_playlist.trackCount = Integer.parseInt(Long.toString((Long) playlists_j.get("trackCount")));
                    l_playlists.add(b_result_playlist);
                }
                data.playlists.addAll(l_playlists);
            }catch (Exception e){}
            try {
                List<Music.video> l_videos = new ArrayList();
                JSONArray videos = (JSONArray) ((JSONObject) result.get("videos")).get("results");
                for (int i = 0; i < videos.size(); i++) {
                    Music.video b_result_video = new Music.video();
                    JSONObject videos_j = (JSONObject) videos.get(i);
                    b_result_video.title        = (String) videos_j.get("title");
                    b_result_video.youtubeUrl   = (String) videos_j.get("youtubeUrl");
                    b_result_video.thumbnailUrl = (String) videos_j.get("thumbnailUrl");
                    l_videos.add(b_result_video);
                }
                data.videos.addAll(l_videos);
            }catch (Exception e){}
            try {
                List<Music.album> l_albums = new ArrayList();
                JSONArray albums = (JSONArray) ((JSONObject) result.get("albums")).get("results");
                for (int i = 0; i < albums.size(); i++) {
                    Music.album b_result_album = new Music.album();
                    JSONObject albums_j = (JSONObject) albums.get(i);
                    b_result_album.id = Integer.parseInt(Long.toString((Long) albums_j.get("id")));
                    b_result_album.year = Integer.parseInt(Long.toString((Long) albums_j.get("year")));
                    b_result_album.type = (String) albums_j.get("type");
                    b_result_album.coverUri = "https://" + ((String) albums_j.get("coverUri")).replace("%%", "100x100");
                    b_result_album.title = (String) albums_j.get("title");
                    b_result_album.artists_name = (String) ((JSONObject) ( (JSONArray) albums_j.get("artists") ).get(0)).get("name");
                    l_albums.add(b_result_album);
                }
                data.albums = l_albums;
            }catch (Exception e){}
            try {
                List<Music.artist> l_artists = new ArrayList();
                JSONArray artists = (JSONArray) ((JSONObject) result.get("artists")).get("results");
                for (int i = 0; i < artists.size(); i++) {
                    Music.artist b_result_artist = new Music.artist();
                    JSONObject artist_j = (JSONObject) artists.get(i);
                    b_result_artist.id = Integer.parseInt(Long.toString((Long) artist_j.get("id")));
                    b_result_artist.name = (String)  artist_j.get("name");
                    b_result_artist.cover = "https://" + ((String) ((JSONObject) artist_j.get("cover")).get("uri")).replace("%%", "100x100");
                    JSONObject b_result_j_counts = (JSONObject) artist_j.get("counts");
                    b_result_artist.counts_tracks = Integer.parseInt(Long.toString((Long) b_result_j_counts.get("tracks")));
                    b_result_artist.counts_directAlbums = Integer.parseInt(Long.toString((Long) b_result_j_counts.get("directAlbums")));
                    b_result_artist.counts_alsoAlbums = Integer.parseInt(Long.toString((Long) b_result_j_counts.get("alsoAlbums")));
                    b_result_artist.counts_alsoTracks = Integer.parseInt(Long.toString((Long) b_result_j_counts.get("alsoTracks")));
                    l_artists.add(b_result_artist);
                }
                data.artists = l_artists;
            }catch (Exception e){}
            try {
                List<Music.track> l_tracks = new ArrayList();
                JSONArray tracks = (JSONArray) ((JSONObject) result.get("tracks")).get("results");
                for (int i = 0; i < tracks.size(); i++) {
                    Music.track b_result_track = new Music.track();
                    JSONObject albums = ((JSONObject) ((JSONArray) b_result_j.get("albums")).get(0));
                    b_result_track.albums_coverUri = "https://" + ((String) albums.get("coverUri")).replace("%%", "100x100");
                    b_result_track.id = Integer.parseInt(Long.toString((Long) b_result_j.get("id")));
                    b_result_track.title = (String) b_result_j.get("title");
                    b_result_track.artists_name = (String) ((JSONObject) ((JSONArray) b_result_j.get("albums")).get(0) ).get("name");
                    b_result_track.albums_title = (String) albums.get("title");
                    l_tracks.add(b_result_track);
                }
                data.tracks = l_tracks;
            }catch (Exception e){}

        } catch (Exception e) {
            callbackJsonSimpleConverter.JsonErrorParse(e.toString(), value);
        }
        return data;
    }


    @Override
    public SearchResponse convert(ResponseBody value)  throws IOException  {
        return convert(value.string());
    }
}