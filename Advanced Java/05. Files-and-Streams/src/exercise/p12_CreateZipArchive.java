package exercise;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class p12_CreateZipArchive {

    public static void main(String[] args) {
        String[] inputOutputPath = {"resources/input/text.txt",
                "resources/input/text1.txt",
                "resources/input/text2.txt"};
        String outputPath = "resources/output/files.zip";

        try (ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(outputPath))){

            byte[] buffer = new byte[1024];
            for (int i = 0; i < inputOutputPath.length; i++) {
                File file = new File(inputOutputPath[i]);
                FileInputStream inputStream = new FileInputStream(file);
                zip.putNextEntry(new ZipEntry(file.getName()));
                int length;
                while ((length = inputStream.read(buffer)) > 0 ){
                    zip.write(buffer, 0, length);
                }

                zip.closeEntry();
                inputStream.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
