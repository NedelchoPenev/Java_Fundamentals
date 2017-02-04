package exercise;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class p10_SerializeArrayList {

    public static void main(String[] args) throws ClassNotFoundException {
        final String inputPath = "resources/input/list.ser";
        final String outputPath = "resources/input/list.ser";

        List<Double> numbers = new ArrayList<>();
        Collections.addAll(numbers, 5.5, 6.5, 432.34);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputPath));
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inputPath))) {

            oos.writeObject(numbers);

            List<Double> serializedNumbers = (List<Double>) ois.readObject();
            serializedNumbers.add(45.2);

            System.out.println(serializedNumbers);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
