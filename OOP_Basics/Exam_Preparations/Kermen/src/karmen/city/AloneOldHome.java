package karmen.city;

public class AloneOldHome extends Home{

    private static final int ROOMS = 1;
    private static final double ROOM_COST = 15;

    public AloneOldHome(double pension) {
        this.addNewPerson(pension);
        this.addRoom(ROOMS, ROOM_COST);
    }
}
