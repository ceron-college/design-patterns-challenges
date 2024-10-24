package com.ceron.implementation;

import java.util.HashMap;
import java.util.Map;

public class SongFactory {

    public static boolean enableFlyweight = true;
    private static final Map<String, Song> PLAY_SONG = new HashMap<>();
    private static final Map<String, Artist> PLAY_ARTIST = new HashMap<>();
    private static Long sequence = 0L;

    public static Song createItem(String songTitle, String artistName) {
        Artist artist;
        if (enableFlyweight && PLAY_ARTIST.containsKey(artistName)) {
            artist = PLAY_ARTIST.get(artistName);
        } else {
            artist = new Artist(artistName);
            PLAY_ARTIST.put(artistName, artist);
        }
        if (enableFlyweight && PLAY_SONG.containsKey(songTitle)) {
            return PLAY_SONG.get(songTitle);
        } else {
            Song songItem = new Song(++sequence, songTitle, artist);
            PLAY_SONG.put(songTitle, songItem);
            return songItem;
        }
    }
}
