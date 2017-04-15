package exercise.p02_blobs.models.behavors;

import exercise.p02_blobs.interfaces.Behavior;

public abstract class AbstractBehavior implements Behavior {

    protected boolean isTriggered;
    protected boolean toDelayRecurrentEffect;

    public AbstractBehavior() {
    }

    public boolean isTriggered() {
        return this.isTriggered;
    }

    public void setIsTriggered(boolean isTriggered) {
        this.isTriggered = isTriggered;
    }

    public boolean toDelayRecurrentEffect() {
        return this.toDelayRecurrentEffect;
    }

    public void setToDelayRecurrentEffect(boolean toDelayRecurrentEffect){
        this.toDelayRecurrentEffect = toDelayRecurrentEffect;
    }
}
