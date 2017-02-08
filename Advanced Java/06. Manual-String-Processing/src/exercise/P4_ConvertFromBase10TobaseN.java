import java.math.BigInteger;
import java.util.Scanner;

public class P4_ConvertFromBase10TobaseN {

    public static void main(String[] args) {

        Scanner console =  new Scanner(System.in);
        String[] input = console.nextLine().split(" ");
        int base = Integer.parseInt(input[0]);
        BigInteger number = new BigInteger(input[1]);
        System.out.println(number.toString(base));
    }
}
