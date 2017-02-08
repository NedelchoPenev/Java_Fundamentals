import java.util.Scanner;

public class P2_StringLength {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        StringBuilder sentence = new StringBuilder(console.nextLine());

        if (sentence.length() >= 20) {
            System.out.println(sentence.substring(0, 20));
        } else {

            for (int i = sentence.length(); i < 20; i++) {
                sentence.append("*");
            }
            System.out.println(sentence);
        }

    }
}
