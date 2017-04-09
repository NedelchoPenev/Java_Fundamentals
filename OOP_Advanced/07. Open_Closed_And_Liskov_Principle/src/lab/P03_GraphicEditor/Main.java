package lab.P03_GraphicEditor;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        GraphicEditor graphicEditor = new GraphicEditor();

        List<Shape> shapes = new ArrayList<>();

        Circle circle = new Circle();
        Rectangle rectangle = new Rectangle();
        shapes.add(circle);
        shapes.add(rectangle);
        shapes.add(circle);

        shapes.forEach(graphicEditor::drawShape);
    }
}
