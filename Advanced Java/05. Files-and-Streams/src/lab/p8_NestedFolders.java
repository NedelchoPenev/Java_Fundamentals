package lab;

import java.io.File;
import java.util.ArrayDeque;

public class p8_NestedFolders {

    public static void main(String[] args) {
        final String inputPath = "resources/Files-and-Streams";
        File file = new File(inputPath);

        ArrayDeque<File> directories = new ArrayDeque<>();
        directories.offer(file);

        int count = 0;
        while (!directories.isEmpty()){
            File current = directories.poll();
            System.out.println(current.getName());
            count++;

            for (File dir : current.listFiles()) {
                if (dir.isDirectory()){
                    directories.offer(dir);
                }
            }
        }

        System.out.println(count + " folders");
    }
}
