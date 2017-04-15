package exercise.p02_blobs.interfaces;

public interface Attacker {

    public int getDamage();

    public void setDamage(int currentDamage);

    public void attack(Creature target);
}
