package lab.P03_SayHello;

public class Chinese implements Person {

    private String name;

    public Chinese(String name) {
        this.setName(name);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String sayHello() {
        return "Djydjybydjy";
    }

    private void setName(String name) {
        this.name = name;
    }
}
