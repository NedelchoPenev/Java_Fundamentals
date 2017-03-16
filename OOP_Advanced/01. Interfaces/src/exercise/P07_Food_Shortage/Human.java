package exercise.P07_Food_Shortage;

public class Human implements Buyer{

    private String name;
    private int age;
    private String id;
    private String birthday;
    private int food;

    public Human(String name, int age, String id, String birthday) {
        this.setName(name);
        this.setAge(age);
        this.setId(id);
        this.setBirthday(birthday);
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

    private void setFood(int food) {
        this.food = food;
    }

    @Override
    public void BuyFood() {
        this.setFood(this.getFood() + 10);
    }

    @Override
    public int getFood() {
        return food;
    }
}
