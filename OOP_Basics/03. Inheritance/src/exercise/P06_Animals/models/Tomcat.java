package exercise.P06_Animals.models;

public class Tomcat extends Cat {

    public Tomcat(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    protected void setGender(String gender) {
        if (!gender.equals("Male")){
            gender = "Male";
        }
        super.setGender(gender);
    }

    @Override
    public String soundProduce() {
        return "Give me one million b***h";
    }
}
