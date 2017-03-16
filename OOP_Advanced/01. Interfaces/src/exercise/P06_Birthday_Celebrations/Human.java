package exercise.P06_Birthday_Celebrations;

public class Human implements Indificable, Birthable {

    private String name;
    private int age;
    private String id;
    private String birthday;

    public Human(String name, int age, String id, String birhtday) {
        this.setName(name);
        this.setAge(age);
        this.setId(id);
        this.setBirthday(birhtday);
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getBirthday() {
        return this.birthday;
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

    private void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
