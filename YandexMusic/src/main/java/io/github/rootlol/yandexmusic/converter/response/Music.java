/*
 * Copyright © 2020 . Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yandexmusic.converter.response;

import java.util.List;

public class Music {
    public final static String PLAYLIST = "playlist";
    public final static String TRACK = "track";
    public final static String VIDEO = "video";
    public final static String ALBUM = "album";
    public final static String ARTIST = "artist";
    public static class playlist extends Music {
        public int uid;
        public int kind;
        public int trackCount;
        public String title;
        public String cover;
        public List<String> tags;
        public List<String> regions;
    }
    public static class video extends Music {
        public String youtubeUrl;
        public String thumbnailUrl;
        public String title;
    }
    public static class album extends Music {
        public int id;
        public int year;
        public String coverUri;
        public String title;
        public String artists_name;
        public String type;
    }
    public static class artist extends Music {
        public int id;
        public String name;
        public String cover;
        public int counts_tracks;
        public int counts_directAlbums;
        public int counts_alsoAlbums;
        public int counts_alsoTracks;

    }
    public static class track extends Music {
        public int id;
        public String title;
        public String albums_title;
        public String albums_coverUri;
        public String artists_name;
    }
}
