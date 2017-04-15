package exercise.p04_Work_Force.models.events;

import java.util.EventObject;

public class JobCompletedEvent extends EventObject {

    public JobCompletedEvent(Object source) {
        super(source);
    }
}
