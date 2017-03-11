package karmen.city;

public class OldCoupleHome extends Home{

    private static final int ROOMS = 3;
    private static final double ROOMS_COST = 15;

    public OldCoupleHome(double pension1, double pension2, double TV, double fridge, double stove) {
        this.addNewPerson(pension1);
        this.addNewPerson(pension2);
        this.addNewDevice(TV);
        this.addNewDevice(fridge);
        this.addNewDevice(stove);
        this.addRoom(ROOMS, ROOMS_COST);
    }
}
