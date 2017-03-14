package lab.P03_SayHello;

public class Bulgarian implements Person {

    private String name;

    public Bulgarian(String name) {
        this.setName(name);
    }

    @Override
    public String getName() {
        return this.getName();
    }

    @Override
    public String sayHello() {
        return "Здравей";
    }

    private void setName(String name) {
        this.name = name;
    }
}
