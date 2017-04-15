package exercise.p04_Work_Force.models;

import exercise.p04_Work_Force.contracts.Employable;
import exercise.p04_Work_Force.contracts.JobCompleteListener;
import exercise.p04_Work_Force.contracts.Workable;
import exercise.p04_Work_Force.models.events.JobCompletedEvent;

import java.util.ArrayList;
import java.util.List;

public class Job implements Workable {

    private String name;
    private int hoursOfWorkRequired;
    private Employable employable;
    private List<JobCompleteListener> observers;

    public Job(String name, int hoursOfWorkRequired, Employable employable) {
        this.name = name;
        this.hoursOfWorkRequired = hoursOfWorkRequired;
        this.employable = employable;
        this.observers = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHoursOfWorkRequired() {
        return hoursOfWorkRequired;
    }

    @Override
    public void update() {
        this.hoursOfWorkRequired -= employable.getHoursPerWeek();
        if(this.getHoursOfWorkRequired() <= 0){
            System.out.println(String.format("Job %s done!",this.getName()));
            fireJobCompletedEvent();
        }
    }

    public void addJobCompletedListener(JobCompleteListener listener){
        this.observers.add(listener);
    }

    public void removeJobCompletedListener(JobCompleteListener listener){
        this.observers.remove(listener);
    }

    public void fireJobCompletedEvent(){
        JobCompletedEvent event = new JobCompletedEvent(this);
        for (JobCompleteListener observer : observers) {
            observer.handleJobCompleted(event);
        }
    }

    @Override
    public String toString() {
        return String.format("Job: %s Hours Remaining: %d", this.getName(), this.getHoursOfWorkRequired());
    }
}
