package exercise.P05_Online_Radio_Database.exeptions;

public class InvalidSongMinutesException extends InvalidSongLengthException {

    public static final String MESSAGE = "Song minutes should be between 0 and 14.";

    public InvalidSongMinutesException() {
        super(MESSAGE);
    }

    public InvalidSongMinutesException(String s) {
        super(s);
    }
}
