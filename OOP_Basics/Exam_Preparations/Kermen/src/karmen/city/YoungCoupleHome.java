package karmen.city;


public class YoungCoupleHome extends Home{

    private static final int ROOMS = 2;
    private static final double ROOMS_COST = 20;

    public YoungCoupleHome(double salary1, double salary2, double TV, double fridge, double laptop) {
        this.addNewPerson(salary1);
        this.addNewPerson(salary2);
        this.addNewDevice(TV);
        this.addNewDevice(fridge);
        this.addNewDevice(laptop);
        this.addNewDevice(laptop);
        this.addRoom(ROOMS, ROOMS_COST);
    }
}
