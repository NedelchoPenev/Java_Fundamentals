package exercise.P09_Google;

public class Child {

    private String name;
    private String dateOfBirth;

    public Child(String name, String dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        StringBuilder child = new StringBuilder();
        child.append(String.format("%s %s", this.name, this.dateOfBirth));
        return child.toString();
    }
}
