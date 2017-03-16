package exercise.P06_Birthday_Celebrations;

public class Pet implements Indificable, Birthable {

    private String name;
    private String birthday;

    public Pet(String name, String birthday) {
        this.setName(name);
        this.setBirthday(birthday);
    }

    @Override
    public String getId() {
        return null;
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

    private void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
