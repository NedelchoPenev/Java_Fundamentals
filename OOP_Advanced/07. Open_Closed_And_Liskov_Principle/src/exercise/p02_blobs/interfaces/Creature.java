package exercise.p02_blobs.interfaces;

public interface Creature extends Attacker, Attackable, Behaveable, Observable{

    String getName();

    int getHealth();

    int getDamage();

    void setDamage(int damage);

    void setHealth(int health);

    void update();
}
