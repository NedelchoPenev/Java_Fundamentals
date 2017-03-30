package exercise.p09_Traffic_Lights;

public class TrafficLight {

    private Lights light;

    public TrafficLight(Lights light) {
        this.light = light;
    }

    public void update(){
        switch (this.light){
            case RED:
                this.light = Lights.GREEN;
                break;
            case GREEN:
                this.light = Lights.YELLOW;
                break;
            case YELLOW:
                this.light = Lights.RED;
                break;
        }
    }

    @Override
    public String toString() {
        return this.light.name();
    }
}
