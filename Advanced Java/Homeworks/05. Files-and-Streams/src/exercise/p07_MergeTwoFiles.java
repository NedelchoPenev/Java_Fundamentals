package exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class p07_MergeTwoFiles {

    public static void main(String[] args) {
        String firstInputPath = "resources/input/file1.txt";
        String secondInputPath = "resources/input/file2.txt";
        String outputPath = "resources/output/result1.txt";

        Path first = Paths.get(firstInputPath);
        Path second = Paths.get(secondInputPath);
        Path output = Paths.get(outputPath);

        try {
            List<String> firstList = Files.readAllLines(first);
            List<String> secondList = Files.readAllLines(second);
            firstList.addAll(secondList);
            Files.write(output, firstList);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
