package exercise.p10_11_TupleAndThreeuple;

public class Threeuple<E1, E2, E3> {

    private E1 item1;
    private E2 item2;
    private E3 item3;

    public Threeuple(E1 item1, E2 item2, E3 item3) {
        this.setItem1(item1);
        this.setItem2(item2);
        this.setItem3(item3);
    }

    private E1 getItem1() {
        return item1;
    }

    private void setItem1(E1 item1) {
        this.item1 = item1;
    }

    private E2 getItem2() {
        return item2;
    }

    private void setItem2(E2 item2) {
        this.item2 = item2;
    }

    private E3 getItem3() {
        return item3;
    }

    private void setItem3(E3 item3) {
        this.item3 = item3;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s -> %s", this.getItem1(), this.getItem2(), this.getItem3());
    }
}
