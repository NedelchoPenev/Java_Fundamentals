package exercise.P07_Food_Shortage;

public class Rebel implements Buyer{

    private String name;
    private int age;
    private String group;
    private int food;

    public Rebel(String name, int age, String group) {
        this.setName(name);
        this.setAge(age);
        this.setGroup(group);
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

    private String getGroup() {
        return group;
    }

    private void setGroup(String group) {
        this.group = group;
    }

    private void setFood(int food) {
        this.food = food;
    }

    @Override
    public int getFood() {
        return food;
    }

    @Override
    public void BuyFood() {
        this.setFood(this.getFood() + 5);
    }
}
