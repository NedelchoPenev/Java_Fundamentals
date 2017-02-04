package lab;

import java.io.File;

public class p7_ListFiles {

    public static void main(String[] args) {
        final String inputPath = "resources/Files-and-Streams";
        File file = new File(inputPath);

        if (file.exists()){
            if (file.isDirectory()){
                File[] files = file.listFiles();
                for (File file1 : files) {
                    if (!file1.isDirectory()){
                        System.out.println(file1.getName() + ": " + file1.length());
                    }
                }
            }
        }
    }
}
