package karmen.persons;

public class Person {

    private double income;

    public Person(double salary) {
        this.setIncome(salary);
    }

    public double getIncome() {
        return income;
    }

    private void setIncome(double income) {
        this.income = income;
    }
}
