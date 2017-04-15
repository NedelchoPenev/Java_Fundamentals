package exercise.p04_Work_Force.models.employees;

public class StandartEmployee extends Employee {

    private static final int WORKING_HOURS = 40;

    protected StandartEmployee(String name) {
        super(name);
        this.setHoursPerWeek(WORKING_HOURS);
    }
}
