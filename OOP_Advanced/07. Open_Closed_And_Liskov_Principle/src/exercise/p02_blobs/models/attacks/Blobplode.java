package exercise.p02_blobs.models.attacks;

import exercise.p02_blobs.interfaces.Creature;

public class Blobplode extends AbstractAttack {

    private static final int BLOBPLODE_DAMAGE_MULTIPLIER = 2;

    @Override
    public void execute(Creature attacker, Creature target) {
        this.affectSource(attacker);
        this.affectTarget(attacker, target);
    }

    private void affectTarget(Creature attacker, Creature target) {
        target.respond(attacker.getDamage() * BLOBPLODE_DAMAGE_MULTIPLIER);
    }

    private void affectSource(Creature attacker) {
        attacker.setHealth(attacker.getHealth() - attacker.getHealth() / BLOBPLODE_DAMAGE_MULTIPLIER);
    }
}
