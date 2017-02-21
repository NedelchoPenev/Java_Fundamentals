package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P13_LittleJohn {

    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        Pattern pattern = Pattern.compile("(>----->)|(>>----->)|(>>>----->>)");
        int small = 0;
        int medium = 0;
        int large = 0;

        String line ;
        for (int i = 0; i < 4; i++) {
            String input = console.readLine();
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                if (matcher.group(1) != null) {
                    small++;
                } else if (matcher.group(2) != null) {
                    medium++;
                } else if (matcher.group(3) != null) {
                    large++;
                }
            }
        }

        String dec = String.valueOf(small) + String.valueOf(medium) + String.valueOf(large);
        String bin = Integer.toBinaryString(Integer.parseInt(dec));
        String reversedBin = new StringBuilder(bin).reverse().toString();

        bin = bin + reversedBin;
        System.out.println(Integer.parseInt(bin, 2));
    }
}
