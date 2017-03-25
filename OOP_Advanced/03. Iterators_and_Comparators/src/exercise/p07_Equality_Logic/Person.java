package exercise.p07_Equality_Logic;

public class Person implements Comparable<Person>{

    private String name;
    private int age;

    public Person(String name, int age) {
        this.setName(name);
        this.setAge(age);
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

    @Override
    public int hashCode() {
        return this.getName().hashCode() * this.getAge();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Person)) return false;

        Person person = (Person) obj;

        return this.getName().equals(person.getName()) && this.getAge() == this.getAge();
    }

    @Override
    public int compareTo(Person o) {
        int result = this.getName().compareTo(o.getName());
        if (result == 0){
            result = this.getAge() - o.getAge();
        }

        return result;
    }
}
