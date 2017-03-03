package exercise.P05_Online_Radio_Database.exeptions;

public class InvalidSongNameException extends InvalidSongException {

    public static final String MESSAGE = "Song name should be between 3 and 30 symbols.";

    public InvalidSongNameException() {
        super(MESSAGE);
    }

    public InvalidSongNameException(String s) {
        super(s);
    }
}
