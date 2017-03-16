package exercise.P08_Military_Elite.models;

public class Repaired {

    private String partName;
    private int hoursWorked;

    public Repaired(String partName, int hoursWorked) {
        this.partName = partName;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String toString() {
        return String.format("Part Name: %s Hours Worked: %d", this.partName, this.hoursWorked);
    }
}
