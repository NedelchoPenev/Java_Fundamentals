package exercise;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class p04_CountCharacterTypes {

    public static void main(String[] args) {
        String inputPath = "resources/input/text2.txt";
        String outputPath = "resources/output/output2.txt";

        try(BufferedReader reader = Files.newBufferedReader(Paths.get(inputPath));
            PrintWriter writer = new PrintWriter(new FileWriter(outputPath))) {

            int vowelsCount = 0;
            int consonantsCount = 0;
            int punctuationCount = 0;
            String line = reader.readLine();
            while (line != null) {
                for (char ch : line.toLowerCase().toCharArray()) {
                    if (Character.isLetter(ch)){
                        if (ch == 'e' || ch == 'a' || ch == 'i' || ch == 'o' || ch == 'u'){
                            vowelsCount++;
                        } else {
                            consonantsCount++;
                        }
                    } else if (ch == '!' || ch == '?' || ch == '.' || ch == ','){
                        punctuationCount++;
                    }
                }

                line = reader.readLine();
            }

            writer.write(String.format("Vowels: %d%nConsonants: %d%nPunctuation: %d",
                    vowelsCount, consonantsCount, punctuationCount));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
