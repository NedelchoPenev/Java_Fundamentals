package exercise.P10_MooD_3;

public interface GameObject<P> {

    String getUsername();

    String getCharacterType();

    Number getSpecialPoints();

    int getLevel();

    P getHashedPassword();

    void setHashedPassword(P hashedPassword);
}
