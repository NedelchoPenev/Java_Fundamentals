package exercise.p01_02_Generic_Box;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        int lines = Integer.parseInt(console.readLine());
        for (int i = 0; i < lines; i++) {
            int input = Integer.parseInt(console.readLine());
            Box<Integer> box = new Box<>(input);
            System.out.println(box);
        }
    }
}
