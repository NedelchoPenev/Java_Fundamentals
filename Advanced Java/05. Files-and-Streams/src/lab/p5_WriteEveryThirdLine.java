package lab;

import java.io.*;

public class p5_WriteEveryThirdLine {

    public static void main(String[] args) throws IOException {
        String input = "resources/input.txt";
        String output = "resources/output.txt";

        try (BufferedReader bf = new BufferedReader(new FileReader(input));
        PrintWriter writer = new PrintWriter(new FileWriter(output))){

            String line = bf.readLine();
            int lines = 1;
            while (line != null){
                if (lines % 3 == 0){
                    writer.println(line);
                }
                lines++;
                line = bf.readLine();
            }
        }
    }
}
