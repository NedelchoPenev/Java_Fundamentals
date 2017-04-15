package exercise.p04_Work_Force.models;

import exercise.p04_Work_Force.contracts.JobCompleteListener;
import exercise.p04_Work_Force.models.events.JobCompletedEvent;

import java.util.ArrayList;

public class MyList<T> extends ArrayList<T> implements JobCompleteListener {

    @Override
    public void handleJobCompleted(JobCompletedEvent event) {
        this.remove(event.getSource());
    }
}
