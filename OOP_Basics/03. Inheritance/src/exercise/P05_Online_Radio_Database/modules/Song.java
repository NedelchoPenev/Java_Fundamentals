package exercise.P05_Online_Radio_Database.modules;

import exercise.P05_Online_Radio_Database.exeptions.InvalidArtistNameException;
import exercise.P05_Online_Radio_Database.exeptions.InvalidSongMinutesException;
import exercise.P05_Online_Radio_Database.exeptions.InvalidSongNameException;
import exercise.P05_Online_Radio_Database.exeptions.InvalidSongSecondsException;

public class Song {

    private String artistName;
    private String songName;
    private int minutes;
    private int seconds;

    public Song(String artistName, String songName, int minutes, int seconds) {
        this.setArtistName(artistName);
        this.setSongName(songName);
        this.setMinutes(minutes);
        this.setSeconds(seconds);
    }

    private String getArtistName() {
        return artistName;
    }

    private void setArtistName(String artistName) {
        if (artistName == null || artistName.trim().length() < 3 || artistName.length() > 20){
            throw new InvalidArtistNameException();
        }
        this.artistName = artistName;
    }

    private String getSongName() {
        return songName;
    }

    private void setSongName(String songName) {
        if (songName == null || songName.trim().length() < 3 || songName.length() > 30){
            throw new InvalidSongNameException();
        }
        this.songName = songName;
    }

    protected int getMinutes() {
        return minutes;
    }

    private void setMinutes(int minutes) {
        if (minutes < 0 || minutes > 14){
            throw new InvalidSongMinutesException();
        }
        this.minutes = minutes;
    }

    protected int getSeconds() {
        return seconds;
    }

    private void setSeconds(int seconds) {
        if (seconds < 0 || seconds > 59){
            throw new InvalidSongSecondsException();
        }
        this.seconds = seconds;
    }
}
