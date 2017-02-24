package exercise.P11_Cat_Lady;

public class Cat {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.getClass().getSimpleName(), this.name);
    }
}
