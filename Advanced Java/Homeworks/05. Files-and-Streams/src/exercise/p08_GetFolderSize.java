package exercise;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class p08_GetFolderSize {

    public static void main(String[] args) {
        final String inputPath = "resources/Files-and-Streams/Files-and-Streams";
        File file = new File(inputPath);

        Deque<File> files = new ArrayDeque<>();
        files.offer(file);
        long bytes = 0;

        while (!files.isEmpty()) {
            File current = files.poll();
            for (File file1 : current.listFiles()) {
                if (file1.isDirectory()) {
                    files.offer(file1);
                } else {
                    bytes += file1.length();
                }
            }
        }

        System.out.printf("Folder size: %s", bytes);
    }
}
