package com.ceron.implementation;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private String playlistName;
    private List<Song> songs = new ArrayList<>();

    public Playlist(String playlistName) {
        this.playlistName = playlistName;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public void addSong(String songName, String artistName) {
        songs.add(SongFactory.createItem(songName, artistName));
    }

    public void printList() {
        String out = "\nPlaylist > " + playlistName;
        for (Song songItem : songs) {
            out += "\n\t" + songItem.toString();
        }
        System.out.println(out);
    }
}
