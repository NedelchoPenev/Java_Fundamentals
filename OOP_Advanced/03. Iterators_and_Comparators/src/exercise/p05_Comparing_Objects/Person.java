package exercise.p05_Comparing_Objects;

public class Person implements Comparable<Person>{

    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.setName(name);
        this.setAge(age);
        this.setTown(town);
    }

    @Override
    public int compareTo(Person person) {
        if (this.getName().compareTo(person.getName()) == 0){
            if (this.getAge() == person.getAge()){
                return this.town.compareTo(person.getTown());
            } else {
                return Integer.compare(this.getAge(), person.getAge());
            }
        } else {
            return this.getName().compareTo(person.getName());
        }
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

    private String getTown() {
        return town;
    }

    private void setTown(String town) {
        this.town = town;
    }
}
