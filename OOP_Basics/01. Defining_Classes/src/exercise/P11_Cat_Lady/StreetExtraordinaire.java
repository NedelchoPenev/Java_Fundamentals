package exercise.P11_Cat_Lady;

public class StreetExtraordinaire extends Cat{

    private int earSize;

    public StreetExtraordinaire(String name, int earSize) {
        super(name);
        this.earSize = earSize;
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.earSize;
    }
}
