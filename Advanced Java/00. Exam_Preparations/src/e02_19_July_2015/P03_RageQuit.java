package e02_19_July_2015;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.ArrayList;
        import java.util.HashSet;
        import java.util.List;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

public class P03_RageQuit {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String input = console.readLine();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(input);

        String[] split = input.split("\\d+");
        List<Integer> numbers = new ArrayList<>();
        while (matcher.find()) {
            numbers.add(Integer.parseInt(matcher.group()));
        }

        HashSet<Character> symbols = new HashSet<>();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            result.append(new String(new char[numbers.get(i)]).replace("\0", split[i]));
            if (numbers.get(i) != 0) {
                for (Character letter : split[i].toUpperCase().toCharArray()) {
                    symbols.add(letter);
                }
            }
        }

        System.out.printf("Unique symbols used: %d%n", symbols.size());
        System.out.println(result.toString().toUpperCase());
    }
}
