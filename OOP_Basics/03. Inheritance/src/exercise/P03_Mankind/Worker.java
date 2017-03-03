package exercise.P03_Mankind;

public class Worker extends Human{

    private double weekSalary;
    private double workHours;

    public Worker(String firstName, String lastName, double weekSalary, double workHours) {
        super(firstName, lastName);
        this.setWeekSalary(weekSalary);
        this.setWorkHours(workHours);
    }

    @Override
    protected void setLastName(String lastName) {
        if (lastName.length() < 3){
            throw new IllegalArgumentException("Expected length more than 3 symbols!Argument: lastName");
        }
        super.setLastName(lastName);
    }

    private double getWeekSalary() {
        return weekSalary;
    }

    private void setWeekSalary(double weekSalary) {
        if (weekSalary < 10){
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }
        this.weekSalary = weekSalary;
    }

    private double getWorkHours() {
        return workHours;
    }

    private void setWorkHours(double workHours) {
        if (workHours < 1 || workHours > 12){
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.workHours = workHours;
    }

    private double getSalaryPerHour(){
        return (this.getWeekSalary() / this.getWorkHours()) / 7;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString())
                .append(System.lineSeparator());
        sb.append(String.format("Week Salary: %.2f", this.getWeekSalary()))
                .append(System.lineSeparator());
        sb.append(String.format("Hours per day: %.2f", this.getWorkHours()))
                .append(System.lineSeparator());
        sb.append(String.format("Salary per hour: %.2f", this.getSalaryPerHour()));

        return sb.toString();
    }
}

