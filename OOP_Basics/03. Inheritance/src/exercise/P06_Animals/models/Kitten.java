package exercise.P06_Animals.models;

public class Kitten extends Cat {

    public Kitten(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    protected void setGender(String gender) {
        if (!gender.equals("Female")){
            gender = "Female";
        }
        super.setGender(gender);
    }

    @Override
    public String soundProduce() {
        return "Miau";
    }
}
