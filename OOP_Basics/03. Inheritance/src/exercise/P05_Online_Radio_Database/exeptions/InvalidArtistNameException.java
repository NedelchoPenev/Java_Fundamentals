package exercise.P05_Online_Radio_Database.exeptions;

public class InvalidArtistNameException extends InvalidSongException {

    private static final String MESSAGE = "Artist name should be between 3 and 20 symbols.";

    public InvalidArtistNameException() {
        super(MESSAGE);
    }

    public InvalidArtistNameException(String s) {
        super(s);
    }
}
