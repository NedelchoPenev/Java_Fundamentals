package exercise.p04_Work_Force.models.employees;

import exercise.p04_Work_Force.contracts.Employable;

public abstract class Employee implements Employable {

    private String name;
    private int hoursPerWeek;

    protected Employee(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    protected void setHoursPerWeek(int hoursPerWeek){
        this.hoursPerWeek = hoursPerWeek;
    }

    @Override
    public int getHoursPerWeek() {
        return hoursPerWeek;
    }
}
