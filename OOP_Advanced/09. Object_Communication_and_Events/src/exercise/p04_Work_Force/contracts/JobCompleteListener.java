package exercise.p04_Work_Force.contracts;

import exercise.p04_Work_Force.models.events.JobCompletedEvent;

public interface JobCompleteListener {

    void handleJobCompleted(JobCompletedEvent event);
}
