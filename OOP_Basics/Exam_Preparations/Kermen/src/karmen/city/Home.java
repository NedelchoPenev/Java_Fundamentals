package karmen.city;

import karmen.items.Device;
import karmen.persons.Child;
import karmen.persons.Person;

import java.util.ArrayList;
import java.util.List;

public abstract class Home {

    private List<Person> people;
    private List<Device> devices;
    private List<Child> children;
    private List<Room> rooms;
    private double income;
    private double bills;

    Home() {
        this.people = new ArrayList<>();
        this.devices = new ArrayList<>();
        this.children = new ArrayList<>();
        this.rooms = new ArrayList<>();
    }

    void addNewPerson(double salary){
        this.people.add(new Person(salary));
    }

    void addNewChild(List<Child> children){
        this.children.addAll(children);
    }

    void addNewDevice(double cost){
        this.devices.add(new Device(cost));
    }

    void addRoom(int numberOfRooms, double roomCost){
        for (int i = 0; i < numberOfRooms; i++) {
            this.rooms.add(new Room(roomCost));
        }
    }

    int getNumberOfPeople(){
        return this.people.size() + this.children.size();
    }

    double getHomeConsummation(){
        return this.devices.stream().mapToDouble(Device::getCost).sum() +
                this.children.stream().mapToDouble(Child::getTotalChildCost).sum() +
                this.rooms.stream().mapToDouble(Room::getRoomCost).sum();
    }

    public void paySalary(){
        this.income += this.people.stream().mapToDouble(Person::getIncome).sum();
    }

    public double getIncome() {
        return income;
    }

    public void payBills(){
        this.income -= this.getHomeConsummation();
    }
}
