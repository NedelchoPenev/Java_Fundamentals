package exercise.P09_Google;

public class Parent {

    private String name;
    private String dateOfBirth;

    public Parent(String name, String dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public String toString() {
        StringBuilder parent = new StringBuilder();
        parent.append(String.format("%s %s", this.name, this.dateOfBirth));
        return parent.toString();
    }
}
