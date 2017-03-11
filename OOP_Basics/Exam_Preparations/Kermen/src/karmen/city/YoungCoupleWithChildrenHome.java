package karmen.city;

import karmen.persons.Child;

import java.util.List;

public class YoungCoupleWithChildrenHome extends Home{

    private static final int ROOMS = 2;
    private static final double ROOMS_COST = 30;

    public YoungCoupleWithChildrenHome(double salary1,
                                       double salary2,
                                       double TV,
                                       double fridge,
                                       double laptop,
                                       List<Child> children) {

        this.addNewPerson(salary1);
        this.addNewPerson(salary2);
        this.addNewDevice(TV);
        this.addNewDevice(fridge);
        this.addNewDevice(laptop);
        this.addNewDevice(laptop);
        this.addNewChild(children);
        this.addRoom(ROOMS, ROOMS_COST);
    }
}
