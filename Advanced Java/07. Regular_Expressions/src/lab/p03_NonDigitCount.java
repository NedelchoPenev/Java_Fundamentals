package lab;

        import java.util.Scanner;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

public class P03_NonDigitCount {

    public static void main(String[] args) {
        Scanner console =  new Scanner(System.in);
        String text = console.nextLine();

        Pattern pattern = Pattern.compile("\\D");
        Matcher matcher = pattern.matcher(text);

        int counter = 0;
        while (matcher.find()){
            counter++;
        }

        System.out.printf("Non-digits: %d", counter);
    }
}
