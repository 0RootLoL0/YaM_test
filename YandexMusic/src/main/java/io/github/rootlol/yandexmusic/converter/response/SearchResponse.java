/*
 * Copyright © 2020 . Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yandexmusic.converter.response;

import java.util.ArrayList;
import java.util.List;

public class SearchResponse {


    public String text;
    public best best = new best();
    public List<Music.playlist> playlists = new ArrayList<>();
    public List<Music.video> videos = new ArrayList<>();
    public List<Music.album> albums = new ArrayList<>();
    public List<Music.artist> artists = new ArrayList<>();
    public List<Music.track> tracks = new ArrayList<>();

    public class best{
        public String type;
        public Music result;
    }

}