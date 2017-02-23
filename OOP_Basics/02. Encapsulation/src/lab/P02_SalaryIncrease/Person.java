package lab.P02_SalaryIncrease;

public class Person {

    private String firstName;
    private String lastName;
    private double salary;
    private int age;

    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public double getSalary() {
        return salary;
    }

    private void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void increaseSalary(Integer bonus){
        if (this.getAge() > 30){
            this.salary += this.salary * bonus / 100;
        } else {
            this.salary += this.salary * bonus / 200;
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s get %s leva", this.firstName, this.lastName, this.salary);
    }
}
