package exercise.P09_Google;

public class Company {

    private String name;
    private String department;
    private double salary;

    public Company(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder company = new StringBuilder();
        company.append(String.format("%s %s %.2f", this.name, this.department, this.salary));
        return company.toString();
    }
}
