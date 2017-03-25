package exercise.p08_Pet_Clinics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Clinic implements Iterable {

    private String name;
    private int numberOfRooms;
    private List<Pet> pets;
    private boolean isAddCommand;

    public Clinic(String name, int numberOfRooms) {
        this.setName(name);
        this.setNumberOfRooms(numberOfRooms);
        this.pets = new ArrayList<>(numberOfRooms);
    }

    private String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    private int getNumberOfRooms() {
        return numberOfRooms;
    }

    private void setNumberOfRooms(int numberOfRooms) {
        if (numberOfRooms % 2 == 0){
            throw new IllegalArgumentException("Invalid Operation!");
        }
        this.numberOfRooms = numberOfRooms;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    private final class addIterator implements Iterator<Integer>{

        private int index;
        private int moveRight;
        private int moveLeft;
        private boolean isRight;
        private boolean firstMove = true;

        private addIterator(int index) {
            this.index = index;
        }

        @Override
        public boolean hasNext() {
            return this.moveRight < pets.size() || this.moveLeft > 0;
        }

        @Override
        public Integer next() {
            if (this.firstMove){
                this.moveRight = this.index;
                this.moveLeft = this.index;
                this.firstMove = false;
                this.isRight = true;
                return this.index;
            } else if (isRight){
                this.moveRight++;
                this.isRight = false;
                return this.moveRight;
            } else {
                this.moveLeft--;
                this.isRight = true;
                return this.moveLeft;
            }
        }
    }
}
