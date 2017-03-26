package lab.P02_Warning_Levels;

public class Message {

    private Importance level;
    private String content;

    public Message(Importance level, String content) {
        this.level = level;
        this.content = content;
    }

    public Importance getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.getLevel(), this.content);
    }
}
