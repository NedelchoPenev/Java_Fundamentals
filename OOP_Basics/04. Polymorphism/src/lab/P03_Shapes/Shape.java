package lab.P03_Shapes;

public abstract class Shape {

    private double perimeter;
    private double area;

    private double getPerimeter() {
        return perimeter;
    }

    void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    private double getArea() {
        return area;
    }

    void setArea(double area) {
        this.area = area;
    }

    public abstract void calculatePerimeter();

    public abstract void calculateArea();
}
