package karmen.city;

public class Room {

    private double roomCost;

    public Room(double roomCost) {
        this.setRoomCost(roomCost);
    }

    public double getRoomCost() {
        return roomCost;
    }

    private void setRoomCost(double roomCost) {
        this.roomCost = roomCost;
    }
}
