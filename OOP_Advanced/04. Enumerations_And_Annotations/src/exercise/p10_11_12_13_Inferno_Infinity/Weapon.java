package exercise.p10_11_12_13_Inferno_Infinity;

@ClassInfo(author = "Pesho",
        revision = 3,
        description = "Used for Java OOP Advanced course - Enumerations and Annotations.",
        reviewers = {"Pesho", "Svetlio"})
public class Weapon implements Comparable<Weapon>{

    private static final int STRENGTH_ADDITION_TO_MIN = 2;
    private static final int STRENGTH_ADDITION_TO_MAX = 3;
    private static final int AGILITY_ADDITION_TO_MAX = 4;

    private WeaponsType type;
    private String name;
    private Gems[] gems;

    public Weapon(WeaponsType type, String name) {
        this.type = type;
        this.name = name;
        this.gems = new Gems[type.getSockets()];
    }

    public void addGem(int index, Gems gem) {
        if (index >= 0 && index < this.gems.length){
            this.gems[index] = gem;
        }
    }

    public void removeGem(int index) {
        if (index >= 0 && index < this.gems.length){
            this.gems[index] = null;
        }
    }

    private int getMinDamage() {
        int minDamage = this.type.getMinDamage();
        for (Gems socket : gems) {
            if (socket != null) {
                minDamage += 2 * socket.getStrength();
                minDamage += socket.getAgility();
            }
        }

        return minDamage;
    }

    private int getMaxDamage() {
        int maxDamage = this.type.getMaxDamage();
        for (Gems socket : gems) {
            if (socket != null) {
                maxDamage += 3 * socket.getStrength();
                maxDamage += 4 * socket.getAgility();
            }
        }

        return maxDamage;
    }

    private int getStrength() {
        int strength = 0;
        for (Gems socket : gems) {
            if (socket != null) {
                strength += socket.getStrength();
            }
        }

        return strength;
    }

    private int getAgility() {
        int agility = 0;
        for (Gems socket : gems) {
            if (socket != null) {
                agility += socket.getAgility();
            }
        }

        return agility;
    }

    private int getVitality() {
        int vitality = 0;
        for (Gems socket : gems) {
            if (socket != null) {
                vitality += socket.getVitality();
            }
        }

        return vitality;
    }

    public double itemLevel(){
        return ((this.getMinDamage() + this.getMaxDamage()) / 2d) +
                this.getStrength() +
                this.getAgility() +
                this.getVitality();
    }

    @Override
    public String toString() {
        return String.format("%s: %d-%d Damage, +%d Strength, +%d Agility, +%d Vitality",
                this.name,
                this.getMinDamage(),
                this.getMaxDamage(),
                this.getStrength(),
                this.getAgility(),
                this.getVitality());
    }

    @Override
    public int compareTo(Weapon weapon) {
        return Double.compare(this.itemLevel(), weapon.itemLevel());
    }
}
