package rpg_lab;

import java.util.List;

public class Dummy implements Target{

    private int health;
    private int experience;
    private List<Weapon> possibleLoot;

    public Dummy(int health, int experience, List<Weapon> possibleLoot) {
        this.health = health;
        this.experience = experience;
        this.possibleLoot = possibleLoot;
    }

    public int getHealth() {
        return this.health;
    }

    public void takeAttack(int attackPoints) {
        if (this.isDead()) {
            throw new IllegalStateException("Dummy is dead.");
        }

        this.health -= attackPoints;
    }

    public int giveExperience() {
        if (!this.isDead()) {
            throw new IllegalStateException("Target is not dead.");
        }

        return this.experience;
    }

    public boolean isDead() {
        return this.health <= 0;
    }

    public Weapon giveWeapon(RandomProvider random){
        if (!isDead()){
            throw new IllegalStateException("Target is dead!");
        }

        int index = random.nextInt(possibleLoot.size());
        return possibleLoot.get(index);
    }
}
