package lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalInt;

public class P06_FindAndSumIntegers {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        OptionalInt sum = Arrays.stream(console.readLine().split("\\s+"))
                .filter(x -> isNumber(x))
                .mapToInt(Integer::parseInt)
                .reduce((n1, n2) -> n1 + n2);

        if (sum.isPresent()){
            System.out.println(sum.getAsInt());
        } else {
            System.out.println("No match");
        }
    }

    private static boolean isNumber(String num){
        if (num == null){
            return false;
        } if (num.isEmpty()){
            return false;
        } if (!Character.isDigit(num.charAt(0)) && !isSign(num.charAt(0))){
            return false;
        }
        for (int i = 1; i < num.length(); i++) {
            if (!Character.isDigit(num.charAt(i))){
                return false;
            }
        }

        return true;
    }

    private static boolean isSign(char ch){
        return ch == '-' || ch == '+';
    }
}
