package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class p02_SumBytes {

    public static void main(String[] args) {
        String inputPath = "resources/input/text1.txt";
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputPath))){
            String line = reader.readLine();

            long sum = 0;
            while (line != null){
                for (char ch : line.toCharArray()) {
                    sum += ch;
                }
                line = reader.readLine();
            }
            System.out.println(sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
