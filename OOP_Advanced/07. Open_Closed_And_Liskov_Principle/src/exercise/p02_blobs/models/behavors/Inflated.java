package exercise.p02_blobs.models.behavors;

import exercise.p02_blobs.interfaces.Creature;

public class Inflated extends AbstractBehavior {

    private static final int GAINS_EFFECT = 50;
    private static final int INFLATED_HEALTH_DECREMENT = 10;

    @Override
    public void trigger(Creature source) {
        super.setIsTriggered(true);
        this.applyTriggerEffect(source);
    }

    private void applyTriggerEffect(Creature source) {
        source.setHealth(source.getHealth() + GAINS_EFFECT);
    }

    @Override
    public void applyRecurrentEffect(Creature source) {
        if (super.toDelayRecurrentEffect()) {
            super.setToDelayRecurrentEffect(false);
        } else {
            source.setHealth(source.getHealth() - INFLATED_HEALTH_DECREMENT);
        }
    }
}
