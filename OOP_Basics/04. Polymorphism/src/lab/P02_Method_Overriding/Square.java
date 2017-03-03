package lab.P02_Method_Overriding;

public class Square extends Rectangle {

    private double sideA;

    public Square(double side) {
        super(side);
        this.sideA = side;
    }

    @Override
    public double area() {
        return this.sideA * this.sideA;
    }
}
