package lab;

import java.io.FileInputStream;
import java.io.IOException;

public class p1_ReadFile {

    public static void main(String[] args) {
        String path = "resources/input.txt";

        try (FileInputStream fis = new FileInputStream(path)){
            int oneByte = fis.read();
            while (oneByte >= 0){
                System.out.printf("%s ", Integer.toBinaryString(oneByte));
                oneByte = fis.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
