package com.ceron.implementation;

public class Song {
    private Long id;
    private String songName;
    private Artist artist;
    private byte[] songData = new byte[1000000];

    public Song(Long id, String songName, Artist artist) {
        this.id = id;
        this.songName = songName;
        this.artist = artist;
    }

    public Song() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Song{" + "id=" + id + ", Title=" + songName + '}';
    }
}
