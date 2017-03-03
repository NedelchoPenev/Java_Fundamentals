package exercise.P05_Online_Radio_Database.exeptions;

public class InvalidSongLengthException extends InvalidSongException{

    public static final String MESSAGE = "Invalid song length.";

    public InvalidSongLengthException() {
        super(MESSAGE);
    }

    public InvalidSongLengthException(String s) {
        super(s);
    }
}
