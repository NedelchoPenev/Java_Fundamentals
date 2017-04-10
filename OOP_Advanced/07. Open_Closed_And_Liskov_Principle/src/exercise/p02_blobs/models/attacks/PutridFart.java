package exercise.p02_blobs.models.attacks;


import exercise.p02_blobs.models.Blob;

public class PutridFart extends AbstractAttack {

    public void execute(Blob source, Blob target) {
        target.respond(source.getDamage());
    }
}
