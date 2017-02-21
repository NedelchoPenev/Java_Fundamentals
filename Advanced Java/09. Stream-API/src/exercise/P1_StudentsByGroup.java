import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P1_StudentsByGroup {

    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        List<String> names = new ArrayList<>();

        while (true) {
            String[] input = console.readLine().split("\\s+");
            if (input[0].equals("END")) {
                break;
            }
            String name = input[0] + " " + input[1];
            if (input[2].equals("2")){
                names.add(name);
            }
        }

        names.stream().sorted((st1, st2) -> {
            String st1FirstName = st1.substring(0, st1.indexOf(" "));
            String st2FirstName = st2.substring(0, st2.indexOf(" "));
            return st1FirstName.compareTo(st2FirstName);
        }).forEach(System.out::println);

        console.close();
    }
}
