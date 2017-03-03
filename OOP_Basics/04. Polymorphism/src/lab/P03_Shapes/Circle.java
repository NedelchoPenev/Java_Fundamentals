package lab.P03_Shapes;

public class Circle extends Shape{

    private double radius;

    public Circle(double radius) {
        this.setRadius(radius);
    }

    private final double getRadius() {
        return radius;
    }

    private void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public void calculatePerimeter() {
        super.setPerimeter(this.getRadius() * Math.PI * 2);
    }

    @Override
    public void calculateArea() {
        super.setArea(this.getRadius() * this.getRadius() * Math.PI);
    }
}
