package exercise;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class p03_ALL_CAPITALS {

    public static void main(String[] args) {
        String inputPath = "resources/input/text1.txt";
        String outputPath = "resources/output/output1.txt";

        try(BufferedReader reader = Files.newBufferedReader(Paths.get(inputPath));
            PrintWriter writer = new PrintWriter(new FileWriter(outputPath))) {

            String line = reader.readLine();
            while (line != null){
                writer.println(line.toUpperCase());
                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
