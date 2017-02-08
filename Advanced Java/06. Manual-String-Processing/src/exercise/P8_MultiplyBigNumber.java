package exercise;

import java.util.Scanner;

public class P8_MultiplyBigNumber {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        String number = console.nextLine();
        int multiplier = console.nextInt();
        StringBuilder result = new StringBuilder();
        if (multiplier == 0){
            System.out.println(0);
            return;
        }

        int remainder = 0;
        for (int i = number.length() - 1; i >= 0; i--) {
            String fNum = String.valueOf((number.charAt(i)));
            int addition = (Integer.parseInt(fNum) * multiplier) + remainder;
            String numToApp = Integer.toString(addition);
            if (numToApp.length() > 1) {
                remainder = Integer.parseInt(String.valueOf(numToApp.charAt(0)));
                result.append(numToApp.charAt(1));
            } else {
                remainder = 0;
                result.append(numToApp);
            }
        }

        if (remainder != 0){
            result.append(Integer.toString(remainder));
        }

        result.reverse();
        while (result.charAt(0) == '0'){
            result.deleteCharAt(0);
    }
        System.out.println(result);
    }
}
