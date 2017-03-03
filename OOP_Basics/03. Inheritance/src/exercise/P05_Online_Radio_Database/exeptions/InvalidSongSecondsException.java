package exercise.P05_Online_Radio_Database.exeptions;

public class InvalidSongSecondsException extends InvalidSongLengthException {

    public static final String MESSAGE = "Song seconds should be between 0 and 59.";

    public InvalidSongSecondsException() {
        super(MESSAGE);
    }

    public InvalidSongSecondsException(String s) {
        super(s);
    }
}
