package exercise.P10_MooD_3;

public abstract class Character<P> implements GameObject<P> {

    private String username;
    private String characterType;
    private int level;
    private Number specialPoints;
    private P hashedPassword;

    protected Character(String username, String characterType, int level, Number specialPoints) {
        this.setUsername(username);
        this.setCharacterType(characterType);
        this.setLevel(level);
        this.setSpecialPoints(specialPoints);
    }

    @Override
    public String getUsername() {
        return username;
    }

    private void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getCharacterType() {
        return characterType;
    }

    private void setCharacterType(String characterType) {
        this.characterType = characterType;
    }

    @Override
    public int getLevel() {
        return level;
    }

    private void setLevel(int level) {
        this.level = level;
    }

    @Override
    public Number getSpecialPoints() {
        return specialPoints;
    }

    private void setSpecialPoints(Number specialPoints) {
        this.specialPoints = specialPoints;
    }

    @Override
    public P getHashedPassword() {
        return hashedPassword;
    }

    @Override
    public void setHashedPassword(P hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("\"%s\" | \"%s\" -> %s%n",
                this.getUsername(),
                this.getHashedPassword(),
                this.getCharacterType()));

        return stringBuilder.toString();
    }
}
