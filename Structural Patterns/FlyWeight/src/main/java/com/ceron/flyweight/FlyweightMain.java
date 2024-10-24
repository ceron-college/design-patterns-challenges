package com.ceron.flyweight;

import com.ceron.implementation.SongFactory;
import com.ceron.implementation.Playlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FlyweightMain {

    private static final String[] songNames = new String[1000];
    private static final String[] artistNames = new String[1000];
    private static final String[] playlistNames = new String[4_100_000];
    private static final List<Playlist> playlists = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(""
                + "Playlist creation process started,\n"
                + "this process may be very slow due to the large number of objects\n"
                + "that will be created, please wait a moment until \n"
                + "you are notified that the process has finished..");

        Runtime runtime = Runtime.getRuntime();
        System.out.println("MaxMemory > " + (runtime.maxMemory() / 1_000_000) + " MB");
        SongFactory.enableFlyweight = true;
        initializeArrays();
        createDynamicPlaylists();
        System.out.println("Total Playlists > " + playlists.size());

        long memoryUsed = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Memory Used => " + (memoryUsed / 1_000_000) + " MB");
    }

    private static void createDynamicPlaylists() {
        Random random = new Random();
        int progress = 0;
        for (int c = 0; c < playlistNames.length; c++) {
            Playlist playlist = new Playlist(playlistNames[c]);
            for (int i = 0; i < 10; i++) {
                int songIndex = random.nextInt(songNames.length);
                playlist.addSong(songNames[songIndex], artistNames[songIndex]);
            }
            playlists.add(playlist);
            if (c != 0 && (c + 1) % (playlistNames.length / 10) == 0) {
                progress += 10;
                System.out.println("Completed " + progress + "%");
                System.out.println("Playlists Created " + playlists.size());
            }
        }
    }

    private static void initializeArrays() {
        for (int c = 0; c < songNames.length; c++) {
            songNames[c] = "Song " + (c + 1);
            artistNames[c] = "Artist " + (c + 1);
        }

        for (int c = 0; c < playlistNames.length; c++) {
            playlistNames[c] = "Playlist " + (c + 1);
        }
    }
}
