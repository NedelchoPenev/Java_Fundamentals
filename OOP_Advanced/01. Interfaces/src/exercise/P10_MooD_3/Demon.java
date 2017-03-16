package exercise.P10_MooD_3;

import java.lang.*;

public class Demon<P> extends Character<P> {

    private final static String CHARACTER_TYPE = "Demon";

    public Demon(String username, int level, Double energy) {
        super(username, CHARACTER_TYPE, level, energy);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString())
                .append(this.getSpecialPoints().doubleValue() * this.getLevel());

        return stringBuilder.toString();
    }
}
