package exercise.P05_Online_Radio_Database;

import exercise.P05_Online_Radio_Database.exeptions.InvalidSongException;
import exercise.P05_Online_Radio_Database.modules.Playlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.parseInt(console.readLine());

        Playlist playlist = new Playlist();
        for (int i = 0; i < lines; i++) {
            String input = console.readLine();
            try {
                playlist.addSong(input);
                System.out.println("Song added.");
            } catch (InvalidSongException ex){
                System.out.println(ex.getMessage());
            }
        }

        System.out.printf("Songs added: %d%n", playlist.getSize());

        int length = playlist.getLength();
        int hours = length / 3600;
        int minutes = (length / 60) - (hours * 60);
        int seconds = length % 60;
        System.out.printf("Playlist length: %sh %sm %ss%n", hours, minutes, seconds);
    }
}
