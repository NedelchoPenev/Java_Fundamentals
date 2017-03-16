package exercise.P05_Border_Control;

public class Human implements Indificable {

    private String name;
    private int age;
    private String id;

    public Human(String name, int age, String id) {
        this.setName(name);
        this.setAge(age);
        this.setId(id);
    }

    @Override
    public String getId() {
        return this.id;
    }

    private String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    private int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    private void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.getId();
    }
}
