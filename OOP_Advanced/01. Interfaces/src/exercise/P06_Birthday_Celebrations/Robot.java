package exercise.P06_Birthday_Celebrations;

public class Robot implements Indificable {

    private String model;
    private String id;

    public Robot(String model, String id) {
        this.setModel(model);
        this.setId(id);
    }

    @Override
    public String getId() {
        return this.id;
    }

    private String getModel() {
        return model;
    }

    private void setModel(String model) {
        this.model = model;
    }

    private void setId(String id) {
        this.id = id;
    }

}
