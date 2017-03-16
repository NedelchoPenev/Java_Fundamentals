package exercise.P10_MooD_3;

public class Archangel<P> extends Character<P> {

    private final static String CHARACTER_TYPE = "Archangel";

    public Archangel(String username, int level, Integer mana) {
        super(username, CHARACTER_TYPE, level, mana);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString())
                .append(this.getSpecialPoints().intValue() * this.getLevel());

        return stringBuilder.toString();
    }
}
