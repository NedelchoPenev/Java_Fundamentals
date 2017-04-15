package exercise.p02_blobs.models.attacks;


import exercise.p02_blobs.interfaces.Creature;

public class PutridFart extends AbstractAttack {

    @Override
    public void execute(Creature source, Creature target) {
        target.respond(source.getDamage());
    }
}
