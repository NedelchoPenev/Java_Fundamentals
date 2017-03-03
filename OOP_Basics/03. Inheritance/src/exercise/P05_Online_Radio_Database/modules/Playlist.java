package exercise.P05_Online_Radio_Database.modules;

import exercise.P05_Online_Radio_Database.exeptions.InvalidSongLengthException;

import java.util.ArrayList;
import java.util.List;

public class Playlist {

    private List<Song> songs;

    public Playlist() {
        this.songs = new ArrayList<>();
    }

    public int getSize() {
        return this.songs.size();
    }

    public int getLength() {
        int length = 0;
        for (Song song : songs) {
            length += (song.getMinutes() * 60) + song.getSeconds();
        }

        return length;
    }

    public void addSong(String songInfo) {
        String[] split = songInfo.split(";");
        String artistName = split[0];
        String songName = split[1];
        String[] length = split[2].split(":");
        int minutes = 0;
        int seconds = 0;
        try {
            minutes = Integer.parseInt(length[0]);
            seconds = Integer.parseInt(length[1]);
        } catch (NumberFormatException ex) {
            throw new InvalidSongLengthException();
        }


        this.songs.add(new Song(artistName, songName, minutes, seconds));
    }
}
