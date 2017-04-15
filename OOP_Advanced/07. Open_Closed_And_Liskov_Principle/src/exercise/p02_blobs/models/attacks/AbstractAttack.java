package exercise.p02_blobs.models.attacks;

import exercise.p02_blobs.interfaces.Attack;
import exercise.p02_blobs.interfaces.Creature;

public abstract class AbstractAttack implements Attack {

    public abstract void execute(Creature attacker, Creature target);
}
