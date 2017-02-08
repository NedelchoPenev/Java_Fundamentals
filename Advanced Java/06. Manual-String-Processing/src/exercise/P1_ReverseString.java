package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1_ReverseString {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();

        StringBuilder sb = new StringBuilder(input).reverse();

        System.out.println(sb.toString());
    }
}
