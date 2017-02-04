package lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class p2_WriteToAFile {

    public static void main(String[] args) throws FileNotFoundException {
        String input = "resources/input.txt";
        String output = "resources/output.txt";

        List<Character> symbols = new ArrayList<>();
        Collections.addAll(symbols, '.', ',', '!', '?');

        try (FileInputStream fis = new FileInputStream(input);
             FileOutputStream fos = new FileOutputStream(output)) {

            int oneByte = fis.read();
            while (oneByte >= 0){
                if (!symbols.contains((char)oneByte)){
                    fos.write(oneByte);
                }
                oneByte = fis.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
