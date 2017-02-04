package exercise;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class p06_WordCount {

    public static void main(String[] args) {
        String inputPath = "resources/input/wordsCount.txt";
        String targetPath = "resources/input/words.txt";
        String outputPath = "resources/output/result.txt";

        try(BufferedReader textReader = Files.newBufferedReader(Paths.get(inputPath));
            BufferedReader wordsReader = Files.newBufferedReader(Paths.get(targetPath));
            PrintWriter writer = new PrintWriter(new FileWriter(outputPath))) {

            TreeMap<String, Integer> words = new TreeMap<>(String::compareToIgnoreCase);
            String searchedWords = wordsReader.readLine();
            while (searchedWords != null){
                String[] split = searchedWords.split("\\s+");
                for (String word : split) {
                    words.put(word, 0);
                }

                searchedWords = wordsReader.readLine();
            }

            String line = textReader.readLine();
            while (line != null){
                String[] split = line.split("\\W+");
                for (String word : split) {
                    if (words.containsKey(word)){
                        words.put(word, words.get(word) + 1);
                    }
                }

                line = textReader.readLine();
            }

            words.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                    .forEach(k -> writer.println(String.format("%s - %d", k.getKey(), k.getValue())));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
