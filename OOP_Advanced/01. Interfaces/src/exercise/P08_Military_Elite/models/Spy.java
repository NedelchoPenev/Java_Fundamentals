package exercise.P08_Military_Elite.models;

public class Spy extends Soldier {

    private int codeNumber;

    public Spy(int id, String firstName, String lastName, int codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(String.format("Code Number: %s%n", this.codeNumber));
        return sb.toString();
    }
}
