package exercise;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class p09_CopyAPicture {

    public static void main(String[] args) {
        final String inputPath = "resources/input/stiu.jpg";
        final String outputPath = "resources/output/picture-copy.jpg";

        try (FileInputStream fis = new FileInputStream(inputPath);
             FileOutputStream fos = new FileOutputStream(outputPath)){

            byte[] buffer = new byte[4096];
            int readBytes = fis.read(buffer);

            while (readBytes != -1){
                fos.write(buffer);
                readBytes = fis.read(buffer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
