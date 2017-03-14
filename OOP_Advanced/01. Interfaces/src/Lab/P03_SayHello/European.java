package Lab.P03_SayHello;

public class European implements Person {

    private String name;

    public European(String name) {
        this.setName(name);
    }

    @Override
    public String getName() {
        return this.getName();
    }

    private void setName(String name) {
        this.name = name;
    }
}
