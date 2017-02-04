package lab;

import java.util.Scanner;

public class P01_ReadInput {

    public static void main(String[] args) {
	    Scanner scanner =  new Scanner(System.in);
	    String firstWord = scanner.next(("\\w+"));
	    String secondWord = scanner.next(("\\w+"));
	    int firstNum = scanner.nextInt();
	    int secondNum = scanner.nextInt();
	    int thirdNum = scanner.nextInt();
	    scanner.nextLine();
	    String thirdWord = scanner.nextLine();

	    int sum = firstNum + secondNum + thirdNum;

        System.out.println(firstWord + " " + secondWord + " " + thirdWord + " " + sum);
    }
}
