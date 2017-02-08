import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P09_ValidUsernames{

    public static void main(String[] args) {

        Scanner console =  new Scanner(System.in);
        String[] input = console.nextLine().split("[\\s\\\\/()]+");
        Pattern pattern = Pattern.compile("^[A-Za-z][\\w\\d]{2,24}$");

        List<String> usernames = new ArrayList<>();
        for (String word : input) {
            Matcher matcher = pattern.matcher(word);
            if (matcher.find()){
                usernames.add(matcher.group());
            }
        }

        int bestLenght = 0;
        int index = 0;
        for (int i = 0; i < usernames.size() - 1; i++) {
            if (usernames.get(i).length() + usernames.get(i + 1).length() > bestLenght){
                index = i;
                bestLenght = usernames.get(i).length() + usernames.get(i + 1).length();
            }
        }

        for (int i = index; i < index + 2; i++) {
            System.out.println(usernames.get(i));
        }
    }
}
