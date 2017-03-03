package exercise.P06_Animals.models;

public abstract class Animal extends SoundProducible {

    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    private String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().equals("")){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name = name;
    }

    private int getAge() {
        return age;
    }

    private void setAge(int age) {
        if (age < 1){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age = age;
    }

    private String getGender() {
        return gender;
    }

    protected void setGender(String gender) {
        if (!gender.equals("Female") && !gender.equals("Male")){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.gender = gender;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName()).append(System.lineSeparator());
        sb.append(String.format("%s %s %s", this.getName(), this.getAge(), this.getGender()));
        return sb.toString();
    }
}
