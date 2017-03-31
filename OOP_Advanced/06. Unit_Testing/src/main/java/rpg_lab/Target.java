package rpg_lab;

public interface Target {

    void takeAttack(int attackPoints);

    int getHealth();

    int giveExperience();

    Weapon giveWeapon(RandomProvider random);

    boolean isDead();
}

