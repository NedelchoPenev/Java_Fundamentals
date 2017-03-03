package lab.P02_Method_Overriding;

public class Rectangle {

    private double sideA;
    private double sideB;

    public Rectangle(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public Rectangle(double sideA){
        this.sideA = sideA;
    }

    public double area(){
        return this.sideA * this.sideB;
    }
}
