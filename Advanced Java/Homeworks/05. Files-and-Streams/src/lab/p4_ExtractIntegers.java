package lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class p4_ExtractIntegers {

    public static void main(String[] args){
        String input = "resources/input.txt";
        String output = "resources/output.txt";

        try (Scanner scanner = new Scanner(new FileInputStream(input));
             PrintWriter writer = new PrintWriter(new FileOutputStream(output))){

            while (scanner.hasNext()){
                if (scanner.hasNextInt()){
                    writer.println(scanner.nextInt());
                }
                scanner.next();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
