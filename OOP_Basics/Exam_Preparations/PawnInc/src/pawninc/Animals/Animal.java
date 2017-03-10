package pawninc.Animals;

public abstract class Animal {

    private String name;
    private int age;
    private boolean isCleansed;
    private boolean isCastrated;
    private String adoptionCenter;

    protected Animal(String name, int age){
        this.setName(name);
        this.setAge(age);
    }

    protected Animal(String name, int age, String adoptionCenter) {
        this(name, age);
        this.setName(name);
        this.setAge(age);
        this.isCleansed = false;
        this.isCastrated = false;
        this.setAdoptionCenter(adoptionCenter);
    }

    public String getName() {
        if (name == null || name.trim().length() == 0){
            throw new IllegalArgumentException("Invalid input");
        }
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        if (age < 0){
            throw new IllegalArgumentException("Invalid input");
        }
        this.age = age;
    }

    public boolean isCleansed() {
        return isCleansed;
    }

    public boolean isCastrated() {
        return isCastrated;
    }

    private void setCleansed(boolean cleansed) {
        isCleansed = cleansed;
    }

    public String getAdoptionCenter() {
        return adoptionCenter;
    }

    private void setAdoptionCenter(String adoptionCenter) {
        this.adoptionCenter = adoptionCenter;
    }

    public void cleanse(){
        this.isCleansed = true;
    }

    public void castrate(){
        this.isCastrated = true;
    }
}
