package karmen.city;

public class AloneYoungHome extends Home{

    private static final int ROOMS = 1;
    private static final double ROOMS_COST = 10;

    public AloneYoungHome(double income, double laptop) {
        this.addNewPerson(income);
        this.addNewDevice(laptop);
        this.addRoom(ROOMS, ROOMS_COST);
    }
}
