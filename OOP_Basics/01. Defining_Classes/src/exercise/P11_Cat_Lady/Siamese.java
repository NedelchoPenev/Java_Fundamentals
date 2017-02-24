package exercise.P11_Cat_Lady;

public class Siamese extends Cat{

    private int decibelsOfMeows;

    public Siamese(String name, int decibelsOfMeows) {
        super(name);
        this.decibelsOfMeows = decibelsOfMeows;
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.decibelsOfMeows;
    }
}
