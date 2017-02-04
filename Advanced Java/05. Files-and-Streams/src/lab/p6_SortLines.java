package lab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class p6_SortLines {

    public static void main(String[] args) {
        final String inputPath = "resources/input.txt";
        final String outputPath = "resources/output.txt";

        Path input = Paths.get(inputPath);
        Path output = Paths.get(outputPath);

        try {
            List<String> allLines = Files.readAllLines(input);
            Collections.sort(allLines);
            Files.write(output, allLines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
