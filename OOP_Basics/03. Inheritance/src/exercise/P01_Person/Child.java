package exercise.P01_Person;

public class Child extends Person{

    public Child(String name, int age) {
        super(name, age);
    }

    @Override
    protected void setAge(int age) {
        if (age > 15){
            throw new IllegalArgumentException("Child's age must be lesser than 15!");
        }
        super.setAge(age);
    }

//    @Override
//    public String toString() {
//        return super.toString();
//    }
}
