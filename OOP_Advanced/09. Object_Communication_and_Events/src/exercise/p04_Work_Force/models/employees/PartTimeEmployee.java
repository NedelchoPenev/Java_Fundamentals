package exercise.p04_Work_Force.models.employees;

public class PartTimeEmployee extends Employee {

    private static final int WORKING_HOURS = 20;

    protected PartTimeEmployee(String name) {
        super(name);
        this.setHoursPerWeek(WORKING_HOURS);
    }
}
