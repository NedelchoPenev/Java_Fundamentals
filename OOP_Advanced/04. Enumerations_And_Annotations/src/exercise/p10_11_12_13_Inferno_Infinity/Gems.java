package exercise.p10_11_12_13_Inferno_Infinity;

public enum Gems {

    RUBY(7, 2, 5),
    EMERALD(1, 4, 9),
    AMETHYST(2, 8, 4);

    private int strength;
    private int agility;
    private int vitality;

    Gems(int strength, int agility, int vitality) {
        this.strength = strength;
        this.agility = agility;
        this.vitality = vitality;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getVitality() {
        return vitality;
    }
}
