package exercise.P08_Military_Elite.models;

import exercise.P08_Military_Elite.interfaces.iSoldier;

public abstract class Soldier implements iSoldier {

    private int id;
    private String firstName;
    private String lastName;
    private double salary;
    private boolean useOfFourArgConstructor = false;

    protected Soldier(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    protected Soldier(int id, String firstName, String lastName, double salary) {
        this.setId(id);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setSalary(salary);
        this.useOfFourArgConstructor = true;
    }

    @Override
    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public double getSalary() {
        return salary;
    }

    private void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        if (useOfFourArgConstructor) {
            return String.format("Name: %s %s Id: %d Salary: %.2f%n",
                    this.getFirstName(),
                    this.getLastName(),
                    this.getId(),
                    this.getSalary());
        } else {
            return String.format("Name: %s %s Id: %d%n",
                    this.getFirstName(),
                    this.getLastName(),
                    this.getId());
        }
    }
}
