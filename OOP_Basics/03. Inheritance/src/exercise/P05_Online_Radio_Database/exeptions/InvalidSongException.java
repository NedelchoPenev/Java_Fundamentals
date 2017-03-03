package exercise.P05_Online_Radio_Database.exeptions;

public class InvalidSongException extends NumberFormatException{

    public static final String MESSAGE = "Invalid song.";

    public InvalidSongException() {
        super(MESSAGE);
    }

    public InvalidSongException(String s) {
        super(s);
    }
}
